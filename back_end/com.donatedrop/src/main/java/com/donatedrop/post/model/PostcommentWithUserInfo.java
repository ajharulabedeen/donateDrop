/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.post.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dell
 */
@Entity
@Table(name = "postcomment_with_user_info")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "PostcommentWithUserInfo.findAll", query = "SELECT p FROM PostcommentWithUserInfo p")
        , @NamedQuery(name = "PostcommentWithUserInfo.findByCommentId", query = "SELECT p FROM PostcommentWithUserInfo p WHERE p.commentId = :commentId")
        , @NamedQuery(name = "PostcommentWithUserInfo.findByCommentDate", query = "SELECT p FROM PostcommentWithUserInfo p WHERE p.commentDate = :commentDate")
        , @NamedQuery(name = "PostcommentWithUserInfo.findByCommentUserId", query = "SELECT p FROM PostcommentWithUserInfo p WHERE p.commentUserId = :commentUserId")
        , @NamedQuery(name = "PostcommentWithUserInfo.findByPostId", query = "SELECT p FROM PostcommentWithUserInfo p WHERE p.postId = :postId")
        , @NamedQuery(name = "PostcommentWithUserInfo.findByName", query = "SELECT p FROM PostcommentWithUserInfo p WHERE p.name = :name")
        , @NamedQuery(name = "PostcommentWithUserInfo.findByProfession", query = "SELECT p FROM PostcommentWithUserInfo p WHERE p.profession = :profession")
        , @NamedQuery(name = "PostcommentWithUserInfo.findByBloodGroup", query = "SELECT p FROM PostcommentWithUserInfo p WHERE p.bloodGroup = :bloodGroup")})
public class PostcommentWithUserInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "comment_id")
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
    @Column(name = "profession")
    private String profession;
    @Column(name = "blood_Group")
    private String bloodGroup;

    //does the current logged user, owner of the comment or not.
    @Transient
    public boolean commentOwner;

    public PostcommentWithUserInfo() {
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public boolean isCommentOwner() {
        return commentOwner;
    }

    public void setCommentOwner(boolean commentOwner) {
        this.commentOwner = commentOwner;
    }

    @Override
    public String toString() {
        return "PostcommentWithUserInfo{" +
                "commentId=" + commentId +
                ", commentDetails='" + commentDetails + '\'' +
                ", commentDate='" + commentDate + '\'' +
                ", commentUserId='" + commentUserId + '\'' +
                ", postId=" + postId +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                '}';
    }
}
