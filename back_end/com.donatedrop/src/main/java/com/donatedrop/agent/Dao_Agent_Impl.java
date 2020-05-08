package com.donatedrop.agent;

import com.donatedrop.util.StringUtil;
import org.hibernate.exception.ConstraintViolationException;
//import org.hibernate.exception.ConstraintViolationException;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Component
public class Dao_Agent_Impl implements Dao_Agent_I {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * @param agentRequest
     * @return
     * @apiNote for successful save, saved id will be back. OK status
     */
    @Override
    public Map<String, String> saveRequest(AgentRequest agentRequest) {
        Map<String, String> result = new HashMap<>();
        try {
            entityManager.persist(agentRequest);
            result.put(StringUtil.STATUS, StringUtil.OK);
            result.put(StringUtil.MESSAGE, StringUtil.SAVE);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
            result.put(StringUtil.MESSAGE, StringUtil.DUPLICATE);
        } catch (ConstraintViolationException constraintViolationException) {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
            result.put(StringUtil.MESSAGE, StringUtil.DUPLICATE);
        } catch (Exception e) {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
            result.put(StringUtil.MESSAGE, StringUtil.UNKNOWN);
        }
        return result;
    }

    @Override
    public Map<String, String> deleteRequest(String userID) {
        Map<String, String> result = new HashMap<>();
        String requestID = getAgentRequestByUserID(userID).getId().toString();
        try {
            AgentRequest agentRequest = entityManager.find(AgentRequest.class, new Long(requestID));
            entityManager.remove(agentRequest);
            result.put(StringUtil.STATUS, StringUtil.OK);
            result.put(StringUtil.MESSAGE, StringUtil.DELETE);
        } catch (Exception e) {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
            result.put(StringUtil.MESSAGE, StringUtil.UNKNOWN);
        }
        return result;
    }

    @Override
    public Map<String, String> reviewRequest(String requestID, String value) {
        Map<String, String> result = new HashMap<>();
        try {
            AgentRequest agentRequest = entityManager.find(AgentRequest.class, new Long(requestID));
            agentRequest.setStatus(value);
            entityManager.merge(agentRequest);
            result.put(StringUtil.STATUS, StringUtil.OK);
            result.put(StringUtil.MESSAGE, StringUtil.SAVE);
        } catch (Exception e) {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
            result.put(StringUtil.MESSAGE, StringUtil.UNKNOWN);
        }
        return result;
    }

    @Override
    public List<AgentRequest> getAgentRequests(int start, int max) {
        String q = "SELECT * FROM `agent_request`";
        return entityManager
                .createNativeQuery(q, AgentRequest.class)
                .setFirstResult(start)
                .setMaxResults(max)
                .getResultList();
    }

    public AgentRequest getAgentRequestByUserID(String userID) {
        String q = "SELECT * FROM `agent_request` WHERE user_id=" + userID;
        List<AgentRequest> requestList = entityManager.createNativeQuery(q, AgentRequest.class).getResultList();
        AgentRequest agentRequest = null;
        if (requestList.size() > 0) {
            agentRequest = requestList.get(0);
        }
        return agentRequest;
    }

    @Override
    public List<AgentRequestReview> getAgentRequestsToReview(int start, int max, String column, String key) {
        //        String q = "SELECT * FROM `agent_request_review`";
        List<AgentRequestReview> agentRequestReviews = new ArrayList<>();
        try {
            String q = "SELECT * FROM `agent_request_review` WHERE `agent_request_review`.`" + column + "` LIKE '" + key + "'";
            agentRequestReviews
                    = entityManager.createNativeQuery(q, AgentRequestReview.class)
                            .setFirstResult(start)
                            .setMaxResults(max)
                            .getResultList();
            return agentRequestReviews;
        } catch (Exception exception) {
            System.out.println("org.hibernate.exception.SQLGrammarException");
        }
        return agentRequestReviews;
    }

    @Override
    public Map<String, String> getAgentRequestsToReviewCount(String column, String key) {
        Map<String, String> result = new HashMap<>();
        try {
            String q = "SELECT  count(*) FROM `agent_request_review` WHERE `agent_request_review`.`" + column + "` LIKE '" + key + "'";
            String count = entityManager.createNativeQuery(q).getResultList().get(0).toString();
            result.put(StringUtil.STATUS, StringUtil.OK);
            result.put(StringUtil.COUNT, count);
            return result;
        } catch (Exception e) {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
            System.out.println("Error in Agent Request Counting!");
        }
        return result;
    }

}
