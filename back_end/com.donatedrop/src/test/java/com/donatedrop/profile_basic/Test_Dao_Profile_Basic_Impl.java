/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.profile_basic;

import com.donatedrop.articles.PhoneNumber;
import com.donatedrop.profile.Address;
import com.donatedrop.profile.Dao_Profile_Basic_I;
import com.donatedrop.profile.EmergencyContact;
import com.donatedrop.profile.ProfileBasic;
import com.donatedrop.util.Utils;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
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

    /**
     * April 5, 2020
     */

//    @Test
    public void test_save() {
        System.out.println("\nProfile Basic Dao Test!\n");
        // Arrange
        ProfileBasic profileBasic = new ProfileBasic();
        profileBasic.setName("Khan Ajharul Abedeen");

        Address address_present = new Address("Khulna", "Khulna", "Dumuria", "Rudghora", "Mikshimil East");
        profileBasic.setAddress_current(address_present);
        Address address_permanet = new Address("Khulna", "Khulna", "Dumuria", "Rudghora", "Mikshimil East");
        profileBasic.setAddress_permanent(address_permanet);

        List<EmergencyContact> emergencyContacts = new ArrayList<>();
        EmergencyContact emergencyContact1 = new EmergencyContact("Mahbub", "01717", "mail@mail.com", "Dumuria, Khulna", "Uncle");
        EmergencyContact emergencyContact2 = new EmergencyContact("Prof. Altaf", "01717", "mail@mail.com", "Dumuria, Khulna", "Uncle");
        emergencyContacts.add(emergencyContact1);
        emergencyContacts.add(emergencyContact2);
        profileBasic.setEmergency_contact(emergencyContacts);

        List<PhoneNumber> phoneNumbers = Arrays.asList(
                new PhoneNumber("01717034420"),
                new PhoneNumber("01717034420"),
                new PhoneNumber("01712034420")
        );
        profileBasic.setPhone_number(phoneNumbers);
        profileBasic.setGender("Male");
        profileBasic.setBlood_Group("A+");
        profileBasic.setAvailable("0");
        profileBasic.setMaritalStatus("NO");
        profileBasic.setProfession("Freelance");
        profileBasic.setCare_of("Khan Atiar Rahman.");
        profileBasic.setUserId(Utils.getLoggedUserID());

//        ACT
        String status = dao_Profile_Basic_I.save(profileBasic);
        System.out.println(status);

        //Assert
        assertEquals("OK", status);
    }

    @Test
    public void test_findOne() {
        ProfileBasic profileBasic = dao_Profile_Basic_I.findOne("28");
//        System.out.println("\n\n---\n" + profileBasic.toString() + "\n---\n\n");
        assertEquals("28", profileBasic.getId().toString());
    }

}//class
