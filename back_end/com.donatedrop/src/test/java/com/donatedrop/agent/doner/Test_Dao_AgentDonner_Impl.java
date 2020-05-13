/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.agent.doner;

import com.donatedrop.agent.donner.Dao_AgentDonner_I;
import com.donatedrop.agent.donner.models.DonnerRequestToAgent;
import com.donatedrop.other.DumpDao;
import com.donatedrop.util.StringUtil;
import org.hibernate.event.internal.DefaultPersistOnFlushEventListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

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
        System.out.println("\n" + dao_agentDonner_i + "\n");
    }

    @Test
    @Order(1)
    public void testSaveRequestDonnerToAgent() {
        String userID = dumpDao.getNotRequestedDonnerToAgentUsers(0, 5).get(0).toString();
        DonnerRequestToAgent donnerRequestToAgent = new DonnerRequestToAgent();
        donnerRequestToAgent.setUserIdDonner(userID);
        donnerRequestToAgent.setNoteDonner("I am from your home town!");
        Map<String, String> result = dao_agentDonner_i.saveRequest(donnerRequestToAgent);
        System.out.println("\n" + result + "\n");
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }

    //refactor : have to set another user ID.
    @Test
    @Order(1)
    public void testFindOne() {
        String requestID = "23001";
        DonnerRequestToAgent donnerRequestToAgentSaved = dao_agentDonner_i.findOne(requestID);
        System.out.println("\n" + donnerRequestToAgentSaved.toString() + "\n");
        assertNotNull(donnerRequestToAgentSaved);
    }
}
