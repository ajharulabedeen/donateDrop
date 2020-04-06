package com.donatedrop.profile;

import com.donatedrop.profile.ProfileBasic;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.xml.transform.sax.SAXSource;
import java.util.HashMap;
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
            entityManager.remove(profileBasic);
            response.put("status", "OK");
        } catch (Exception e) {
            System.out.println("Profile Basic Delete Fail!");
            response.put("status", "FAIL");
//            e.printStackTrace();
        }
        System.out.println("response (dao) : " + response.toString());
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
        ProfileBasic profileBasic = (ProfileBasic) entityManager
                .createNativeQuery(sql, ProfileBasic.class)
                .getResultList()
                .get(0);
        //to avoid lazy init error.
        profileBasic.getEmergency_contact().forEach(c -> {});
        profileBasic.getPhone_number().forEach(p -> {});
        return profileBasic;
    }

    @Override
    public String basicExist(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> deleteAddress(String id) {
        Address address = entityManager.find(Address.class, new Long("37"));
        address.setDivision("KDK)");
        entityManager.merge(address);
        return null;
    }

}
