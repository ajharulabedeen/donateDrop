/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.grocode;

import com.donatedrop.geocode.Dao_GeoCode_I;
import com.donatedrop.geocode.DistrictsEngName;
import com.donatedrop.geocode.Divisions;
import com.donatedrop.geocode.DivisionsEngName;
import com.donatedrop.geocode.UnionsEngName;
import com.donatedrop.geocode.UpzillaEngName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
 * @author G7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_Dao_GEO_Code {

    @Autowired
    private Dao_GeoCode_I dao_GeoCode_I;

    public Test_Dao_GEO_Code() {
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

    @Test
    public void test_GetDivisions() {
        int divisions = dao_GeoCode_I.getDivisions().size();
//working
//        List<DivisionsEngName> divEng = dao_GeoCode_I.getDivisions();
//        for (Iterator<DivisionsEngName> iterator = divEng.iterator(); iterator.hasNext();) {
//            DivisionsEngName div = iterator.next();
//            System.out.println(div.toString());
//        }
        assertEquals(divisions, 8);
    }

    @Test
    public void test_getDistricts() {
        //khulna, id=3 has 10 districts
        String divID = "3";
        int districts = dao_GeoCode_I.getDistricts(divID).size();
//working
//        List<DistrictsEngName> distEng = dao_GeoCode_I.getDistricts(divID);
//        for (Iterator<DistrictsEngName> iterator = distEng.iterator(); iterator.hasNext();) {
//            DistrictsEngName dist = iterator.next();
//            System.out.println(dist.toString());
//        }
        assertEquals(districts, 10);
    }

    @Test
    public void test_getUpzillas() {
        //khulna, id=27 has 9 districts
        String distID = "27";
        int upzillas = dao_GeoCode_I.getUpzillas(distID).size();
//working
//        List<UpzillaEngName> upzEng = dao_GeoCode_I.getUpzillas(distID);
//        for (Iterator<UpzillaEngName> iterator = upzEng.iterator(); iterator.hasNext();) {
//            UpzillaEngName dist = iterator.next();
//            System.out.println(dist.toString());
//        }
        assertEquals(upzillas, 9);
    }

    @Test
    public void test_getUnions() {
        //Dumuria, id=211 has 14 unions
        String upzID = "211";
        int upzillas = dao_GeoCode_I.getUnions(upzID).size();
//working
//        List<UnionsEngName> upzEng = dao_GeoCode_I.getUnions(upzID);
//        for (Iterator<UnionsEngName> iterator = upzEng.iterator(); iterator.hasNext();) {
//            UnionsEngName dist = iterator.next();
//            System.out.println(dist.toString());
//        }
        assertEquals(upzillas, 14);
    }

    public void printDivisions() {

    }
}
