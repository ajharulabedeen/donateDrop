/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.grocode;

import com.donatedrop.articles.old.ArticleController;
import com.donatedrop.geocode.Controller_GeoCode;
import com.donatedrop.geocode.Service_GeoCode_I;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author G7
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = Controller_GeoCode.class, secure = false)
@AutoConfigureMockMvc
public class Test_Controller_GeoCode {

     @MockBean
     Service_GeoCode_I service_GeoCode_I;
    
    public Test_Controller_GeoCode() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test_getDivisions() {
        System.out.println("Divisions!");
    }
}
