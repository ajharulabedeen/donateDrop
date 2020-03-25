/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.profile;

/**
 *
 * @author G7
 */
public interface Dao_Profile_Basic_I {
    /**
     * @return  id  after save the id will be returened.
     */
    public String save(ProfileBasics profileBasic);
    /**
     * @return  boolean status will be returned as "0" or "1".
     */
    public boolean update(ProfileBasics profileBasicUpdate);
    public String delete(String id);
    /**
     *  @param  id here id is the primary key of the BasicRepo, it is not the userID.
     *  @return ProfileBasic    here one profile basic will be returned.
     *  @uses   currently not any use.
     */
    public ProfileBasics findOne( String id);
    /**
     *  @param userId where('user_id', $userId)->first();.
     *  @return ProfileBasic    here one profile basic will be returned.
     */
    public ProfileBasics findOneByUser( String userId);
    public String basicExist( String userId );
}