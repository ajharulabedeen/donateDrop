package com.donatedrop.agent.admin;

//import com.donatedrop.agent.admin.models.*;

import com.donatedrop.agent.admin.model.AgentRequest;
import com.donatedrop.agent.admin.model.RequestApplicantNote;
import com.donatedrop.agent.admin.model.RequestAdminNote;
import com.donatedrop.agent.admin.model.RequestReviewRequest;
import com.donatedrop.agent.admin.model.RequestGetAgentRequestsReview;
import com.donatedrop.agent.admin.model.AgentRequestToReview;
import com.donatedrop.agent.admin.model.RequestPersonalNote;

import java.util.List;
import java.util.Map;

public interface Dao_AgentAdmin_I {
    /**
     * @param agentRequest
     * @return
     * @apiNote for successful save, saved id will be back. OK status
     */
    public Map<String, String> saveRequest(AgentRequest agentRequest);

    public Map<String, String> deleteRequest(String userID);

    /**
     * @param reviewRequest
     * @return
     * @apiNote 1 = approved, 0=not reviewed, -1= rejected.
     */
    public Map<String, String> reviewRequest(RequestReviewRequest reviewRequest);

    /**
     *
     */
    public List<AgentRequest> getAgentRequests(int start, int max);

    public List<AgentRequestToReview> getAgentRequestsToReview(RequestGetAgentRequestsReview requestGetAgentRequestsReview);

    public Map<String, String> getAgentRequestsToReviewCount(String column, String key, String statusType);

    public Map<String, String> updateAdminNote(RequestAdminNote requestAdminNote);

    public Map<String, String> updateApplicantNote(RequestApplicantNote requestApplicantNote);

    public Map<String, String> updatePersonalNote(RequestPersonalNote requestPersonalNote);

    public AgentRequest getOneAgentRequest(String requestID);


}
