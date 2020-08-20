package com.donatedrop.post.model;

public class CommentSave {
    private PostComment postComment;
    private String postID;

    public CommentSave(PostComment postComment, String postID) {
        this.postComment = postComment;
        this.postID = postID;
    }

    public PostComment getPostComment() {
        return postComment;
    }

    public void setPostComment(PostComment postComment) {
        this.postComment = postComment;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        this.postID = postID;
    }

    @Override
    public String toString() {
        return "CommentSave{" +
                "postComment=" + postComment +
                ", postID='" + postID + '\'' +
                '}';
    }
}
