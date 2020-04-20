package com.donatedrop.profile.basic;

import com.donatedrop.profile.model.ProfileBasic;

import java.util.Map;

public interface Service_Profile_Basic_I {

    /**
     * @return id after save the id will be returned.
     */
    public Map<String, String> save(ProfileBasic profileBasic);

    /**
     * @param userId where('user_id', $userId)->first();.
     * @return ProfileBasic here one profile basic will be returned.
     * @apiNote no child will be returned.
     */
    public ProfileBasic findOneByUser(String userId);

}
