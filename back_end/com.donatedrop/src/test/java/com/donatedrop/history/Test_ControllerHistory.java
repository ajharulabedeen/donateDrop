/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.history;

import com.donatedrop.geocode.AbstractTest;
import com.donatedrop.geocode.models.DistrictsEngName;
import com.donatedrop.models.Address;
import com.donatedrop.other.TestUtil;
import com.donatedrop.profile.basic.Dao_Profile_Basic_I;
import com.donatedrop.profile.model.EmergencyContact;
import com.donatedrop.profile.model.PhoneNumber;
import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.util.DateUtil;
import com.donatedrop.util.StringUtil;
import com.donatedrop.util.Utils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author G7
 */
@SpringBootTest
public class Test_ControllerHistory extends AbstractTest {

    @Autowired
    Dao_Profile_Basic_I dao_Profile_Basic_I;

    @Autowired
    Dao_History_I dao_history_i;

    public Test_ControllerHistory() {
    }

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    //    String uri = "/public/user/history/save";
    @Test
    @Order(1)
    public void testSave() throws Exception {
        String uri = "/public/user/history/save";
        String userID = "15";
        System.out.println("\nHistory Save\n");
        History history = new History();
        history.setUserId(userID);//will be set from service.
        history.setDate(DateUtil.getDate().toString());
        history.setLocation("Karakom,WestPoint, Dhaka.");
        history.setPatientDescription("Kidney");
        history.setRefferedBy("Mobile");
        history.setNote("Went to at night.");

        String inputJson = super.mapToJson(history);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        Map<String, String> map = super.mapFromJson(content, Map.class);
        assertEquals(StringUtil.OK, map.get(StringUtil.STATUS));
        if (map.get(StringUtil.STATUS).equals(StringUtil.OK)) {
            storeID(map.get(StringUtil.ID));
        }
    }

    //    String uri = "/public/user/history/update";
    @Test
    @Order(2)
    public void testUpdate() throws Exception {
        String uri = "/public/user/history/update";
        String userID = TestUtil.userID;
        String historyID = getID();
        System.out.println("\nHistory Update\n");
        History history = new History();
        history.setId(new Long(historyID));//will be set from service.
        history.setUserId(userID);//will be set from service.
        history.setDate(DateUtil.getDate().toString());
        history.setLocation("Karakom, WestPoint, Dhaka.");
        history.setPatientDescription("Kidney Update, Update");
        history.setRefferedBy("Mobile/");
        history.setNote("Went to at night.");

        String inputJson = super.mapToJson(history);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        Map<String, String> map = super.mapFromJson(content, Map.class);
        assertEquals(StringUtil.OK, map.get(StringUtil.STATUS));
    }

    //    String uri = "/public/user/history/delete";
    @Test
    @Order(3)
    public void testDelete() throws Exception {
        String historyID = "121";
        String uri = "/public/user/history/delete?historyID=" + historyID;
        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> map = super.mapFromJson(content, Map.class);
        System.out.println("\nhistory delete : \n" + map + "\n");
        assertEquals(StringUtil.OK, map.get(StringUtil.STATUS));
    }


    //    ---------------------: START : OLD CODE :---------------------------
    //    String uri = "/public/profile/basic/save";
    @Test
    @Order(2)
    public void testfullSave() throws Exception {

        String uri = "/public/profile/basic/save";

        // Arrange
        System.out.println("\nProfile Basic Dao Test!\n");
        ProfileBasic profileBasic = new ProfileBasic();
        profileBasic.setName("Khan Ajharul Abedeen");

        Address address_present = new Address("Khulna", "Khulna", "Dumuria", "Rudghora", "Mikshimil East");
        profileBasic.setAddress_present(address_present);
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

        String inputJson = super.mapToJson(profileBasic);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
        Map<String, String> map = super.mapFromJson(content, Map.class);
        assertEquals(StringUtil.OK, map.get(StringUtil.STATUS));
    }

    //    String uri = "/public/profile/basic/findOneByUser";
    @Test
    public void testfindOneByUser() throws Exception {
        String uri = "/public/profile/basic/findOneByUser";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    //    String uri = "/public/profile/basic/exist";
    @Test
    public void testBasicExist() throws Exception {
        String uri = "/public/profile/basic/exist";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        System.out.println(content);
        assertEquals(StringUtil.TRUE, result.get(StringUtil.STATUS));
    }

//    //    String uri = "/public/profile/basic/update";
//    @Test
//    public void testUpdate() throws Exception {
//        String uri = "/public/profile/basic/update";
//
//        // Arrange
//        String userID = Utils.getLoggedUserID();
//        ProfileBasic profileBasicNew = new ProfileBasic();
//        profileBasicNew.setUserId(userID);
//        profileBasicNew.setName("Khan Ajharul Abedeen");
//        profileBasicNew.setBirthDate(DateUtil.getDate().toString());
//        profileBasicNew.setGender("Male");
//        profileBasicNew.setBlood_Group("A+");
//        profileBasicNew.setAvailable("1");
//        profileBasicNew.setMaritalStatus("NO");
//        profileBasicNew.setProfession("Remote");
//        profileBasicNew.setCare_of("Khan Atiar Rahman");
//        profileBasicNew.setReligion("NoMo NoMo");
//        profileBasicNew.setEmail("dim@dimdim.co");
//
//        String inputJson = super.mapToJson(profileBasicNew);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//        String content = mvcResult.getResponse().getContentAsString();
//        Map<String, String> result = super.mapFromJson(content, Map.class);
//        System.out.println(content);
//        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
//        Assert.assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
//        //have to do more verification. by calling the full app.
//        //refactor : stop child loading, need to create new method to get only basics.
//        ProfileBasic profileBasicSaved = dao_Profile_Basic_I.findOneByUser(userID);
//        Assert.assertEquals(profileBasicNew.getName(), profileBasicSaved.getName());
//        Assert.assertEquals(profileBasicNew.getBirthDate(), profileBasicSaved.getBirthDate());
//        Assert.assertEquals(profileBasicNew.getCare_of(), profileBasicSaved.getCare_of());
////        assertEquals("DimDim", profileBasicSaved.getCare_of());//for test the test, :P
//        Assert.assertEquals(profileBasicNew.getGender(), profileBasicSaved.getGender());
//        Assert.assertEquals(profileBasicNew.getMaritalStatus(), profileBasicSaved.getMaritalStatus());
//        Assert.assertEquals(profileBasicNew.getProfession(), profileBasicSaved.getProfession());
//        Assert.assertEquals(profileBasicNew.getBlood_Group(), profileBasicSaved.getBlood_Group());
//        Assert.assertEquals(profileBasicNew.getAvailable(), profileBasicSaved.getAvailable());
//        Assert.assertEquals(profileBasicNew.getReligion(), profileBasicSaved.getReligion());
//        Assert.assertEquals(profileBasicNew.getEmail(), profileBasicSaved.getEmail());
//    }

    //    String uri = "/public/profile/basic/addPhoneNumber";
    @Test
    public void testAddPhoneNumber() throws Exception {
        String uri = "/public/profile/basic/addPhoneNumber";
        // Arrange
        PhoneNumber phoneNumberNew = new PhoneNumber("01910-664020");
        String inputJson = super.mapToJson(phoneNumberNew);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        System.out.println(content);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }

    //    String uri = "/public/profile/basic/deletePhoneNumber";
    @Test
    public void testDeletePhoneNumber() throws Exception {
        String uri = "/public/profile/basic/deletePhoneNumber";
        // Arrange
        PhoneNumber phoneNumberNew = new PhoneNumber();
        phoneNumberNew.setId(Long.parseLong("118"));
        String inputJson = super.mapToJson(phoneNumberNew);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        System.out.println(content);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }

    @Test
//    @Order(6)
    public void test6_presentAddressUpdate() throws Exception {
        String uri = "/public/profile/basic/updatePresentAddress";

        String divNew = "Dhaka";
        String distNew = "Dhaka";
        String upzNew = "Gazipur";
        String unionNew = "Kapasia";
        String streetAddressNew = "Road No 10";

        Address addressPresentNew = new Address();
        addressPresentNew.setDivision(divNew);
        addressPresentNew.setDistrict(distNew);
        addressPresentNew.setUpzilla(upzNew);
        addressPresentNew.setUnion_ward(unionNew);
        addressPresentNew.setStreet_address(streetAddressNew);

        String inputJson = super.mapToJson(addressPresentNew);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        System.out.println(content);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));

//        Map<String, String> result = dao_Profile_Basic_I.updatePresentAddress(addressPresentNew, userID);
//        System.out.println("\n\n" + result + "\n\n");
//        Assert.assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
//
//        Address addressPresentSaved = dao_Profile_Basic_I.findOneByUser(userID).getAddress_present();
//        String divSaved = addressPresentSaved.getDistrict();
//        String distSaved = addressPresentSaved.getDivision();
//        Assert.assertEquals(divSaved, divNew);
//        Assert.assertEquals(distSaved, distNew);
    }

    @Test
//    @Order(6)
    public void test7_updatePermanentAddress() throws Exception {
        String uri = "/public/profile/basic/updatePermanentAddress";

        String divNew = "Dhaka";
        String distNew = "Dhaka";
        String upzNew = "Gazipur";
        String unionNew = "Kapasia";
        String streetAddressNew = "Road No 101";

        Address addressPermanentNew = new Address();
        addressPermanentNew.setDivision(divNew);
        addressPermanentNew.setDistrict(distNew);
        addressPermanentNew.setUpzilla(upzNew);
        addressPermanentNew.setUnion_ward(unionNew);
        addressPermanentNew.setStreet_address(streetAddressNew);

        String inputJson = super.mapToJson(addressPermanentNew);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        System.out.println(content);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));

//        Map<String, String> result = dao_Profile_Basic_I.updatePresentAddress(addressPresentNew, userID);
//        System.out.println("\n\n" + result + "\n\n");
//        Assert.assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
//
        Address addressPresentSaved = dao_Profile_Basic_I.findOneByUser("16").getAddress_permanent();
        String divSaved = addressPresentSaved.getDistrict();
        String distSaved = addressPresentSaved.getDivision();
        Assert.assertEquals(divSaved, divNew);
        Assert.assertEquals(distSaved, distNew);
    }

    @Test
//    @Order(10)
    public void test10_addEmergencyContact() throws Exception {
        String uri = "/public/profile/basic/addEmergencyContact";
        //String name, String phone, String mail, String address, String relation
        EmergencyContact emergencyContact1 = new EmergencyContact(
                "KKK Bir",
                "01612-174128",
                "mahbub@mail.com",
                "Khulna, Bangladsh",
                "Uncle"
        );

        String inputJson = super.mapToJson(emergencyContact1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        System.out.println(content);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));

    }

    @Test
//    @Order(12)
    public void test12_deleteEmergencyContact() throws Exception {
        String emergencyContactID = "200";
        String uri = "/public/profile/basic/deleteEmergencyContact?emergencyContactID=" + emergencyContactID;

//        String inputJson = super.mapToJson("");
        MvcResult mvcResult = mvc.perform(
                MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

//        MvcResult mvcResult = mvc.perform(
//                MockMvcRequestBuilders.post(uri)
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        System.out.println(content);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }


    @Test
    @Order(11)
    public void test11_updateEmergencyContact() throws Exception {
////        Arrange
//        String profileBasicID = getID();
//        String userID = "";
//        String emergencyContactID = "";
//        ProfileBasic profileBasic = dao_Profile_Basic_I.findOneWithChild(profileBasicID);
//        userID = profileBasic.getUserId();
//        emergencyContactID = profileBasic.getEmergency_contact().get(0).getId().toString();

        //        unatherised deletion
        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setId(Long.parseLong("203"));
        emergencyContact.setName("Mahbub Gazi");
        emergencyContact.setPhone("07171000");
        emergencyContact.setAddress("Dhaka, Dhaka");
        emergencyContact.setRelation("Mamu");
        emergencyContact.setMail("mail@mail.com");

        String emergencyContactID = "203";
        String uri = "/public/profile/basic/updateEmergencyContact";
//        String inputJson = super.mapToJson(emergencyContact);
//        MvcResult mvcResult = mvc.perform(
//                MockMvcRequestBuilders.post(uri)
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        String inputJson = super.mapToJson(emergencyContact);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//        MvcResult mvcResult = mvc.perform(
//                MockMvcRequestBuilders.post(uri)
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Map<String, String> result = super.mapFromJson(content, Map.class);
        System.out.println(content);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }
//    ---------------------: END : OLD CODE :---------------------------

//    Helpers --------------------------------

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
            FileWriter myWriter = new FileWriter("history_controller.txt");
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
            File myObj = new File("history_controller.txt");
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
