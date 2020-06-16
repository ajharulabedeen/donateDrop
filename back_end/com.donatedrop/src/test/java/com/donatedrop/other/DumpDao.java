package com.donatedrop.other;

import com.donatedrop.agent.admin.model.AgentRequest;
import com.donatedrop.agent.admin.model.AgentRequestToReview;
import com.donatedrop.agent.donner.models.DonnerRequestToAgent;
import com.donatedrop.geocode.Dao_GeoCode_I;
import com.donatedrop.geocode.models.DistrictsEngName;
import com.donatedrop.geocode.models.DivisionsEngName;
import com.donatedrop.geocode.models.UnionsEngName;
import com.donatedrop.geocode.models.UpzillaEngName;
import com.donatedrop.models.Address;
import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.security.models.User;
import com.donatedrop.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Component
public class DumpDao {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    Dao_GeoCode_I dao_GeoCode_I;


    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //    start : profile
//    SELECT * FROM user WHERE user.ID NOT IN ( SELECT profilebasic.user_id from profilebasic )
//    SELECT id FROM user WHERE user.ID NOT IN ( SELECT profilebasic.user_id from profilebasic)
    public List<User> getUserIDNotInProfileID(int max) {
        String sql = "SELECT * FROM user WHERE user.ID NOT IN ( SELECT profilebasic.user_id from profilebasic)";
        List<User> list = entityManager.createNativeQuery(sql, User.class).setMaxResults(max).getResultList();
        return list;
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

    @Transactional
    public void insertProfileBasicBatch(List<ProfileBasic> basicList) throws Exception {
//        throw new Exception("Are you to dele all profile! If Sure, please active the method code.");
        for (Iterator<ProfileBasic> iterator = basicList.iterator(); iterator.hasNext(); ) {
            ProfileBasic next = iterator.next();
            entityManager.persist(next);
        }
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

//    end : profile


    public List<AgentRequest> getAgentAdminRequests(int start, int max) {
        String q = "SELECT * FROM `agent_request`";
        return entityManager
                .createNativeQuery(q, AgentRequest.class)
                .setFirstResult(start)
                .setMaxResults(max)
                .getResultList();
    }

    public List<DonnerRequestToAgent> getAgentDonnersRequests(int start, int max) {
        String q = "SELECT * FROM `request_donner_to_agent`";
        return entityManager
                .createNativeQuery(q, DonnerRequestToAgent.class)
                .setFirstResult(start)
                .setMaxResults(max)
                .getResultList();
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

    public List<BigInteger> getNotRequestedAsAgentUsers(int start, int max) {
        String q = "SELECT `user`.`ID` FROM `user` WHERE `user`.`ID` NOT IN (SELECT `agent_request`.`user_id` FROM `agent_request`)";
        return entityManager.createNativeQuery(q)
                .setFirstResult(start)
                .setMaxResults(max)
                .getResultList();
    }

    public List<BigInteger> getNotRequestedDonnerToAgentUsers(int start, int max) {
        String q = "SELECT `user`.`ID` FROM `user` WHERE `user`.`ID` NOT IN( SELECT `request_donner_to_agent`.`user_id_donner` FROM `request_donner_to_agent` )";
        return entityManager.createNativeQuery(q)
                .setFirstResult(start)
                .setMaxResults(max)
                .getResultList();
    }

    public List<BigInteger> getNotRequestedDonnerToAgentUsersCount() {
        String q = "SELECT count(*) FROM `user` WHERE `user`.`ID` NOT IN( SELECT `request_donner_to_agent`.`user_id_donner` FROM `request_donner_to_agent` )";
        return entityManager.createNativeQuery(q).getResultList();
    }


    public Address getAddress(String type) {
        Random r = new Random();
        String divID = "";
        String divName = "";
        String distID = "";
        String distName = "";
        String upzID = "";
        String upzName = "";
        String unionID = "";
        String unionName = "";

        Address address = new Address();
        address.setType(type);
        try {
            List<DivisionsEngName> divisionsList = dao_GeoCode_I.getDivisions();
            int divRand = r.nextInt(divisionsList.size() - 1);
            divID = divisionsList.get(divRand).getId().toString();
            divName = divisionsList.get(divRand).getName().toString();
            address.setDivision(divName);
        } catch (Exception e) {
            System.out.println("Exception in Gettting Division!" + divID + "\n");
        }
        try {
            List<DistrictsEngName> districtsEngNameList = dao_GeoCode_I.getDistricts(divID);
            int distRand = r.nextInt(districtsEngNameList.size() - 1);
            distID = districtsEngNameList.get(distRand).getId().toString();
            distName = districtsEngNameList.get(distRand).getName().toString();
            address.setDistrict(distName);
        } catch (Exception e) {
            System.out.println("Exception in Gettting District! : " + distID + "\n");
        }
        try {
            List<UpzillaEngName> upzillaEngNameList = dao_GeoCode_I.getUpzillas(distID);
            int upzRand = r.nextInt(upzillaEngNameList.size() - 1);
            upzID = upzillaEngNameList.get(upzRand).getId().toString();
            upzName = upzillaEngNameList.get(upzRand).getName().toString();
            address.setUpzilla(upzName);
        } catch (Exception e) {
            System.out.println("Exception in Gettting Upzilla! : " + upzID + "\n");
        }
        try {
            List<UnionsEngName> unionsEngNameList = dao_GeoCode_I.getUnions(upzID);
            int unionRand = r.nextInt(unionsEngNameList.size() - 1);
            unionID = unionsEngNameList.get(unionRand).getId().toString();
            unionName = unionsEngNameList.get(unionRand).getName().toString();
            address.setUnion_ward(unionName);
        } catch (Exception e) {
            System.out.println("Exception in Gettting Unions! : " + unionID + "\n");
        }
        address.setStreet_address(DumpData.getStreetAddress());
        return address;
    }

    public String getAddressString(String type) {
        Random r = new Random();
        String divID = "";
        String divName = "";
        String distID = "";
        String distName = "";
        String upzID = "";
        String upzName = "";
        String unionID = "";
        String unionName = "";

        Address address = new Address();
        address.setType(type);
        try {
            List<DivisionsEngName> divisionsList = dao_GeoCode_I.getDivisions();
            int divRand = r.nextInt(divisionsList.size() - 1);
            divID = divisionsList.get(divRand).getId().toString();
            divName = divisionsList.get(divRand).getName().toString();
            address.setDivision(divName);
        } catch (Exception e) {
            System.out.println("Exception in Gettting Division!" + divID + "\n");
        }
        try {
            List<DistrictsEngName> districtsEngNameList = dao_GeoCode_I.getDistricts(divID);
            int distRand = r.nextInt(districtsEngNameList.size() - 1);
            distID = districtsEngNameList.get(distRand).getId().toString();
            distName = districtsEngNameList.get(distRand).getName().toString();
            address.setDistrict(distName);
        } catch (Exception e) {
            System.out.println("Exception in Gettting District! : " + distID + "\n");
        }
        try {
            List<UpzillaEngName> upzillaEngNameList = dao_GeoCode_I.getUpzillas(distID);
            int upzRand = r.nextInt(upzillaEngNameList.size() - 1);
            upzID = upzillaEngNameList.get(upzRand).getId().toString();
            upzName = upzillaEngNameList.get(upzRand).getName().toString();
            address.setUpzilla(upzName);
        } catch (Exception e) {
            System.out.println("Exception in Gettting Upzilla! : " + upzID + "\n");
        }
        try {
            List<UnionsEngName> unionsEngNameList = dao_GeoCode_I.getUnions(upzID);
            int unionRand = r.nextInt(unionsEngNameList.size() - 1);
            unionID = unionsEngNameList.get(unionRand).getId().toString();
            unionName = unionsEngNameList.get(unionRand).getName().toString();
            address.setUnion_ward(unionName);
        } catch (Exception e) {
            System.out.println("Exception in Gettting Unions! : " + unionID + "\n");
        }
        address.setStreet_address(DumpData.getStreetAddress());
        return address.getStreet_address() + address.getUnion_ward() + ", " + address.getDistrict() + ", " + address.getDivision();
    }


    //    start : no need :
    public List<AgentRequestToReview> getAllAgentRequestReviewPhoneNumber(int start, int max, String column, String key) {
//        String q = "SELECT * FROM `agent_request_review`";
        List<AgentRequestToReview> agentRequestReviews = new ArrayList<>();
        try {
            String q = "SELECT agent_request_review.* FROM agent_request_review, phonenumber "
                    + "WHERE agent_request_review.profile_id = phonenumber.profile_id "
                    + "AND phonenumber.number LIKE '" + key + "'";
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
//    end : no need :
}
