package com.donatedrop.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Map;

@Transactional
@Component
public class Dao_Agent_Impl implements Dao_Agent_I {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * @param agentRequest
     * @return
     * @apiNote for successful save, saved id will be back. OK status
     */
    public Map<String, String> saveRequest(AgentRequest agentRequest) {
        return null;
    }

    public Map<String, String> deleteRequest(AgentRequest agentRequest) {
        return null;
    }

}
