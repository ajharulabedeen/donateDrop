package com.donatedrop.agent.doner;

import com.donatedrop.agent.donner.models.DonnerToAgentRequestReview;
import com.donatedrop.agent.donner.models.RequestSearchReview;
import com.donatedrop.agent.models.RequestNote;
import com.donatedrop.agent.models.RequestReviewRequest;
import com.donatedrop.geocode.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class Test_Controller_AgentDonner extends AbstractTest {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/saveRequest";
    public void saveRequest() {
        String url = "/public/user/agent/donner/saveRequest";

    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/findOneRequestById";
    public void findOneRequestById() {
        String url = "/public/user/agent/donner/findOneRequestById";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/findOneRequestUserID";
    public void findOneRequestUserID() {
        String url = "/public/user/agent/donner/findOneRequestUserID";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/deleteRequestByUserID";
    public void deleteRequestByUserID() {
        String url = "/public/user/agent/donner/deleteRequestByUserID";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/reviewDonnerRequest";
    public void reviewDonnerRequest() {
        String url = "/public/user/agent/donner/reviewDonnerRequest";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/getDonnerToAgentRequestReview";
    public void getDonnerToAgentRequestReview() {
        String url = "/public/user/agent/donner/getDonnerToAgentRequestReview";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/getDonnerToAgentRequestReviewCount";
    public void getDonnerToAgentRequestReviewCount() {
        String url = "/public/user/agent/donner/getDonnerToAgentRequestReviewCount";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/updateAgentNote";
    public void updateAgentNote() {
        String url = "/public/user/agent/donner/updateAgentNote";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/updateNoteDonner";
    void updateNoteDonner() {
        String url = "/public/user/agent/donner/updateNoteDonner";
    }

    @Test
    @Order(1)
//    //"/public/user/agent/donner/updateNoteAgentPersonal";
    public void updateNoteAgentPersonal() {
        String url = "/public/user/agent/donner/updateNoteAgentPersonal";
    }

}
