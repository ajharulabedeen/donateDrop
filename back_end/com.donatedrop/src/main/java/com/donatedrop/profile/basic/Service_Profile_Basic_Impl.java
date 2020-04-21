package com.donatedrop.profile.basic;

import com.donatedrop.models.Address;
import com.donatedrop.profile.model.ProfileBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Service_Profile_Basic_Impl implements Service_Profile_Basic_I {

    @Autowired
    Dao_Profile_Basic_I dao_profile_basic_i;

    @Override
    public Map<String, String> save(ProfileBasic profileBasic) {
        if (profileBasic.getAddress_permanent() == null) {
            profileBasic.setAddress_permanent(new Address());
        }
        if (profileBasic.getAddress_present() == null) {
            profileBasic.setAddress_present(new Address());
        }
        return dao_profile_basic_i.save(profileBasic);
    }

    @Override
    public ProfileBasic findOneByUser(String userId) {
        return dao_profile_basic_i.findOneByUser(userId);
    }

    @Override
    public Map<String, String> basicExist(String userId) {
        return dao_profile_basic_i.basicExist(userId);
    }
}
