/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.agent.donner;

import com.donatedrop.agent.admin.model.AgentRequestToReview;
import com.donatedrop.agent.admin.model.RequestAdminNote;
import com.donatedrop.agent.admin.model.RequestApplicantNote;
import com.donatedrop.agent.admin.model.RequestGetAgentRequestsReview;
import com.donatedrop.agent.admin.model.RequestPersonalNote;
import com.donatedrop.agent.models.StatusType;
import com.donatedrop.agent.donner.models.DonnerRequestToAgent;
import com.donatedrop.agent.models.RequestReviewRequest;
import com.donatedrop.util.GetDate;
import com.donatedrop.util.StringUtil;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author G7
 */
@Component
@Transactional
public class Dao_AgentDonner_Impl implements Dao_AgentDonner_I {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Map<String, String> saveRequest(DonnerRequestToAgent donnerRequestToAgent) {
        Map<String, String> result = new HashMap<>();
        try {
            donnerRequestToAgent.setRequestDate(GetDate.getDate());
            donnerRequestToAgent.setStatus(StatusType.ZERO);
            entityManager.persist(donnerRequestToAgent);
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
    public DonnerRequestToAgent findOneRequestUserID(String userID) {
        String q = "SELECT * FROM `request_donner_to_agent` WHERE user_id_donner='" + userID + "'";
        List<DonnerRequestToAgent> list = entityManager.createNativeQuery(q, DonnerRequestToAgent.class).getResultList();
        DonnerRequestToAgent donnerRequestToAgent = null;
        if (list.size() > 0) {
            donnerRequestToAgent = list.get(0);
        }
        return donnerRequestToAgent;
    }

    @Override
    public DonnerRequestToAgent findOne(String donnerAgentRequestID) {
        return entityManager.find(DonnerRequestToAgent.class, new Long(donnerAgentRequestID));
    }


    @Override
    public Map<String, String> deleteRequestByUserID(String userID) {
        Map<String, String> result = new HashMap<>();
        String requestID = findOneRequestUserID(userID).getId().toString();
        try {
            DonnerRequestToAgent donnerRequestToAgent = entityManager.find(DonnerRequestToAgent.class, new Long(requestID));
            entityManager.remove(donnerRequestToAgent);
            result.put(StringUtil.STATUS, StringUtil.OK);
            result.put(StringUtil.MESSAGE, StringUtil.DELETE);
        } catch (Exception e) {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
            result.put(StringUtil.MESSAGE, StringUtil.UNKNOWN);
        }
        return result;
    }

    @Override
    public Map<String, String> reviewDonnerRequest(RequestReviewRequest reviewRequest) {
        Map<String, String> result = new HashMap<>();
        try {
            DonnerRequestToAgent donnerRequestToAgent =
                    entityManager.find(DonnerRequestToAgent.class, new Long(reviewRequest.getRequestID()));
            if (reviewRequest.getValue().equals(StatusType.ACCEPT)) {
                donnerRequestToAgent.setAcceptDate(GetDate.getDate());
            } else if (reviewRequest.getValue().equals(StatusType.REJECT)) {
                donnerRequestToAgent.setRejectDate(GetDate.getDate());
            } else if (reviewRequest.getValue().equals(StatusType.REMOVE)) {
                donnerRequestToAgent.setRemoveDate(GetDate.getDate());
            }
            donnerRequestToAgent.setStatus(reviewRequest.getValue());
            entityManager.merge(donnerRequestToAgent);
            result.put(StringUtil.STATUS, StringUtil.OK);
            result.put(StringUtil.MESSAGE, StringUtil.SAVE);
        } catch (Exception e) {
            e.printStackTrace();
            result.put(StringUtil.STATUS, StringUtil.FAIL);
            result.put(StringUtil.MESSAGE, StringUtil.UNKNOWN);
        }
        return result;
    }

    @Override
    public List<AgentRequestToReview> getAgentRequestsToReview(RequestGetAgentRequestsReview requestGetAgentRequestsReview) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public Map<String, String> getAgentRequestsToReviewCount(String column, String key, String statusType) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Map<String, String> updateAdminNote(RequestAdminNote requestAdminNote) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Map<String, String> updateApplicantNote(RequestApplicantNote requestApplicantNote) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Map<String, String> updatePersonalNote(RequestPersonalNote requestPersonalNote) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
