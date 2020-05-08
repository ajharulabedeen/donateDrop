package com.donatedrop.other;

import com.donatedrop.agent.AgentRequest;
import com.donatedrop.agent.AgentRequestToReview;
import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.security.models.User;
import com.donatedrop.security.repo.UserRepository;
import com.sun.javafx.scene.control.skin.TableHeaderRow;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Component
public class DumpDao {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<ProfileBasic> getAllProfileBasic(int start, int max) {
        String q = "SELECT * FROM `profilebasic`";
        List<ProfileBasic> basicList
                = entityManager.createNativeQuery(q, ProfileBasic.class)
                .setFirstResult(start)
                .setMaxResults(max)
                .getResultList();
        return basicList;
    }

    public List<AgentRequest> getAgentRequests(int start, int max) {
        String q = "SELECT * FROM `agent_request`";
        return entityManager
                .createNativeQuery(q, AgentRequest.class)
                .setFirstResult(start)
                .setMaxResults(max)
                .getResultList();
    }

    public void deleteAll_ProfileBasic() throws Exception {
        throw new Exception("Are you to dele all profile! If Sure, please active the method code.");
//        String q = "SELECT * FROM `profilebasic`";
//        List<ProfileBasic> basicList = entityManager.createNativeQuery(q, ProfileBasic.class).getResultList();
//        for (Iterator<ProfileBasic> iterator = basicList.iterator(); iterator.hasNext(); ) {
//            ProfileBasic next = iterator.next();
//            entityManager.remove(next);
//        }
    }

    public void insertProfileBasicBatch(List<ProfileBasic> basicList) throws Exception {
        throw new Exception("Are you to dele all profile! If Sure, please active the method code.");
        //        for (Iterator<ProfileBasic> iterator = basicList.iterator(); iterator.hasNext(); ) {
//            ProfileBasic next = iterator.next();
//            entityManager.persist(next);
//        }
    }

    public List<User> getUsers(int start, int max) {
        String q = "SELECT * FROM `user`";
        List<User> userList
                = entityManager.createNativeQuery(q, User.class)
                .setFirstResult(start)
                .setMaxResults(max)
                .getResultList();
        return userList;
    }

    public List<BigInteger> getNotRequestedAgentUser(int start, int max) {
        String q = "SELECT `user`.`ID` FROM `user` WHERE `user`.`ID` NOT IN (SELECT `agent_request`.`user_id` FROM `agent_request`)";
        return entityManager.createNativeQuery(q)
                .setFirstResult(start)
                .setMaxResults(max)
                .getResultList();
    }

    /**
     * @param start
     * @param max
     * @param column
     * @param key
     * @return
     * @apiNote No need any more, used in main code.
     */
    public List<AgentRequestToReview> getAllAgentRequestReview(int start, int max, String column, String key) {
//        String q = "SELECT * FROM `agent_request_review`";
        List<AgentRequestToReview> agentRequestReviews = new ArrayList<>();
        try {
            String q = "SELECT * FROM `agent_request_review` WHERE `agent_request_review`.`" + column + "` LIKE '" + key + "'";
            agentRequestReviews
                    = entityManager.createNativeQuery(q, AgentRequestToReview.class)
                    .setFirstResult(start)
                    .setMaxResults(max)
                    .getResultList();
            return agentRequestReviews;
        } catch (Exception exception) {
            System.out.println("org.hibernate.exception.SQLGrammarException");
        }
        return agentRequestReviews;
    }

}
