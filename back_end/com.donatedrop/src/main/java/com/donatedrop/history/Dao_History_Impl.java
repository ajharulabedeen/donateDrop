package com.donatedrop.history;

import com.donatedrop.util.StringUtil;
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

    @Override
    public Map<String, String> save(History history) {
        Map<String, String> status = new HashMap<>();
        try {
            entityManager.persist(history);
            status.put(StringUtil.STATUS, StringUtil.OK);
            status.put(StringUtil.ID, history.getId().toString());
        } catch (Exception e) {
            status.put(StringUtil.STATUS, StringUtil.FAIL);
        }
        return status;
    }


}
