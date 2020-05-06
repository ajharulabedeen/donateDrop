package com.donatedrop.other;

import com.donatedrop.geocode.Dao_GeoCode_I;
import com.donatedrop.geocode.models.DistrictsEngName;
import com.donatedrop.geocode.models.DivisionsEngName;
import com.donatedrop.geocode.models.UnionsEngName;
import com.donatedrop.geocode.models.UpzillaEngName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Random;

public class TestAny {

    @Test
    public void testBCrypt() {
        System.out.println("Test!");
        int i = 0;
        while (i < 10) {
            String password = "password";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);
            System.out.println(hashedPassword);
            i++;
        }
    }

    @Test
    public void testGetPhoneNumber() {
        for (int x = 0; x < 50; x++) {
            System.out.println(DumpData.getPhoneNumber());
        }
    }

    @Test
    public void testGetName() {
        for (int x = 0; x < 50; x++) {
            System.out.println(DumpData.getName());
        }
    }

    @Test
    public void testGetAdd() {
        for (int x = 0; x < 5; x++) {
            System.out.println(DumpData.getAddress());
        }
    }

    @Test
    public void testGetStreetAddress() {
        System.out.println(DumpData.getStreetAddress());
    }

}// class
