package com.donatedrop.profile;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@org.springframework.transaction.annotation.Transactional
public class Dao_Profile_Basic_Impl implements Dao_Profile_Basic_I {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String save(ProfileBasic profileBasic) {
        System.out.println("EntityManager : " + entityManager.toString());
        System.out.println("\nProfile Basic Save! Yet to implement!\n");
        entityManager.persist(profileBasic);
        return profileBasic.getId().toString();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
