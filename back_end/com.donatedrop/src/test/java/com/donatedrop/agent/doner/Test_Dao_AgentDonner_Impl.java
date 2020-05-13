/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.agent.doner;

import com.donatedrop.agent.donner.Dao_AgentDonner_I;
import com.donatedrop.other.DumpDao;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author G7
 */
@SpringBootTest
public class Test_Dao_AgentDonner_Impl {
    @Autowired
    DumpDao dumpDao;

    @Autowired
    Dao_AgentDonner_I dao_agentDonner_i;

    @Test
    @Order(0)
    public void testLayerWiring() {
        System.out.println("\n" + dao_agentDonner_i+"\n");
    }

    @Test
    @Order(1)
    public void testSaveRequestDonnerToAgent() {

    }

}
