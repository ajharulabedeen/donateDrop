package com.donatedrop.agent.donner;

import com.donatedrop.agent.admin.model.AgentRequest;
import com.donatedrop.agent.donner.models.DonnerRequestToAgent;

import java.util.Map;

public interface Dao_AgentDonner_I {
    public Map<String, String> saveRequest(DonnerRequestToAgent donnerRequestToAgent);

    public DonnerRequestToAgent findOne(String donnerAgentRequestID);

    public DonnerRequestToAgent findOneRequestUserID(String userID);

    public Map<String, String> deleteRequestByUserID(String userID);


//    public DonnerRequestToAgent findOne(String donnerAgentRequestID);
}
