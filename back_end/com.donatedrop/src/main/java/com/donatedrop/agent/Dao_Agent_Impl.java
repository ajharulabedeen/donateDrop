package com.donatedrop.agent;

import com.donatedrop.util.StringUtil;
import org.hibernate.exception.ConstraintViolationException;
//import org.hibernate.exception.ConstraintViolationException;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class Dao_Agent_Impl implements Dao_Agent_I {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * @param agentRequest
     * @return
     * @apiNote for successful save, saved id will be back. OK status
     */
    @Transactional
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
        String rquestID = getAgentRequestByUserID(userID).getId().toString();
        try {
            entityManager.remove(entityManager.find(AgentRequest.class, new Long(rquestID)));
            result.put(StringUtil.STATUS, StringUtil.OK);
            result.put(StringUtil.MESSAGE, StringUtil.SAVE);
        } catch (Exception e) {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
            result.put(StringUtil.MESSAGE, StringUtil.UNKNOWN);
        }
        return result;
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

}
