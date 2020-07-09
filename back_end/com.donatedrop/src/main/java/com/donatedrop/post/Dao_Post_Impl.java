package com.donatedrop.post;

import com.donatedrop.agent.models.StatusType;
import com.donatedrop.history.History;
import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.util.DateUtil;
import com.donatedrop.util.StringUtil;
import javafx.geometry.Pos;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
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
            result.put(StringUtil.ID, post.getPostID().toString());
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
    public Map<String, String> updatePost(Post postNew) {
        Map<String, String> result = new HashMap<>();
        Post postOld = findPostByUserIDNoComment(postNew.getPostUserID(), postNew.getPostID().toString());
        if (postOld != null) {
            //refactor : follow emegency contact update
            postOld.setBloodType(postNew.getBloodType());
            postOld.setContactInfo(postNew.getContactInfo());
            postOld.setDonnerFound(postNew.getDonnerFound());
            postOld.setHospitalAddress(postNew.getHospitalAddress());
            postOld.setHospitalName(postNew.getHospitalName());
            postOld.setLocation(postNew.getLocation());
            postOld.setNeedDate(postNew.getNeedDate());
            postOld.setNotes(postNew.getNotes());
            postOld.setPatientDescription(postNew.getPatientDescription());
            postOld.setPatientGender(postNew.getPatientGender());
            postOld.setPostDate(postNew.getPostDate());
            postOld.setQuantity(postNew.getQuantity());
            postOld.setRelation(postNew.getRelation());
            postOld.setRemarks(postNew.getRemarks());
            postOld.setReport(postNew.getReport());
            postOld.setStatus(postNew.getStatus());
            try {
                entityManager.merge(postOld);
                result.put(StringUtil.STATUS, StringUtil.OK);
            } catch (Exception e) {
                System.out.println("Blood Post Update Failed!");
                result.put(StringUtil.STATUS, StringUtil.FAIL);
            }
        } else {
            System.out.println("Blood Post Not Found!");
            result.put(StringUtil.STATUS, StringUtil.FAIL);
        }
        return result;
    }


    @Override
    public Post findPostByUserIDNoComment(String userID, String postID) {
        String sql = "SELECT * FROM `post` WHERE `post_id`=" + postID + " AND `post_user_id`=" + userID;
        Post post = null;
        List<Post> list = entityManager
                .createNativeQuery(sql, Post.class)
                .getResultList();
        if (list.size() >= 1) {
            post = list.get(0);
        }
        return post;
    }

    @Override
    public Post findOnePostByID(String id) {
        Post post = null;
        try {
            post = entityManager.find(Post.class, Long.parseLong(id));
        } catch (Exception e) {
            System.out.println("Not Found!");
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public Map<String, String> deletePost(String id) {
        Map<String, String> result = new HashMap<>();
        try {
            Post postDelete = entityManager.find(Post.class,
                    Long.parseLong(id));
            //to protect one user delete, another users information. will be checked in Service
            entityManager.remove(postDelete);
            result.put(StringUtil.STATUS, StringUtil.OK);
        } catch (Exception e) {
            result.put(StringUtil.STATUS, StringUtil.FAIL);
        }
        return result;
    }
}
