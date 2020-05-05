package com.donatedrop.other;

import com.donatedrop.models.Address;
import com.donatedrop.profile.basic.Dao_Profile_Basic_I;
import com.donatedrop.profile.model.EmergencyContact;
import com.donatedrop.profile.model.PhoneNumber;
import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.security.models.User;
import com.donatedrop.security.repo.UserRepository;
import com.donatedrop.util.Utils;
import org.hibernate.annotations.NaturalId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class DumpDataInsertion {


    @Autowired
    UserRepository userRepository;

    @Autowired
    Dao_Profile_Basic_I dao_profile_basic_i;

    @Test
    public void testUserCreationWithProfile() {
        for (int x = 0; x < 1000; x++) {
            System.out.println(x);
            String userID = userCreation(Integer.toString(x));
            saveProfile(userID);
        }// for
//        System.out.println("\n" + userCreation("x1") + "\n");
    }

    public String userCreation(String mail) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User();
        mail = "user" + mail + "@gmail.com";
        user.setUserName(mail);
        user.setPassword(passwordEncoder.encode("123456"));
        user.setEnabled(true);
        user.setAuthorities(new ArrayList<>());
        userRepository.save(user);
        return user.getId().toString();
    }

    public void saveProfile(String userID) {

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
        profileBasic.setUserId(userID);

        dao_profile_basic_i.save(profileBasic);
    }

}// class
