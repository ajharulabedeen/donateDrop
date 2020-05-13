package com.donatedrop.agent.admin;

import com.donatedrop.agent.admin.models.*;
import com.donatedrop.other.DumpDao;
import com.donatedrop.other.TestUtil;
import com.donatedrop.util.DateUtil;
import com.donatedrop.util.StringUtil;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class Test_Dao_Agent_Impl {

    @Autowired
    Dao_Agent_I dao_agent_i;

    @Autowired
    DumpDao dumpDao;

    @Test
    @Order(1)
    public void testObject() {
        System.out.println("\nM2\n");
        System.out.println("\ndao_agent_i : " + dao_agent_i.toString() + "\n");
    }

    @Test
    @Order(2)
    public void testSaveRequest() {
        AgentRequest agentRequest = new AgentRequest();
        agentRequest.setUserID(TestUtil.userID + 3);
        agentRequest.setRequestDate(DateUtil.getDate().toString());
        agentRequest.setStatus("0");
        Map<String, String> result = dao_agent_i.saveRequest(agentRequest);
        System.out.println("\nResult : \n" + result);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }

    @Test
    @Order(3)
    public void testReviewRequest() {
//        String id = dumpDao.getUsers(0, 10).get(0).getId().toString();
        int max = 5;
        String requestID = dumpDao.getAgentRequests(2, 5).get(2).getId().toString();
        System.out.println("requestID : " + requestID);
        String reviewValue = StatusType.FREEZE;
        RequestReviewRequest reviewRequest = new RequestReviewRequest(requestID, reviewValue);

        Map<String, String> result = dao_agent_i.reviewRequest(reviewRequest);
        System.out.println("\nResult : \n" + result);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
        AgentRequest agentRequest = dao_agent_i.getOneAgentRequest(requestID);
        System.out.println("\nRequest Status : \n" + agentRequest.getStatus());
        assertEquals(agentRequest.getStatus(), reviewValue);
    }

    @Test
    public void testDeleteRequest() {
        Map<String, String> result = dao_agent_i.deleteRequest("16" + 1);
        System.out.println("\nResult : \n" + result);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }

    @Test
    public void testGetAllRequestAgent() {
        dao_agent_i.getAgentRequests(0, 10).forEach(ar -> {
            System.out.println(ar.toString());
        });
    }

    @Test
    public void testGetAgentRequestsToReview() {
        RequestGetAgentRequestsReview agentRequestsReview =
                new RequestGetAgentRequestsReview(0, 30, "username", "%1%", StatusType.ZERO);
        dao_agent_i.getAgentRequestsToReview(agentRequestsReview).forEach(agentRequestReview -> {
            String addr = agentRequestReview.getPermanentStreet()
                    + " " + agentRequestReview.getPermanentUnion()
                    + ", " + agentRequestReview.getPermanentUpz()
                    + ", " + agentRequestReview.getPermanentDist()
                    + ", " + agentRequestReview.getPermanentDiv();
            System.out.println(addr);
            System.out.println(agentRequestReview.getPhone_number());
            System.out.println(agentRequestReview.getUsername());
            System.out.println("-------------------------------");
        });
    }

    @Test
    public void testGetAgentRequestsReviewCount() {
        Map<String, String> result = dao_agent_i.getAgentRequestsToReviewCount("username", "%%", StatusType.ACCEPT);
        System.out.println(result);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }

    @Test
    public void testGetAgentRequestsReviewPhoneNumber() {
        RequestGetAgentRequestsReview agentRequestsReview =
                new RequestGetAgentRequestsReview(0, 30, "phonenumber", "%815%", StatusType.ZERO);
        dao_agent_i.getAgentRequestsToReview(agentRequestsReview).forEach(agentRequestReview -> {
            System.out.println(agentRequestReview.toString());
        });
    }

    @Test
    public void testUpdateAdminNote() {
        String requestID = dao_agent_i.getAgentRequests(0, 10).get(0).getId().toString();
        String note = "ADMIN NOTE : Please provide additional Documents!";
        System.out.println(requestID);
        RequestAdminNote adminNote = new RequestAdminNote(requestID, note);
        Map<String, String> result = dao_agent_i.updateAdminNote(adminNote);
        System.out.println(result);
        AgentRequest agentRequest = dao_agent_i.getOneAgentRequest(requestID);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
        assertEquals(note, agentRequest.getNoteAdmin());
    }

    @Test
    public void testUpdateApplicantNote() {
        String requestID = dao_agent_i.getAgentRequests(0, 10).get(0).getId().toString();
        String note = "APPLICANT NOTE : President of collage Blood Club!";
        System.out.println(requestID);
        RequestApplicantNote requestApplicantNote = new RequestApplicantNote(requestID, note);
        Map<String, String> result = dao_agent_i.updateApplicantNote(requestApplicantNote);
        System.out.println(result);
        AgentRequest agentRequest = dao_agent_i.getOneAgentRequest(requestID);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
        assertEquals(note, agentRequest.getNoteApplicant());
    }

    @Test
    public void testUpdatePersonalNote() {
        String requestID = dao_agent_i.getAgentRequests(0, 10).get(0).getId().toString();
        String note = "Personal NOTE : Dont called him tree time not receive!";
        System.out.println(requestID);
        RequestPersonalNote requestPersonalNote = new RequestPersonalNote(requestID, note);
        Map<String, String> result = dao_agent_i.updatePersonalNote(requestPersonalNote);
        System.out.println(result);
        AgentRequest agentRequest = dao_agent_i.getOneAgentRequest(requestID);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
        assertEquals(note, agentRequest.getNotePersonal());
    }


    //    not part dao layer
    @Test
    public void testInsertAgent() {
        dumpDao.getUsers(0, 20).forEach(user -> {
            AgentRequest agentRequest = new AgentRequest();
            agentRequest.setUserID(user.getId().toString());
            agentRequest.setRequestDate(DateUtil.getDate().toString());
            agentRequest.setStatus("0");
            Map<String, String> result = dao_agent_i.saveRequest(agentRequest);
            System.out.println("\nResult : \n" + result);
        });
    }


}
