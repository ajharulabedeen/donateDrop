package com.donatedrop.post.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dell
 */
@Entity
@Table(name = "comment_with_user_info")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CommentWithUserInfo.findAll", query = "SELECT c FROM CommentWithUserInfo c")
        , @NamedQuery(name = "CommentWithUserInfo.findByCommentId", query = "SELECT c FROM CommentWithUserInfo c WHERE c.commentId = :commentId")
        , @NamedQuery(name = "CommentWithUserInfo.findByCommentDate", query = "SELECT c FROM CommentWithUserInfo c WHERE c.commentDate = :commentDate")
        , @NamedQuery(name = "CommentWithUserInfo.findByCommentUserId", query = "SELECT c FROM CommentWithUserInfo c WHERE c.commentUserId = :commentUserId")
        , @NamedQuery(name = "CommentWithUserInfo.findByPostId", query = "SELECT c FROM CommentWithUserInfo c WHERE c.postId = :postId")
        , @NamedQuery(name = "CommentWithUserInfo.findByName", query = "SELECT c FROM CommentWithUserInfo c WHERE c.name = :name")
        , @NamedQuery(name = "CommentWithUserInfo.findByEmail", query = "SELECT c FROM CommentWithUserInfo c WHERE c.email = :email")
        , @NamedQuery(name = "CommentWithUserInfo.findByGender", query = "SELECT c FROM CommentWithUserInfo c WHERE c.gender = :gender")
        , @NamedQuery(name = "CommentWithUserInfo.findByProfession", query = "SELECT c FROM CommentWithUserInfo c WHERE c.profession = :profession")})
public class CommentWithUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "comment_id")
    @Id
    private long commentId;
    @Lob
    @Column(name = "comment_details")
    private String commentDetails;
    @Column(name = "comment_date")
    private String commentDate;
    @Column(name = "comment_user_id")
    private String commentUserId;
    @Column(name = "post_id")
    private BigInteger postId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "profession")
    private String profession;

    public CommentWithUserInfo() {
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getCommentDetails() {
        return commentDetails;
    }

    public void setCommentDetails(String commentDetails) {
        this.commentDetails = commentDetails;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(String commentUserId) {
        this.commentUserId = commentUserId;
    }

    public BigInteger getPostId() {
        return postId;
    }

    public void setPostId(BigInteger postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "CommentWithUserInfo{" +
                "commentId=" + commentId +
                ", commentDetails='" + commentDetails + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", commentUserId='" + commentUserId + '\'' +
                ", postId=" + postId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}
