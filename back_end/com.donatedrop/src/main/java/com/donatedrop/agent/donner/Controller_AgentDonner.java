/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.agent.donner;

import com.donatedrop.agent.donner.models.DonnerRequestToAgent;
import com.donatedrop.agent.donner.models.DonnerToAgentRequestReview;
import com.donatedrop.agent.donner.models.RequestSearchReview;
import com.donatedrop.agent.models.RequestNote;
import com.donatedrop.agent.models.RequestReviewRequest;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author G7
 */
@RestController
@RequestMapping("/public/user/agent/donner")
public class Controller_AgentDonner {

    @Autowired
    Service_AgentDonner_I service_AgentDonner_I;

    @PostMapping()
    public Map<String, String> saveRequest(DonnerRequestToAgent donnerRequestToAgent) {
        return service_AgentDonner_I.saveRequest(donnerRequestToAgent);
    }

    @PostMapping()
    public DonnerRequestToAgent findOneRequestById(String donnerAgentRequestID) {
        return service_AgentDonner_I.findOneRequestById(donnerAgentRequestID);
    }

    @PostMapping()
    public DonnerRequestToAgent findOneRequestUserID(String userID) {
        return service_AgentDonner_I.findOneRequestUserID(userID);
    }

    @PostMapping()
    public Map<String, String> deleteRequestByUserID(String userID) {
        return service_AgentDonner_I.deleteRequestByUserID(userID);
    }

    @PostMapping()
    public Map<String, String> reviewDonnerRequest(RequestReviewRequest reviewRequest) {
        return service_AgentDonner_I.reviewDonnerRequest(reviewRequest);
    }

    @PostMapping()
    public List<DonnerToAgentRequestReview> getDonnerToAgentRequestReview(RequestSearchReview requestSearchReview) {
        return service_AgentDonner_I.getDonnerToAgentRequestReview(requestSearchReview);
    }

    @PostMapping()
    public Map<String, String> getDonnerToAgentRequestReviewCount(RequestSearchReview requestSearchReview) {
        return service_AgentDonner_I.getDonnerToAgentRequestReviewCount(requestSearchReview);
    }

    @PostMapping()
    public Map<String, String> updateAgentNote(RequestNote requestNote) {
        return service_AgentDonner_I.updateAgentNote(requestNote);
    }

    @PostMapping()
    Map<String, String> updateNoteDonner(RequestNote requestNote) {
        return service_AgentDonner_I.updateNoteDonner(requestNote);
    }

    @PostMapping()
    public Map<String, String> updateNoteAgentPersonal(RequestNote requestNote) {
        return service_AgentDonner_I.updateNoteAgentPersonal(requestNote);
    }

}
