package com.donatedrop.profile;

import com.donatedrop.profile.ProfileBasic;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class Dao_Profile_Basic_Impl implements Dao_Profile_Basic_I {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String save(ProfileBasic profileBasic) {
        String status = "";
        try {
            entityManager.persist(profileBasic);
            status = "OK";
        } catch (Exception e) {
            status = "FAIL";
            System.out.println("Profile Save Fail!");
            //refactor : separate log file.
            e.printStackTrace();
        }
        return status;
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
            e.printStackTrace();
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
