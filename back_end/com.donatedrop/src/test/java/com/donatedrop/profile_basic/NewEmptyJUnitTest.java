/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.profile_basic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author G7
 */
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
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
    @Order(2)
    public void m2() {

        System.out.println("M1");
        assertEquals("OK","OK");
        assertEquals("OK1","OK1");
        assertEquals("OKL","OKL");
    }

    @Test
    @Order(1)
    public void zm1() {
        System.out.println("M2");
    }

//    @Test
    public void m1_1Write() {
        Charset utf8 = StandardCharsets.UTF_8;
        List<String> list = Arrays.asList("Line 1");
        try {
            // If the file doesn't exists, create and write to it
            // If the file exists, truncate (remove all content) and write to it
            Files.write(Paths.get("log/profile_basic.log"), list, utf8);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    @Test
    public void m1_Read() {
        // Read
        try {
            byte[] content = Files.readAllBytes(Paths.get("log/profile_basic.log"));
            String s = new String(content);
            String[] x = s.split(" ");
            System.out.println("x : " + x.length);
            System.out.println(">" + s + "<");
            System.out.println(">" + x[0] + "<");
            System.out.println(">" + x[1] + "<");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
