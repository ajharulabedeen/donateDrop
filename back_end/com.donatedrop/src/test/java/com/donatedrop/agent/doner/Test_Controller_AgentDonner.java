package com.donatedrop.agent.doner;


import com.donatedrop.agent.admin.model.AgentRequest;
import com.donatedrop.agent.donner.models.DonnerRequestToAgent;
import com.donatedrop.geocode.AbstractTest;
import com.donatedrop.other.DumpDao;
import com.donatedrop.util.DateUtil;
import com.donatedrop.util.StringUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Order;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
public class Test_Controller_AgentDonner extends AbstractTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Autowired
    DumpDao dumpDao;

    @Test
    @Order(1)
    //"/public/user/agent/donner/saveRequest";
    public void testSveRequestDonnerToAgent() throws Exception {
        String uri = "/public/user/agent/donner/saveRequest";
        System.out.println("\nAgent Donner Request Save\n");
        BigInteger userIDBigInteger = dumpDao.getNotRequestedDonnerToAgentUsers(0, 5).get(0);
        Integer userID = ((BigInteger) userIDBigInteger).intValue();
        System.out.println("userID : " + userID);

        DonnerRequestToAgent donnerRequestToAgent = new DonnerRequestToAgent();
        donnerRequestToAgent.setUserIdDonner(userID.toString());
        donnerRequestToAgent.setRequestDate(DateUtil.getDate().toString());
        donnerRequestToAgent.setStatus("0");
        donnerRequestToAgent.setNoteDonner("I am from ur university!");

        String inputJson = super.mapToJson(donnerRequestToAgent);
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

    @Test
    @Order(1)
    //"/public/user/agent/donner/findOneRequestById";
    // RequestParam String donnerAgentRequestID
    public void testFindOneRequestById() throws Exception {
        String donnerAgentRequestID = dumpDao.getAgentDonnersRequests(0, 5).get(0).getId().toString();
        String uri = "/public/user/agent/donner/findOneRequestById?donnerAgentRequestID=" + donnerAgentRequestID;

        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        DonnerRequestToAgent donnerRequestToAgent = super.mapFromJson(content, DonnerRequestToAgent.class);
        System.out.println(donnerRequestToAgent);
        assertNotNull(donnerRequestToAgent);
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/findOneRequestUserID";
    public void testFindOneRequestUserID() {
        String url = "/public/user/agent/donner/findOneRequestUserID";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/deleteRequestByUserID";
    public void testDeleteRequestByUserID() {
        String url = "/public/user/agent/donner/deleteRequestByUserID";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/reviewDonnerRequest";
    public void testReviewDonnerRequest() {
        String url = "/public/user/agent/donner/reviewDonnerRequest";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/getDonnerToAgentRequestReview";
    public void testGetDonnerToAgentRequestReview() {
        String url = "/public/user/agent/donner/getDonnerToAgentRequestReview";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/getDonnerToAgentRequestReviewCount";
    public void testGetDonnerToAgentRequestReviewCount() {
        String url = "/public/user/agent/donner/getDonnerToAgentRequestReviewCount";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/updateAgentNote";
    public void testUpdateAgentNote() {
        String url = "/public/user/agent/donner/updateAgentNote";
    }

    @Test
    @Order(1)
    //"/public/user/agent/donner/updateNoteDonner";
    public void testUpdateNoteDonner() {
        String url = "/public/user/agent/donner/updateNoteDonner";
    }

    @Test
    @Order(1)
//    //"/public/user/agent/donner/updateNoteAgentPersonal";
    public void testUpdateNoteAgentPersonal() {
        String url = "/public/user/agent/donner/updateNoteAgentPersonal";
    }

    // helpers : -------------------------

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
            FileWriter myWriter = new FileWriter("agent_donner_controller.txt");
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
            File myObj = new File("agent_donner_controller.txt");
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
