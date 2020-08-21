package com.donatedrop.agent;

import com.donatedrop.agent.models.AgentBasic;
import com.donatedrop.agent.models.UserContact;

public interface Service_Agent_I {
    public UserContact getAgentBasic(String userID);
}
