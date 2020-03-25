package com.donatedrop.profile;

import org.springframework.stereotype.Component;

@Component
public class Dao_Profile_Basic_Impl implements Dao_Profile_Basic_I {

    @Override
    public String save(ProfileBasics profileBasic) {
        System.out.println("\nProfile Basic Save! Yet to implement!\n");
        return "";
    }

    @Override
    public boolean update(ProfileBasics profileBasicUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProfileBasics findOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProfileBasics findOneByUser(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String basicExist(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
