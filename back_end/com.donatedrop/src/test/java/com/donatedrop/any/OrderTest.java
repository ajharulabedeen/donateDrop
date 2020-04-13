package com.donatedrop.any;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {
    @Test
    void test0() {
        System.out.println("0");
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(3)
    void test1() {
        System.out.println("1");
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(1)
    void test2() {
        System.out.println("2");
        assertEquals(2, 1 + 1);
    }

    @Test
    @Order(2)
    void test3() {
        System.out.println("3");
        assertEquals(2, 1 + 1);
    }

    @Test
    void test4() {
        System.out.println("4");
        assertEquals(2, 1 + 1);
    }
}
