package com.donatedrop.other;

import com.donatedrop.agent.AgentRequestReview;
import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.security.models.User;
import com.donatedrop.security.repo.UserRepository;
import com.sun.javafx.scene.control.skin.TableHeaderRow;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public void deleteAll_ProfileBasic() {
        String q = "SELECT * FROM `profilebasic`";
        List<ProfileBasic> basicList = entityManager.createNativeQuery(q, ProfileBasic.class).getResultList();
        for (Iterator<ProfileBasic> iterator = basicList.iterator(); iterator.hasNext(); ) {
            ProfileBasic next = iterator.next();
            entityManager.remove(next);
        }
    }

    public void insertProfileBasicBatch(List<ProfileBasic> basicList) {
        for (Iterator<ProfileBasic> iterator = basicList.iterator(); iterator.hasNext(); ) {
            ProfileBasic next = iterator.next();
            entityManager.persist(next);
        }
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

    /**
     * @param start
     * @param max
     * @param column
     * @param key
     * @return
     * @apiNote No need any more, used in main code.
     */
    public List<AgentRequestReview> getAllAgentRequestReview(int start, int max, String column, String key) {
//        String q = "SELECT * FROM `agent_request_review`";
        List<AgentRequestReview> agentRequestReviews = new ArrayList<>();
        try {
            String q = "SELECT * FROM `agent_request_review` WHERE `agent_request_review`.`" + column + "` LIKE '" + key + "'";
            agentRequestReviews
                    = entityManager.createNativeQuery(q, AgentRequestReview.class)
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
