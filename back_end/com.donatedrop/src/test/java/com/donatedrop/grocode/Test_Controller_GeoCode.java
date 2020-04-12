/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.grocode;

import com.donatedrop.geocode.DistrictsEngName;
import com.donatedrop.geocode.DivisionsEngName;
import com.donatedrop.geocode.UpzillaEngName;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;

/**
 * @author G7
 */
public class Test_Controller_GeoCode extends AbstractTest {

    public Test_Controller_GeoCode() {
    }

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void test_getDivisions() throws Exception {
        final String uriDivisions = "/public/geocode/divisions";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uriDivisions)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        DivisionsEngName[] divisions = super.mapFromJson(content, DivisionsEngName[].class);
        printDivisions(divisions);
        assertTrue(divisions.length == 8);
    }

    @Test
    public void test_getDistricts() throws Exception {
        String divID = "3";//Khulna > 10 dist.
        String uri = "/public/geocode/districts?divID=" + divID;
        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        DistrictsEngName[] districtsEngNames = super.mapFromJson(content, DistrictsEngName[].class);
        printDistrict(districtsEngNames);
        assert (districtsEngNames.length == 10);
    }

    @Test
    public void test_getUpzillas() throws Exception {
        String distID = "27";//khulna, id=27 has 9 districts
        String uri = "/public/geocode/upzillas?distID=" + distID;
        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        UpzillaEngName[] upzillaEngNames = super.mapFromJson(content, UpzillaEngName[].class);
        printUpzillas(upzillaEngNames);
        assert (upzillaEngNames.length == 9);
    }


    public void printUpzillas(UpzillaEngName[] upzillaEngNames) {
        for (int i = 0; i < upzillaEngNames.length; i++) {
            System.out.println(upzillaEngNames[i]);
        }
    }

    public void printDivisions(DivisionsEngName[] divisions) {
        for (int i = 0; i < divisions.length; i++) {
            System.out.println(divisions[i]);
        }
    }

    public void printDistrict(DistrictsEngName[] districtsEngNames) {
        for (int i = 0; i < districtsEngNames.length; i++) {
            System.out.println(districtsEngNames[i]);
        }
    }

}
