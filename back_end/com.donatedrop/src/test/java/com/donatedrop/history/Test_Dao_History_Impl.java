package com.donatedrop.history;


import com.donatedrop.models.Address;
import com.donatedrop.profile.basic.Dao_Profile_Basic_I;
import com.donatedrop.profile.model.EmergencyContact;
import com.donatedrop.profile.model.PhoneNumber;
import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.util.DateUtil;
import com.donatedrop.util.StringUtil;
import com.donatedrop.util.Utils;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class Test_Dao_History_Impl {
    @Autowired
    Dao_History_I dao_history_i;

    @Autowired
    Dao_Profile_Basic_I dao_profile_basic_i;


    @Test
    @Order(-1)
    public void test0_DaoObject() {
        System.out.println("\n\n---M0---\n\n");
        assert (dao_history_i != null);
    }

    /**
     * April 27, 2020
     */
    @Test
    @Order(1)
    public void test1_save() {
        Map<String, String> status = null;
//
        // Arrange
        try {
            System.out.println("\nHistory Save\n");
            History history = new History();
            history.setUserId(Utils.getLoggedUserID());//will be set from service.
            history.setDate(DateUtil.getDate().toString());
            history.setLocation("Karakom,WestPoint, Dhaka.");
            history.setPatientDescription("Kidney");
            history.setRefferedBy("Mobile");
            history.setNote("Went to at night.");
            history.setProfileBasic(dao_profile_basic_i.findOne());//will be set from service


//        ACT
//            status = dao_Profile_Basic_I.save(profileBasic);
//            System.out.println(status);
//            id = status.get(StringUtil.ID);
//            System.out.println("\nID : " + id);
//            storeID(id);
//            System.out.println("Count : " + count++);
        } catch (Exception e) {
            storeID(id);
        }
////        Assert
        Assert.assertEquals(StringUtil.OK, status.get(StringUtil.STATUS));
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
            FileWriter myWriter = new FileWriter("history.txt");
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
            File myObj = new File("history.txt");
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

}
