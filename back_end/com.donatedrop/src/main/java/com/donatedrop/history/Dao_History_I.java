package com.donatedrop.history;

import com.donatedrop.profile.model.EmergencyContact;

import java.util.Map;

public interface Dao_History_I {

    /**
     * @param history
     * @return
     * @apiNote have to set the user_id, of the default logged user.
     */
    Map<String, String> save(History history);

    public Map<String, String> update(History history, String userID);

    /**
     * @return
     * @apiNote parent will not be back
     */
    public History findOne(String historyID);
    
    public Map<String, String> delete(String historyID, String userID);

}
