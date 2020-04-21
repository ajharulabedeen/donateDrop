/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.profile_basic;

import com.donatedrop.grocode.*;
import com.donatedrop.geocode.models.DistrictsEngName;
import com.donatedrop.geocode.models.DivisionsEngName;
import com.donatedrop.geocode.models.UnionsEngName;
import com.donatedrop.geocode.models.UpzillaEngName;
import com.donatedrop.models.Address;
import com.donatedrop.profile.model.EmergencyContact;
import com.donatedrop.profile.model.PhoneNumber;
import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.util.StringUtil;
import com.donatedrop.util.Utils;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Order;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author G7
 */
@SpringBootTest
public class Test_Controller_Basic extends AbstractTest {

    public Test_Controller_Basic() {
    }

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }


    /**
     * @throws Exception
     * @apiNote to test that profile basic will be saved, without full information.
     */
    @Test
    @Order(1)
    public void testSave() throws Exception {
        String uri = "/public/profile/basic/save";
        ProfileBasic profileBasic = new ProfileBasic();
        profileBasic.setName("Khan Ajharul Abedeen");
        profileBasic.setGender("Male");
        profileBasic.setBlood_Group("A+");
        profileBasic.setAvailable("0");
        profileBasic.setMaritalStatus("NO");
        profileBasic.setProfession("Freelance");
        profileBasic.setCare_of("Khan Atiar Rahman.");
        profileBasic.setUserId(Utils.getLoggedUserID());

        String inputJson = super.mapToJson(profileBasic);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        Map<String, String> map = super.mapFromJson(content, Map.class);
        assertEquals(StringUtil.FAIL, map.get(StringUtil.STATUS));
    }

    @Test
    @Order(2)
    public void testfullSave() throws Exception {

        String uri = "/public/profile/basic/save";

        // Arrange
        System.out.println("\nProfile Basic Dao Test!\n");
        ProfileBasic profileBasic = new ProfileBasic();
        profileBasic.setName("Khan Ajharul Abedeen");

        Address address_present = new Address("Khulna", "Khulna", "Dumuria", "Rudghora", "Mikshimil East");
        profileBasic.setAddress_present(address_present);
        Address address_permanet = new Address("Khulna", "Khulna", "Dumuria", "Rudghora", "Mikshimil East");
        profileBasic.setAddress_permanent(address_permanet);

        List<EmergencyContact> emergencyContacts = new ArrayList<>();
        EmergencyContact emergencyContact1 = new EmergencyContact("Mahbub", "01717", "mail@mail.com", "Dumuria, Khulna", "Uncle");
        EmergencyContact emergencyContact2 = new EmergencyContact("Prof. Altaf", "01717", "mail@mail.com", "Dumuria, Khulna", "Uncle");
        emergencyContacts.add(emergencyContact1);
        emergencyContacts.add(emergencyContact2);
        profileBasic.setEmergency_contact(emergencyContacts);

        List<PhoneNumber> phoneNumbers = Arrays.asList(
                new PhoneNumber("01717034420"),
                new PhoneNumber("01717034420"),
                new PhoneNumber("01712034420")
        );
        profileBasic.setPhone_number(phoneNumbers);
        profileBasic.setGender("Male");
        profileBasic.setBlood_Group("A+");
        profileBasic.setAvailable("0");
        profileBasic.setMaritalStatus("NO");
        profileBasic.setProfession("Freelance");
        profileBasic.setCare_of("Khan Atiar Rahman.");
        profileBasic.setUserId(Utils.getLoggedUserID());

        String inputJson = super.mapToJson(profileBasic);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        Map<String, String> map = super.mapFromJson(content, Map.class);
        assertEquals(StringUtil.OK, map.get(StringUtil.STATUS));
    }

    @Test
    public void testfindOneByUser() throws Exception {
        String uri = "/public/profile/basic/findOneByUser";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void testBasicExist() throws Exception {
        String uri = "/public/profile/basic/basicExist";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        System.out.println(content);
        assertEquals(StringUtil.TRUE, result.get(StringUtil.STATUS));
    }

}