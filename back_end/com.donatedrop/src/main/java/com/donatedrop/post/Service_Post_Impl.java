package com.donatedrop.post;

import com.donatedrop.util.StringUtil;
import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.stream.events.Comment;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Service_Post_Impl implements Service_Post_I {

    @Autowired
    Dao_Post_I dao_post_i;

    @Override
    public Map<String, String> savePost(Post post) {
        return dao_post_i.savePost(post);
    }

    @Override
    public Map<String, String> updatePost(Post post) {
        Post p = dao_post_i.findPostByUserIDNoComment(post.getPostUserID(), post.getPostID().toString());
        Map<String, String> status = new HashMap<>();
        if (p != null) {
            return dao_post_i.updatePost(post);
        } else {
            status.put(StringUtil.STATUS, StringUtil.FAIL);
            status.put(StringUtil.MESSAGE, StringUtil.UNAUTHERIZED);
        }
        return status;
    }

    @Override
    public Post findPostByUserIDNoComment(String userID, String postID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Post findOnePostByID(String id) {
        return dao_post_i.findOnePostByID(id);
    }

    @Override
    public Map<String, String> deletePost(String userID, String postID) {
        Post p = dao_post_i.findPostByUserIDNoComment(userID, postID);
        Map<String, String> status = new HashMap<>();
        if (p != null) {
            return dao_post_i.deletePost(postID);
        } else {
            status.put(StringUtil.STATUS, StringUtil.FAIL);
            status.put(StringUtil.MESSAGE, StringUtil.UNAUTHERIZED);
        }
        return status;
    }

    @Override
    public Post findPostWithComments(String postID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> saveComment(PostComment postComment, String postID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PostComment findOneComment(String postID, String userID, String commentID) {
        return dao_post_i.findOneComment(postID, userID, commentID);
    }

    @Override
    public Map<String, String> updatePostComment(PostComment postComment, String postID) {
        Map<String, String> status = new HashMap<>();
        PostComment pc = dao_post_i.findOneComment(postID, postComment.getUserID(), postComment.getCommentID().toString());
        if (pc != null) {
            return dao_post_i.updatePostComment(postComment);
        } else {
            status.put(StringUtil.STATUS, StringUtil.FAIL);
            status.put(StringUtil.MESSAGE, StringUtil.UNAUTHERIZED);
        }
        return status;
    }

    @Override
    public Map<String, String> deletePostComment(String postID, PostComment postCommentOld) {
        PostComment postComment = dao_post_i.findOneComment(postID, postCommentOld.getUserID(), postCommentOld.getCommentID().toString());
        Map<String, String> status = new HashMap<>();
        if (postComment != null) {
            return dao_post_i.deletePostComment(postCommentOld);
        } else {
            status.put(StringUtil.STATUS, StringUtil.FAIL);
            status.put(StringUtil.MESSAGE, StringUtil.UNAUTHERIZED);
        }
        return status;
    }

    @Override
    public List<Post> getAllPostsByAnUser(PostSearch postSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String countAllPostsByAnUser(PostSearch postSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> getAllPostsByAnUserWithinDate(PostSearch postSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String countAllPostsByAnUserWithinDate(PostSearch postSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String countCommentsOfAPost(String postID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CommentWithUserInfo> getCommentWithUserInfo(String postID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
