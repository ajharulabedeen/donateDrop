package com.donatedrop.agent;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test_Dao_Agent_Impl {

    @Autowired
    Dao_Agent_I dao_agent_i;

    @Test
    @Order(2)
    public void testObject() {
        System.out.println("\nM2\n");
        System.out.println("\ndao_agent_i : " + dao_agent_i.toString() + "\n");
    }

}
