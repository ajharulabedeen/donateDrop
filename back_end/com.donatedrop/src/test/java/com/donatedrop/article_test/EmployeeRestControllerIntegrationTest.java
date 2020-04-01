/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.article_test;

import com.donatedrop.articles.old.ArticleController;
import com.donatedrop.articles.old.IArticleService;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author G7
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ArticleController.class, secure = false)
@AutoConfigureMockMvc
public class EmployeeRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IArticleService articleService;

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
            throws Exception {
//        String url = "http://127.0.0.1:8080/test/test";
        String url = "/test/test";
        System.out.println("-------------------------Start----------------------------------");
        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(status().isOk());
        //                .andExpect(jsonPath("$[0].name", is("")));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();
        System.out.println("Response : " + result.getRequest());
        System.out.println("-------------------------End----------------------------------");

    }
}//class
