package com.donatedrop.agent;

import java.util.Map;

public interface Dao_Agent_I {
    /**
     *
     * @param agentRequest
     * @return
     * @apiNote for successful save, saved id will be back. OK status
     */
    public Map<String, String> saveRequest(AgentRequest agentRequest);
    public Map<String, String> deleteRequest(String userID);

}
