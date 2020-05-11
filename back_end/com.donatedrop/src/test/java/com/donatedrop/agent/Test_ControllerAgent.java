/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.agent;

import com.donatedrop.agent.models.*;
import com.donatedrop.history.*;
import com.donatedrop.geocode.AbstractTest;
import com.donatedrop.other.DumpDao;
import com.donatedrop.other.TestUtil;
import com.donatedrop.util.DateUtil;
import com.donatedrop.util.StringUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author G7
 */
@SpringBootTest
public class Test_ControllerAgent extends AbstractTest {

    @Autowired
    DumpDao dumpDao;

    @Autowired
    Dao_Agent_I dao_agent_i;

    @Autowired
    Dao_History_I dao_history_i;

    public Test_ControllerAgent() {
    }

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    //    String uri = "/public/user/saveRequest";
    @Test
    @Order(1)
    public void testSave() throws Exception {
        //      arrange
        String uri = "/public/user/saveRequest";
        System.out.println("\nAgent Request Save\n");
        BigInteger userIDBigInteger = dumpDao.getNotRequestedAgentUser(0, 5).get(0);
        Integer userID = ((BigInteger) userIDBigInteger).intValue();
        System.out.println("userID : " + userID);
        AgentRequest agentRequest = new AgentRequest();
        agentRequest.setUserID(userID.toString());
        agentRequest.setRequestDate(DateUtil.getDate().toString());
        agentRequest.setStatus("0");
        agentRequest.setNoteApplicant("Test Note!");

        String inputJson = super.mapToJson(agentRequest);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
//      act
        System.out.println(content);

//      assert
        Map<String, String> map = super.mapFromJson(content, Map.class);
        assertEquals(StringUtil.OK, map.get(StringUtil.STATUS));
        if (map.get(StringUtil.STATUS).equals(StringUtil.OK)) {
            storeID(userID.toString());
        }
    }

    //        String uri = "/public/user/deleteRequest?userID=" + userID;
    @Test
    @Order(-2)
    public void testDelete() throws Exception {
        String userID = getID();
        String uri = "/public/user/deleteRequest?userID=" + userID;
        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> map = super.mapFromJson(content, Map.class);
        System.out.println("\nAgent Request: \n" + map + "\n");
        assertEquals(StringUtil.OK, map.get(StringUtil.STATUS));
    }

    //        String uri = "/public/user/reviewRequest";
    @Test
    @Order(3)
    public void testReviewRequest() throws Exception {
//     arrange
        String requestID = dumpDao.getAgentRequests(0, 5).get(0).getId().toString();
        System.out.println("requestID : " + requestID);
        String value = "-3";
        String uri = "/public/user/reviewRequest";
        RequestReviewRequest reviewRequest = new RequestReviewRequest(requestID, value);
//      act
        String inputJson = super.mapToJson(reviewRequest);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//assert
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> map = super.mapFromJson(content, Map.class);
        System.out.println("\nAgent Request Review: \n" + map + "\n");
        assertEquals(StringUtil.OK, map.get(StringUtil.STATUS));

//        further verification can be done by reading the agent request.
    }

    //        String uri = "/public/user/getAgentRequestsToReview";
    @Test
    @Order(3)
    public void testGetAgentRequestsToReview() throws Exception {
//     arrange
        String uri = "/public/user/getAgentRequestsToReview";
        RequestGetAgentRequestsReview requestGetAgentRequests
                = new RequestGetAgentRequestsReview(0, 30, "username", "%1%", "ACCEPT");
//      act
        String inputJson = super.mapToJson(requestGetAgentRequests);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//assert
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        List<AgentRequestToReview> agentRequestListToReviews = Arrays.asList(super.mapFromJson(content, AgentRequestToReview[].class));
        agentRequestListToReviews.forEach(agentRequestToReview -> System.out.println(agentRequestToReview));

//        further verification can be done by reading the agent request.
    }

    //        String uri = "/public/user/getAgentRequestsToReviewCount";
    @Test
    @Order(4)
    public void testGetAgentRequestsToReviewCount() throws Exception {
//     arrange
        String uri = "/public/user/getAgentRequestsToReviewCount";
        RequestGetAgentRequestsReview requestGetAgentRequests
                = new RequestGetAgentRequestsReview(0, 30, "username", "%15%", "0");
//      act
        String inputJson = super.mapToJson(requestGetAgentRequests);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//assert
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        System.out.println("\n" + result + "\n");

//        further verification can be done by reading the agent request.
    }

    //    http://localhost:8080/public/user/updateAdminNote
//    @org.junit.jupiter.api.Test
    @Test
    public void testUpdateAdminNote() throws Exception {
//     arrange
        String uri = "/public/user/updateAdminNote";
        String requestID = dao_agent_i.getAgentRequests(0, 10).get(0).getId().toString();
        String note = "Controller : ADMIN NOTE : Please provide additional Documents!";
        System.out.println(requestID);
        RequestAdminNote adminNote = new RequestAdminNote(requestID, note);
//      act
        String inputJson = super.mapToJson(adminNote);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//assert
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
        assertEquals(note, dao_agent_i.getOneAgentRequest(requestID).getNoteAdmin());
    }

    //    http://localhost:8080/public/user/updateApplicantNote
    @Test
    public void testUpdateApplicantNote() throws Exception {
//     arrange
        String uri = "/public/user/updateApplicantNote";
        String requestID = dao_agent_i.getAgentRequests(0, 10).get(0).getId().toString();
        String note = "Controller : updateApplicantNote NOTE : Please provide additional Documents!";
        System.out.println(requestID);
        RequestApplicantNote applicantNote = new RequestApplicantNote(requestID, note);
//      act
        String inputJson = super.mapToJson(applicantNote);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//assert
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
        assertEquals(note, dao_agent_i.getOneAgentRequest(requestID).getNoteApplicant());
    }

    //    http://localhost:8080/public/user/updatePersonalNote
    @Test
    public void testupdatePersonalNote() throws Exception {
//     arrange
        String uri = "/public/user/updatePersonalNote";
        String requestID = dao_agent_i.getAgentRequests(0, 10).get(0).getId().toString();
        String note = "Controller : update Personal NOTE : Please provide additional Documents!";
        System.out.println(requestID);
        RequestPersonalNote personalNote = new RequestPersonalNote(requestID, note);
//      act
        String inputJson = super.mapToJson(personalNote);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//assert
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
        assertEquals(note, dao_agent_i.getOneAgentRequest(requestID).getNotePersonal());
    }

    //    Start : old Code
    //    String uri = "/public/user/history/update";
    @Test
    @Order(2)
    public void testUpdate() throws Exception {
        String uri = "/public/user/history/update";
        String userID = TestUtil.userID;
        String historyID = getID();
        System.out.println("\nHistory Update\n");
        History history = new History();
        history.setId(new Long(historyID));//will be set from service.
        history.setUserId(userID);//will be set from service.
        history.setDate(DateUtil.getDate().toString());
        history.setLocation("Karakom, WestPoint, Dhaka.");
        history.setPatientDescription("Kidney Update, Update");
        history.setRefferedBy("Mobile/");
        history.setNote("Went to at night.");

        String inputJson = super.mapToJson(history);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        Map<String, String> map = super.mapFromJson(content, Map.class);
        assertEquals(StringUtil.OK, map.get(StringUtil.STATUS));
    }

    //    String uri = "/public/user/history/search";
    @Test
    @Order(4)
    public void testSearh() throws Exception {
        String uri = "/public/user/history/search";
//        "15", "note", "khulna", 0, 10
        RequestSearch requestSearch = new RequestSearch("16", "patient_description", "", 0, 10);

        String inputJson = super.mapToJson(requestSearch);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        List<History> historyList = Arrays.asList(super.mapFromJson(content, History[].class));
        historyList.forEach(h -> System.out.println(h.toString()));
//        assertEquals(StringUtil.OK, map.get(StringUtil.STATUS));
    }

    //    String uri = "/public/user/history/search";
    @Test
    @Order(5)
    public void testSearchCount() throws Exception {
        String uri = "/public/user/history/searchCount";
//        "15", "note", "khulna", 0, 10
        RequestSearch requestSearch
                = new RequestSearch("15", "location", "%kh%", 0, 10);

        String inputJson = super.mapToJson(requestSearch);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        Map<String, Integer> map = super.mapFromJson(content, Map.class);
        System.out.println("\n" + map.get(StringUtil.COUNT) + "\n");
//        assertEquals(StringUtil.COUNT, map.get(StringUtil.STATUS));
    }
//    end : old Code

//    Helpers --------------------------------
    /**
     * will store the last save id, that can be used for later for other method.
     * Though there is question does it, right to a result from unit test, as
     * main goal of the unit test is to keep the test as much as possible
     * independent.
     *
     * @param id
     */
    public void storeID(String id) {
        try {
            FileWriter myWriter = new FileWriter("history_controller.txt");
            myWriter.write(id);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getID() {
        String id = "";
        try {
            File myObj = new File("history_controller.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                id = data;
//                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return id;
    }

}
