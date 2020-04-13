/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.profile.basic;

import com.donatedrop.model.Address;
import com.donatedrop.articles.PhoneNumber;
import com.donatedrop.profile.model.ProfileBasic;

import java.util.Map;

/**
 * @author G7
 */
public interface Dao_Profile_Basic_I {

    /**
     * @return id after save the id will be returned.
     */
    public Map<String, String> save(ProfileBasic profileBasic);

    /**
     * @return boolean status will be returned as "0" or "1".
     */
    public Map<String, String> update(ProfileBasic profileBasicUpdate);

    /**
     * @param id PK of Profile basic.
     * @return response will be back as HasMap.
     */
    public Map<String, String> delete(String id);

    /**
     * @param id here id is the primary key of the BasicRepo, it is not the
     * userID.
     * @return ProfileBasic here one profile basic will be returned.
     * @implNote Not in user now.ff
     */
    public ProfileBasic findOne(String id);

    /**
     * @param userId where('user_id', $userId)->first();.
     * @return ProfileBasic here one profile basic will be returned.
     */
    public ProfileBasic findOneByUser(String userId);

    /**
     * @param userId
     * @return Map Not Exist : {status=false}; Exist : {status=true}
     */
    public Map<String, String> basicExist(String userId);

    /**
     * @param address PK of the Address.
     * @return Map<String,String> = {"status","OK"} -/- {"status","FAIL"}
     */
    public Map<String, String> updatePresentAddress(Address address, String userID);

    /**
     * @param address PK of the Address.
     * @return Map<String,String> = {"status","OK"} -/- {"status","FAIL"}
     */
    public Map<String, String> updatePermanentAddress(Address address, String userID);

    /**
     *
     * @param phoneNumber
     * @param userID
     * @return success status.
     */
    public Map<String, String> addPhoneNumber(PhoneNumber phoneNumber, String userID);

    public Map<String, String> deletePhoneNumber(String phoneNumberID, String userID);

    public Map<String, String> addEmergencyContact(EmergencyContact emergencyContact, String userID);

    public Map<String, String> deleteEmergencyContact(String emergencyContactID, String userID);

    public Map<String, String> updateEmergencyContact(EmergencyContact emergencyContactUpdate, String userID);

}
