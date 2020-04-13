/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.any;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author G7
 */
public class NewEmptyJUnitTest {

    public NewEmptyJUnitTest() {
    }

    @Test
    @Order(3)
    public void m2() {
        System.out.println("M2");
    }

    @Test
    @Order(2)
    public void m1() {
        System.out.println("M1");
    }

    @Test
    @Order(1)
    public void m3() {
        System.out.println("M3");
    }
}

//        Method[] methods = Test_Dao_Profile_Basic_Impl.class.getDeclaredMethods();
//        int nMethod = 1;
//        System.out.println("1. List of all methods of Person class");
//        for (Method method : methods) {
//            System.out.printf("%d. %s", ++nMethod, method);
//            System.out.println();
//        }
//        System.out.printf("%d. End - all  methods of Person class", ++nMethod);