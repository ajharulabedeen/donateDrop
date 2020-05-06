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

@SpringBootTest
public class TestAny {

    @Autowired
    private Dao_GeoCode_I dao_GeoCode_I;


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

    @org.junit.jupiter.api.Test
    public void testAddress() {
        for (int x = 0; x < 50; x++) {
            System.out.println(getAddress());
        }
    }

    public String getAddress() {
        Random r = new Random();
        System.out.println("\n" + dao_GeoCode_I.toString() + "\n");

        try {

        } catch (Exception e) {

        }
        List<DivisionsEngName> divisionsList = dao_GeoCode_I.getDivisions();
        int divRand = r.nextInt(divisionsList.size());
        String divID = divisionsList.get(divRand).getId().toString();
        String divName = divisionsList.get(divRand).getName().toString();

        List<DistrictsEngName> districtsEngNameList = dao_GeoCode_I.getDistricts(divID);
        int distRand = r.nextInt(districtsEngNameList.size());
        String distID = districtsEngNameList.get(distRand).getId().toString();
        String distName = districtsEngNameList.get(distRand).getName().toString();

        List<UpzillaEngName> upzillaEngNameList = dao_GeoCode_I.getUpzillas(distID);
        int upzRand = r.nextInt(upzillaEngNameList.size());
        String upzID = upzillaEngNameList.get(upzRand).getId().toString();
        String upzName = upzillaEngNameList.get(upzRand).getName().toString();

        List<UnionsEngName> unionsEngNameList = dao_GeoCode_I.getUnions(upzID);
        int unionRand = r.nextInt(unionsEngNameList.size());
        String unionID = unionsEngNameList.get(unionRand).getId().toString();
        String unionName = unionsEngNameList.get(unionRand).getName().toString();

        return unionName + ", " + upzName + ", " + distName + ", " + divName;
    }


}// class
