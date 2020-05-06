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
import java.util.Random;

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
        Random r = new Random();
        System.out.println("\nProfile Basic Dao Test!\n");
        ProfileBasic profileBasic = new ProfileBasic();
        profileBasic.setName(DumpData.getName());

        Address address_present = new Address("Khulna", "Khulna", "Dumuria", "Rudghora", "Mikshimil East");
        profileBasic.setAddress_present(address_present);
        Address address_permanet = new Address("Khulna", "Khulna", "Dumuria", "Rudghora", "Mikshimil East");
        profileBasic.setAddress_permanent(address_permanet);

        List<EmergencyContact> emergencyContacts = new ArrayList<>();
        for (int x = 0; x < r.nextInt(4); x++) {
            EmergencyContact emergencyContact1 = new EmergencyContact(
                    DumpData.getName(), DumpData.getPhoneNumber(), DumpData.getName() + "@mail.com", DumpData.getAddress(), DumpData.getRelation()
            );
            emergencyContacts.add(emergencyContact1);
        }
        profileBasic.setEmergency_contact(emergencyContacts);

        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        for (int x = 0; x < r.nextInt(4); x++) {
            phoneNumbers.add(new PhoneNumber(DumpData.getPhoneNumber()));
        }
        profileBasic.setPhone_number(phoneNumbers);

        profileBasic.setGender(DumpData.getGender());
        profileBasic.setBlood_Group(DumpData.getBloodGroup());
        profileBasic.setAvailable("0");
        profileBasic.setMaritalStatus("NO");
        profileBasic.setProfession(DumpData.getProfession());
        profileBasic.setCare_of(DumpData.getName());
        profileBasic.setUserId(userID);

        dao_profile_basic_i.save(profileBasic);
    }

}// class
