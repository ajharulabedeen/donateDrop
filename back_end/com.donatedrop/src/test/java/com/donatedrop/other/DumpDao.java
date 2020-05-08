package com.donatedrop.other;

import com.donatedrop.agent.AgentRequestReview;
import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.security.models.User;
import com.donatedrop.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    public List<AgentRequestReview> getAllAgentRequestReview() {
        String q = "SELECT * FROM `agent_request_review`";
        List<AgentRequestReview> agentRequestReviews
                = entityManager.createNativeQuery(q, AgentRequestReview.class)
                .getResultList();
        return agentRequestReviews;
    }

}
