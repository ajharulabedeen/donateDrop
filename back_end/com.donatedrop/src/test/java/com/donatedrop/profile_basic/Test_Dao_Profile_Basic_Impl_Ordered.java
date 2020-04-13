//package com.donatedrop.profile_basic;
//
//import com.donatedrop.profile.basic.Dao_Profile_Basic_I;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@RunWith(SpringRunner.class)
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { SpringTestConfiguration.class })
//@SpringBootTest
//public class Test_Dao_Profile_Basic_Impl_Ordered {
//    @Autowired
//    Dao_Profile_Basic_I dao_Profile_Basic_I;
//
//    @Test
//    @Order(0)
//    public void testDaoObject() {
//        assert (dao_Profile_Basic_I != null);
//    }
//}
