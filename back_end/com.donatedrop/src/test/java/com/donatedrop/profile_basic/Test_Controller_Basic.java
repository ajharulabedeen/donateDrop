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
import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.util.Utils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.List;

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


    @Test
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

//        MvcResult mvcResult = mvc.perform(
//                MockMvcRequestBuilders.post(uri)
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)).content(super).andReturn();

        String inputJson = super.mapToJson(profileBasic);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);

//        List<DistrictsEngName> districtsEngNames = Arrays.asList(super.mapFromJson(content, DistrictsEngName[].class));
//        districtsEngNames.forEach(s -> System.out.println(s));
//        assert (districtsEngNames.size() == 10);
    }

}
