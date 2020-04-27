package com.donatedrop.history;

import com.donatedrop.profile.basic.Dao_Profile_Basic_I;
import com.donatedrop.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class Dao_History_Impl implements Dao_History_I {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    Dao_Profile_Basic_I dao_profile_basic_i;

    @Override
    public Map<String, String> save(History history) {
        Map<String, String> status = new HashMap<>();
        try {
            history.setProfileBasic(dao_profile_basic_i
                    .getProfileBasicByUserID(history.getUserId()));
            entityManager.persist(history);
            status.put(StringUtil.STATUS, StringUtil.OK);
            status.put(StringUtil.ID, history.getId().toString());
        } catch (Exception e) {
            status.put(StringUtil.STATUS, StringUtil.FAIL);
        }
        return status;
    }


}
