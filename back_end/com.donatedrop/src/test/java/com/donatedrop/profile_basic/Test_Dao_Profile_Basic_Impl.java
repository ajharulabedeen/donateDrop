/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.profile_basic;

import com.donatedrop.profile.Dao_Profile_Basic_I;
import com.donatedrop.profile.ProfileBasics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author G7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_Dao_Profile_Basic_Impl {
    
    @Autowired
    Dao_Profile_Basic_I dao_Profile_Basic_I;
    
    public Test_Dao_Profile_Basic_Impl() {
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
         System.out.println("\nProfile Basic Dao Test!\n");
         ProfileBasics profileBasics = new ProfileBasics();
         dao_Profile_Basic_I.save(profileBasics);
     }
}
