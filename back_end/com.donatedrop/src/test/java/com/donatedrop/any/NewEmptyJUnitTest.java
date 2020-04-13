/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.any;

import com.donatedrop.profile_basic.Test_Dao_Profile_Basic_Impl;
import java.lang.reflect.Method;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void hello() {
        Method[] methods = Test_Dao_Profile_Basic_Impl.class.getDeclaredMethods();
        int nMethod = 1;
        System.out.println("1. List of all methods of Person class");
        for (Method method : methods) {
            System.out.printf("%d. %s", ++nMethod, method);
            System.out.println();
        }
        System.out.printf("%d. End - all  methods of Person class", ++nMethod);
    }

}
