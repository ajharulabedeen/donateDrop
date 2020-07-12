package com.donatedrop.post;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.Map;

public interface Dao_Post_I {
    public Map<String, String> savePost(Post post);

    public Map<String, String> updatePost(Post post);

    public Post findPostByUserIDNoComment(String userID, String postID);

    public Post findOnePostByID(String id);

    public Map<String, String> deletePost(String id);

    public Post findPostWithComments(String postID);

    public Map<String, String> saveComment(PostComment postComment, String postID);

    public PostComment findPostComment(String postID, String userID, String commentID);

    Map<String, String> updatePostComment(PostComment postComment);

    Map<String, String> deletePostComment(PostComment postCommentOld);

    List<Post> getAllPostsByUser(String userID, int start, int max);
}
