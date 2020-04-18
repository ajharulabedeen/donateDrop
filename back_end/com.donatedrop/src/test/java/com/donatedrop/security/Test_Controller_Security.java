/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.security;

import com.donatedrop.geocode.models.DistrictsEngName;
import com.donatedrop.geocode.models.DivisionsEngName;
import com.donatedrop.geocode.models.UnionsEngName;
import com.donatedrop.geocode.models.UpzillaEngName;
import com.donatedrop.grocode.AbstractTest;
import com.donatedrop.security.models.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author G7
 */
@SpringBootTest
public class Test_Controller_Security extends AbstractTest {

    public Test_Controller_Security() {
    }

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void test_getDivisions() throws Exception {
        String divID = "3";//Khulna > 10 dist.
        String uri = "/register";
        User user = new User();
        user.setUserName("khan@nail.com");
        user.setPassword("123456");
        user.setEnabled(true);
        user.setAuthorities(new ArrayList<>());
        String jSonData = "{\n" +
                "\t\"userName\":\"timm3\",\n" +
                "\t\"password\":\"dim\"\n" +
                "}";


//        MvcResult mvcResult = mvc.perform(
//                MockMvcRequestBuilders.post(uri, jSonData)
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(String.valueOf(user))).andReturn();

        int status = mvcResult.getResponse().getStatus();


//        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
//        List<DistrictsEngName> districtsEngNames = Arrays.asList(super.mapFromJson(content, DistrictsEngName[].class));
//        districtsEngNames.forEach(s -> System.out.println(s));
//        assert (districtsEngNames.size() == 10);
    }

}
