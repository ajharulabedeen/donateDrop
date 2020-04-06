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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

import org.junit.*;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @author ajharulabedeen@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_Dao_Profile_Basic_Impl {

    @Autowired
    Dao_Profile_Basic_I dao_Profile_Basic_I;

    public String id = "";
    int count = 0;

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
    @org.junit.jupiter.api.Order(1)
    public void test1_save() {
        Map<String, String> status = null;

        // Arrange
        try {
            System.out.println("\nProfile Basic Dao Test!\n");
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
            status = dao_Profile_Basic_I.save(profileBasic);
            System.out.println(status);
            id = status.get("id");
            System.out.println("\nID : " + id);
            storeID(id);
            System.out.println("Count : " + count++);
        } catch (Exception e) {
            storeID(id);
        }
//        Assert
        assertEquals("OK", status.get("status"));
    }

    //    @Test
    public void test2_findOne() {
        id = getID();
        ProfileBasic profileBasic = dao_Profile_Basic_I.findOne(id);
//        System.out.println("\n\n---\n" + profileBasic.toString() + "\n---\n\n");
        assertEquals(id, profileBasic.getId().toString());
    }

    //    @Test
    public void test3_delete() {
        id = getID();
        Map<String, String> response = new HashMap<>();
        try {
            response = dao_Profile_Basic_I.delete(id);
        } catch (Exception e) {
            System.out.println("Test Delete Fail!");
        }
        System.out.println("response (test) : " + response.toString());
        assertEquals("OK", response.get("status"));
    }

    @Test
    public void test4_findOne() {
        String userID = "13";
        ProfileBasic profileBasic = dao_Profile_Basic_I.findOneByUser("13");
//        System.out.println("\nTest : \n" + profileBasic.toString() + "\n\n");
//        System.out.println("\nTest : \n" + profileBasic.getPhone_number().toString() + "\n\n");
        assertEquals(userID, profileBasic.getUserId());
    }

//    Helpers : 

    /**
     * will store the last save id, that can be used for later for other method.
     * Though there is question does it, right to a result from unit test, as
     * main goal of the unit test is to keep the test as much as possible
     * independent.
     *
     * @param id
     */
    public void storeID(String id) {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(id);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getID() {
        String id = "";
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                id = data;
//                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return id;
    }

}//class
