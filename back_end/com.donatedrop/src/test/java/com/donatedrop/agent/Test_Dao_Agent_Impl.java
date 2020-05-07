package com.donatedrop.agent;

import com.donatedrop.other.TestUtil;
import com.donatedrop.util.DateUtil;
import com.donatedrop.util.StringUtil;
import jdk.nashorn.internal.AssertsEnabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class Test_Dao_Agent_Impl {

    @Autowired
    Dao_Agent_I dao_agent_i;

    @Test
    @Order(1)
    public void testObject() {
        System.out.println("\nM2\n");
        System.out.println("\ndao_agent_i : " + dao_agent_i.toString() + "\n");
    }

    @Test
    @Order(2)
    public void testSaveRequest() {
        AgentRequest agentRequest = new AgentRequest();
        agentRequest.setUserID(TestUtil.userID + 3);
        agentRequest.setRequestDate(DateUtil.getDate().toString());
        agentRequest.setStatus("0");
        Map<String, String> result = dao_agent_i.saveRequest(agentRequest);
        System.out.println("\nResult : \n" + result);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }

    @Test
    @Order(3)
    public void testReviewRequest() {
        Map<String, String> result = dao_agent_i.reviewRequest("16" + 2, "-1");
        System.out.println("\nResult : \n" + result);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }

    @Test
    public void testDeleteRequest() {
        Map<String, String> result = dao_agent_i.deleteRequest("16" + 1);
        System.out.println("\nResult : \n" + result);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }



}
