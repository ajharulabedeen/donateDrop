package com.donatedrop.agent;

import com.donatedrop.agent.models.AgentBasic;
import lombok.Builder;

import javax.persistence.*;

public class Dao_Agen_Impl implements Dao_Agen_I {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public AgentBasic getAgentBasic() {
        String sql = "";
        AgentBasic agentBasic = (AgentBasic) entityManager.createNativeQuery(sql, "AgentBasic").getSingleResult();
        return agentBasic;
    }
}
