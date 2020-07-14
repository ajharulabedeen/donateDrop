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
    public Map<String, String> deletePost(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> updatePostComment(PostComment postComment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, String> deletePostComment(PostComment postCommentOld) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
