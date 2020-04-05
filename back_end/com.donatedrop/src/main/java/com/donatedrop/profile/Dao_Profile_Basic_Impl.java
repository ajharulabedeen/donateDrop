package com.donatedrop.profile;

import com.donatedrop.profile.ProfileBasic;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
        Map<String, String> stat = new HashMap<>();
        stat.put("status", status);
        if (status.equals("OK")) {
            stat.put("id", id);
        } else {
            stat.put("id", null);
        }
        System.out.println(stat.toString());
        return stat;
    }

    @Override
    public boolean update(ProfileBasic profileBasicUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProfileBasic findOne(String id) {
        ProfileBasic profileBasic = null;
        try {
            profileBasic = entityManager.find(ProfileBasic.class, Long.parseLong(id));
        } catch (Exception e) {
            System.out.println("Not Found!");
//            e.printStackTrace();
        }
        return profileBasic;
    }

    @Override
    public ProfileBasic findOneByUser(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String basicExist(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
