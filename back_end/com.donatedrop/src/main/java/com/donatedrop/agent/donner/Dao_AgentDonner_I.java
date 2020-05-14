package com.donatedrop.agent.donner;

import com.donatedrop.agent.donner.models.RequestSearchReview;
import com.donatedrop.agent.admin.model.*;
import com.donatedrop.agent.donner.models.DonnerRequestToAgent;
import com.donatedrop.agent.donner.models.DonnerToAgentRequestReview;
import com.donatedrop.agent.models.RequestReviewRequest;

import java.util.List;
import java.util.Map;

public interface Dao_AgentDonner_I {
    public Map<String, String> saveRequest(DonnerRequestToAgent donnerRequestToAgent);

    public DonnerRequestToAgent findOne(String donnerAgentRequestID);

    public DonnerRequestToAgent findOneRequestUserID(String userID);

    public Map<String, String> deleteRequestByUserID(String userID);

    public Map<String, String> reviewDonnerRequest(RequestReviewRequest reviewRequest);

    public List<DonnerToAgentRequestReview> getDonnerToAgentRequestReview(RequestSearchReview requestGetAgentRequestsReview);

//    public Map<String, String> getAgentRequestsToReviewCount(String column, String key, String statusType);
//
//    public Map<String, String> updateAdminNote(RequestAdminNote requestAdminNote);
//
//    public Map<String, String> updateApplicantNote(RequestApplicantNote requestApplicantNote);
//
//    public Map<String, String> updatePersonalNote(RequestPersonalNote requestPersonalNote);


//    public DonnerRequestToAgent findOne(String donnerAgentRequestID);
}
