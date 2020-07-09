package com.donatedrop.post;

import com.donatedrop.agent.models.StatusType;
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
public class Dao_Post_Impl implements Dao_Post_I {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Map<String, String> savePost(Post post) {
        Map<String, String> result = new HashMap<>();
        try {
            post.setPostDate(DateUtil.getDate());
            post.setStatus(StatusType.ZERO);
            entityManager.persist(post);
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

    @Override
    public Map<String, String> editPost(Post post) {
        return null;
    }
}
