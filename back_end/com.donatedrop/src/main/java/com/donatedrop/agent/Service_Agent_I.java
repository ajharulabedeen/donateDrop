package com.donatedrop.agent;

import com.donatedrop.agent.models.AgentRequest;
import com.donatedrop.agent.models.AgentRequestToReview;

import java.util.List;
import java.util.Map;

public interface Service_Agent_I {
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

    public List<AgentRequestToReview> getAgentRequestsToReview(int start, int max, String column, String key);

    public Map<String,String> getAgentRequestsToReviewCount(String column, String key);
}
