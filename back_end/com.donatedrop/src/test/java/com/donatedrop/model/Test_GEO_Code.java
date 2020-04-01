/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.model;

import com.donatedrop.geocode.Divisions;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author G7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_GEO_Code {

    @PersistenceContext
    private EntityManager entityManager;

    public Test_GEO_Code() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test_GetDivisions() {
        System.out.println("GEO Code Test Class!");
        System.out.println(entityManager.toString());
        String hql = "SELECT d FROM Divisions d";
        List<Divisions> divs = new ArrayList<>();
        divs = entityManager.createQuery(hql).getResultList();
        for (Iterator<Divisions> iterator = divs.iterator(); iterator.hasNext();) {
            Divisions div = iterator.next();
            System.out.println(div.toString());
        }
    }
}
