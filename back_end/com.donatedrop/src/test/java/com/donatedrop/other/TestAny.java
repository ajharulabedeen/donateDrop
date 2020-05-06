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

    public String getAddress() {
        Random r = new Random();
//        System.out.println("\n" + dao_GeoCode_I.toString() + "\n");
        String divID = "";
        String divName = "";
        String distID = "";
        String distName = "";
        String upzID = "";
        String upzName = "";
        String unionID = "";
        String unionName = "";
        try {
            List<DivisionsEngName> divisionsList = dao_GeoCode_I.getDivisions();
            int divRand = r.nextInt(divisionsList.size());
            divID = divisionsList.get(divRand).getId().toString();
            divName = divisionsList.get(divRand).getName().toString();
        } catch (Exception e) {
            System.out.println("Exception in Gettting Division!" + divID + "\n");
        }

        try {
            List<DistrictsEngName> districtsEngNameList = dao_GeoCode_I.getDistricts(divID);
            int distRand = r.nextInt(districtsEngNameList.size());
            distID = districtsEngNameList.get(distRand).getId().toString();
            distName = districtsEngNameList.get(distRand).getName().toString();
        } catch (Exception e) {
            System.out.println("Exception in Gettting District! : " + distID + "\n");
        }

        try {
            List<UpzillaEngName> upzillaEngNameList = dao_GeoCode_I.getUpzillas(distID);
            int upzRand = r.nextInt(upzillaEngNameList.size());
            upzID = upzillaEngNameList.get(upzRand).getId().toString();
            upzName = upzillaEngNameList.get(upzRand).getName().toString();
        } catch (Exception e) {
            System.out.println("Exception in Gettting Upzilla! : " + upzID + "\n");
        }

        try {
            List<UnionsEngName> unionsEngNameList = dao_GeoCode_I.getUnions(upzID);
            int unionRand = r.nextInt(unionsEngNameList.size());
            unionID = unionsEngNameList.get(unionRand).getId().toString();
            unionName = unionsEngNameList.get(unionRand).getName().toString();
        } catch (Exception e) {
            System.out.println("Exception in Gettting Unions! : " + unionID + "\n");
        }


        return unionName + ", " + upzName + ", " + distName + ", " + divName;
    }


}// class
