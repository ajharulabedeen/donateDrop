package com.donatedrop.agent;

import com.donatedrop.agent.models.AgentBasic;
import com.donatedrop.profile.model.ProfileBasic;
import lombok.Builder;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class Dao_Agen_Impl implements Dao_Agen_I {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public AgentBasic getAgentBasic(String userID) {
        String sql = "SELECT\n" +
                "    *\n" +
                "FROM\n" +
                "    profilebasic\n" +
                "WHERE\n" +
                "    profilebasic.user_id IN(\n" +
                "    SELECT\n" +
                "        user_id_agent\n" +
                "    FROM\n" +
                "        donner_to_agent_request_review\n" +
                "    WHERE\n" +
                "        donner_to_agent_request_review.user_id_donner = '" + userID + "'\n" +
                "        AND donner_to_agent_request_review.status='ACCEPT'\n" +
                ")";
        ProfileBasic profileBasic = (ProfileBasic) entityManager.createNativeQuery(sql, ProfileBasic.class).getSingleResult();
        AgentBasic agentBasic = new AgentBasic();
        agentBasic.setName(profileBasic.getName());
        agentBasic.setEmmail(profileBasic.getEmail());
        agentBasic.setPhoneNumbers(profileBasic.getPhone_number());
        return agentBasic;
    }
}
