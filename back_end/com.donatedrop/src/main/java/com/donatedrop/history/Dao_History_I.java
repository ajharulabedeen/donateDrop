package com.donatedrop.history;

import java.util.Map;

public interface Dao_History_I {

    /**
     *
     * @param history
     * @return
     * @apiNote have to set the user_id, of the default logged user.
     */
    Map<String, String> save(History history);

}
