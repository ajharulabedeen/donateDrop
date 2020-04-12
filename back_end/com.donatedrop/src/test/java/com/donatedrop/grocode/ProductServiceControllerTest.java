/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.grocode;

import com.donatedrop.geocode.DivisionsEngName;
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
 *
 * @author G7
 */
public class ProductServiceControllerTest extends AbstractTest {

    public ProductServiceControllerTest() {
    }

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void hello() {
        System.out.println("Hello");
    }

    @Test
    public void getProductsList() throws Exception {
//        String uri = "/products";
//        final String uri = "http://localhost:8080/public/geocode/divisions";
        final String uri = "/public/geocode/divisions";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        DivisionsEngName[] divisions = super.mapFromJson(content, DivisionsEngName[].class);
        
        for (int i = 0; i < divisions.length; i++) {
            System.out.println(divisions[i]);
        }
        
        
        assertTrue(divisions.length == 8);
        
        
    }
}
