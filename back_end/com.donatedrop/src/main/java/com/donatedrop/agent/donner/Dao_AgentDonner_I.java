package com.donatedrop.agent.donner;

import com.donatedrop.agent.donner.models.RequestSearchReview;
import com.donatedrop.agent.admin.model.*;
import com.donatedrop.agent.donner.models.DonnerRequestToAgent;
import com.donatedrop.agent.donner.models.DonnerToAgentRequestReview;
import com.donatedrop.agent.models.RequestNote;
import com.donatedrop.agent.models.RequestReviewRequest;

import java.util.List;
import java.util.Map;

public interface Dao_AgentDonner_I {

    public Map<String, String> saveRequest(DonnerRequestToAgent donnerRequestToAgent);

    public DonnerRequestToAgent findOneRequestById(String donnerAgentRequestID);

    public DonnerRequestToAgent findOneRequestUserID(String userID);

    public Map<String, String> deleteRequestByUserID(String userID);

    public Map<String, String> reviewDonnerRequest(RequestReviewRequest reviewRequest);

    public List<DonnerToAgentRequestReview> getDonnerToAgentRequestReview(RequestSearchReview requestSearchReview);

    public Map<String, String> getDonnerToAgentRequestReviewCount(RequestSearchReview requestSearchReview);

    public Map<String, String> updateAgentNote(RequestNote requestNote);


    Map<String, String> updateNoteDonner(RequestNote requestNote);

    public Map<String, String> updateNoteAgentPersonal(RequestNote requestNote);

}
