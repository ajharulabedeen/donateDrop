package com.donatedrop.agent;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service_Agent_Impl implements Service_Agent_I {

    @Autowired
    Dao_Agent_I dao_agent_i;

    /**
     * @param agentRequest
     * @return
     * @apiNote for successful save, saved id will be back. OK status
     */
    public Map<String, String> saveRequest(AgentRequest agentRequest) {
        return dao_agent_i.saveRequest(agentRequest);
    }

    public Map<String, String> deleteRequest(String userID) {
        return dao_agent_i.deleteRequest(userID);
    }

    /**
     * @param requestID
     * @return
     * @apiNote 1 = approved, 0=not reviewed, -1= rejected.
     */
    public Map<String, String> reviewRequest(String requestID, String value) {
        return dao_agent_i.reviewRequest(requestID, value);
    }

    /**
     *
     */
    public List<AgentRequest> getAgentRequests(int start, int max) {
        return dao_agent_i.getAgentRequests(start, max);
    }

    public List<AgentRequestToReview> getAgentRequestsToReview(int start, int max, String column, String key) {
        return dao_agent_i.getAgentRequestsToReview(start, max, column, key);
    }

    public Map<String, String> getAgentRequestsToReviewCount(String column, String key) {
        return getAgentRequestsToReviewCount(column, key);
    }
}
