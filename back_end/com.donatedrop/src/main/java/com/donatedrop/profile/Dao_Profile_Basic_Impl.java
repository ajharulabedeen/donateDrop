package com.donatedrop.profile;

import com.donatedrop.profile.ProfileBasic;
import com.donatedrop.util.Utils;
import com.sun.scenario.effect.impl.prism.PrFilterContext;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.xml.transform.sax.SAXSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional
public class Dao_Profile_Basic_Impl implements Dao_Profile_Basic_I {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Map<String, String> save(ProfileBasic profileBasic) {
        String status = "";
        String id = "";
        try {
            entityManager.persist(profileBasic);
            status = "OK";
            id = profileBasic.getId().toString();
        } catch (Exception e) {
            status = "FAIL";
            System.out.println("Profile Save Fail!");
            //refactor : separate log file.
            e.printStackTrace();
        }
        Map<String, String> response = new HashMap<>();
        response.put("status", status);
        if (status.equals("OK")) {
            response.put("id", id);
        } else {
            response.put("id", null);
        }
        //refactor
        System.out.println(response.toString());
        return response;
    }

    @Override
    public boolean update(ProfileBasic profileBasicUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> delete(String id) {
        System.out.println("DAO Delete: ");
        Map<String, String> response = new HashMap<>();
        try {
            ProfileBasic profileBasic = entityManager.find(ProfileBasic.class, new Long(id));
            if (profileBasic == null) {
                System.out.println("No entity found!");
                response.put("status", "FAIL");
            } else {
                entityManager.remove(profileBasic);
                response.put("status", "OK");
            }
        } catch (Exception e) {
            System.out.println("Profile Basic Delete Fail!");
//            e.printStackTrace();
        }
//        System.out.println("response (dao) : " + response.toString());
        return response;
    }

    @Override
    public ProfileBasic findOne(String id) {
        ProfileBasic profileBasic = null;
        try {
            profileBasic = entityManager.find(ProfileBasic.class, Long.parseLong(id));
        } catch (Exception e) {
            System.out.println("Not Found!");
            e.printStackTrace();
        }
        return profileBasic;
    }

    @Override
    public ProfileBasic findOneByUser(String userId) {
        String sql = "SELECT *FROM profilebasic WHERE user_id =" + userId;
        ProfileBasic profileBasic = null;
        List<ProfileBasic> list = entityManager
                .createNativeQuery(sql, ProfileBasic.class)
                .getResultList();
        if (list.size() >= 1) {
            profileBasic = list.get(0);
            //to avoid lazay init error.
            profileBasic.getEmergency_contact().forEach(c -> {
            });
            profileBasic.getPhone_number().forEach(p -> {
            });
            System.out.println(profileBasic);
        }
        return profileBasic;
    }

    /**
     * better to keep, basicExist and findOneByUser, separate. caue
     * findOneByUser has child init, can be problem, if mulitple times called.
     *
     * @param userId
     * @return
     */
    @Override
    public Map<String, Boolean> basicExist(String userId) {
        Map<String, Boolean> result = new HashMap<>();
        String sql = "SELECT *FROM profilebasic WHERE user_id =" + userId;
        List<ProfileBasic> list = entityManager
                .createNativeQuery(sql, ProfileBasic.class)
                .getResultList();
        if (list.size() >= 1) {
            result.put("status", true);
        } else {
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, String> updatePresentAddress(Address addressPresentNew, String userID) {
        String sql = "SELECT *FROM profilebasic WHERE user_id =" + userID;
        Map<String, String> result = new HashMap<>();
        // dont use find by one userID, it will init all children.
        List<ProfileBasic> list = entityManager
                .createNativeQuery(sql, ProfileBasic.class)
                .getResultList();
        ProfileBasic profileBasic = null;
        Address addressOld = null;
        if (list.size() >= 1) {
            addressOld = list.get(0).getAddress_present();
            addressOld.setDivision(addressPresentNew.getDivision());
            addressOld.setDistrict(addressPresentNew.getDistrict());
            addressOld.setUpzilla(addressPresentNew.getUpzilla());
            addressOld.setUnion_ward(addressPresentNew.getUnion_ward());
            addressOld.setStreet_address(addressPresentNew.getStreet_address());
            try {
                entityManager.merge(addressOld);
                result.put(Utils.key(), Utils.ok());
            } catch (Exception e) {
                result.put(Utils.key(), Utils.fail());
            }
        } else {
            result.put(Utils.key(), Utils.fail());
        }
        return result;
    }

    @Override
    public Map<String, String> updatePermanentAddress(Address addressPermanentNew, String userID) {
        String sql = "SELECT *FROM profilebasic WHERE user_id =" + userID;
        Map<String, String> result = new HashMap<>();
        // dont use find by one userID, it will init all children.
        List<ProfileBasic> list = entityManager
                .createNativeQuery(sql, ProfileBasic.class)
                .getResultList();
        ProfileBasic profileBasic = null;
        Address addressPermanentOld = null;
        if (list.size() >= 1) {
            addressPermanentOld = list.get(0).getAddress_permanent();
            addressPermanentOld.setDivision(addressPermanentNew.getDivision());
            addressPermanentOld.setDistrict(addressPermanentNew.getDistrict());
            addressPermanentOld.setUpzilla(addressPermanentNew.getUpzilla());
            addressPermanentOld.setUnion_ward(addressPermanentNew.getUnion_ward());
            addressPermanentOld.setStreet_address(addressPermanentNew.getStreet_address());
            try {
                entityManager.merge(addressPermanentOld);
                result.put(Utils.key(), Utils.ok());
            } catch (Exception e) {
                result.put(Utils.key(), Utils.fail());
            }
        } else {
            result.put(Utils.key(), Utils.fail());
        }
        return result;
    }
    
    
}// class 
