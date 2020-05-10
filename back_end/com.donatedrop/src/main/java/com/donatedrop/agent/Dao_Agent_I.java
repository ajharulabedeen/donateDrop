package com.donatedrop.agent;

import com.donatedrop.agent.models.*;

import java.util.List;
import java.util.Map;

public interface Dao_Agent_I {
    /**
     * @param agentRequest
     * @return
     * @apiNote for successful save, saved id will be back. OK status
     */
    public Map<String, String> saveRequest(AgentRequest agentRequest);

    public Map<String, String> deleteRequest(String userID);

    /**
     * @param requestID
     * @return
     * @apiNote 1 = approved, 0=not reviewed, -1= rejected.
     */
    public Map<String, String> reviewRequest(String requestID, String value);

    /**
     *
     */
    public List<AgentRequest> getAgentRequests(int start, int max);

    public List<AgentRequestToReview> getAgentRequestsToReview(RequestGetAgentRequestsReview requestGetAgentRequestsReview);

    public Map<String, String> getAgentRequestsToReviewCount(String column, String key);

    public Map<String, String> updateAdminNote(RequestAdminNote requestAdminNote);

    public Map<String, String> updateApplicantNote(RequestApplicantNote requestApplicantNote);

    public Map<String, String> updatePersonalNote(RequestPersonalNote requestPersonalNote);

    public AgentRequest getOneAgentRequest(String requestID);


}
