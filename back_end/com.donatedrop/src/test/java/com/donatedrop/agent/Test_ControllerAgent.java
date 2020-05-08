/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.agent;

import com.donatedrop.history.*;
import com.donatedrop.geocode.AbstractTest;
import com.donatedrop.geocode.models.DistrictsEngName;
import com.donatedrop.models.Address;
import com.donatedrop.other.DumpDao;
import com.donatedrop.other.TestUtil;
import com.donatedrop.profile.basic.Dao_Profile_Basic_I;
import com.donatedrop.profile.model.EmergencyContact;
import com.donatedrop.profile.model.PhoneNumber;
import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.util.DateUtil;
import com.donatedrop.util.StringUtil;
import com.donatedrop.util.Utils;
import org.junit.Assert;
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
        agentRequest.setNote("Test Note!");

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
