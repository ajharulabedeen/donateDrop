/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.grocode;

import com.donatedrop.articles.old.ArticleController;
import com.donatedrop.geocode.Controller_GeoCode;
import com.donatedrop.geocode.DivisionsEngName;
import com.donatedrop.geocode.Service_GeoCode_I;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.web.client.RestTemplate;

/**
 *
 * @author G7
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = Controller_GeoCode.class, secure = false)
@AutoConfigureMockMvc
public class NotWorking_Test_Controller_GeoCode {

    @Autowired
    private MockMvc mvc;

//    @InjectMocks
    @MockBean
    private Controller_GeoCode controller_GeoCode;

    @MockBean
    Service_GeoCode_I service_GeoCode_I;

    public NotWorking_Test_Controller_GeoCode() {
    }

    @Test
    public void getEmployees() throws IOException {
        final String uri = "http://localhost:8080/public/geocode/divisions";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        restTemplate.getForObject(uri, String.class);
//        restTemplate.;
        System.out.println(result);

        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, String>> list = new ArrayList<>();
        list = mapper.readValue(result, List.class);
        System.out.println(list.get(0));
        Map<String, String> m = list.get(0);
        System.out.println("id : " + m.get("id"));
        System.out.println("Name : " + m.get("name"));
        System.out.println(list);
    }
}
