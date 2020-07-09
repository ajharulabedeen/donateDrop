package com.donatedrop.post;

import java.util.Map;

public interface Dao_Post_I {
    public Map<String, String> savePost(Post post);

    public Map<String, String> editPost(Post post);

    public Post findPostByUserIDNoComment(String userID, String postID);
}
