package com.donatedrop.agent.donner;

import com.donatedrop.agent.donner.models.DonnerAssingment;
import com.donatedrop.agent.models.StatusType;
import com.donatedrop.profile.basic.Dao_Profile_Basic_I;
import com.donatedrop.util.DateUtil;
import com.donatedrop.util.StringUtil;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class Dao_DonnerAssign_Impl implements Dao_DonnerAssign_I {

    @PersistenceContext
    EntityManager entityManager;

    public Map<String, String> save(DonnerAssingment donnerAssingment) {
        Map<String, String> result = new HashMap<>();
        try {
            donnerAssingment.setAssingDate(DateUtil.getDate());
            donnerAssingment.setBloodManageStatus(StatusType.ZERO);
            entityManager.persist(donnerAssingment);
            result.put(StringUtil.STATUS, StringUtil.OK);
            result.put(StringUtil.MESSAGE, StringUtil.SAVE);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
            result.put(StringUtil.MESSAGE, StringUtil.DUPLICATE);
        } catch (ConstraintViolationException constraintViolationException) {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
            result.put(StringUtil.MESSAGE, StringUtil.DUPLICATE);
        } catch (Exception e) {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
            result.put(StringUtil.MESSAGE, StringUtil.UNKNOWN);
        }
        return result;
    }


    public Map<String, String> delete(String donnerAssingmentID) {
        return null;
    }

    public Map<String, String> update(DonnerAssingment donnerAssingment) {
        return null;
    }

//    public List
}
