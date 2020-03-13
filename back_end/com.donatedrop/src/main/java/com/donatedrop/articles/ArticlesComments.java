/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.articles;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abedeen
 */
@Entity
@Table(name = "articles_comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticlesComments.findAll", query = "SELECT a FROM ArticlesComments a")
    , @NamedQuery(name = "ArticlesComments.findByCommentId", query = "SELECT a FROM ArticlesComments a WHERE a.commentId = :commentId")
    , @NamedQuery(name = "ArticlesComments.findByUserId", query = "SELECT a FROM ArticlesComments a WHERE a.userId = :userId")
    , @NamedQuery(name = "ArticlesComments.findByCommentDate", query = "SELECT a FROM ArticlesComments a WHERE a.commentDate = :commentDate")
    , @NamedQuery(name = "ArticlesComments.findByCommentUpVote", query = "SELECT a FROM ArticlesComments a WHERE a.commentUpVote = :commentUpVote")
    , @NamedQuery(name = "ArticlesComments.findByCommentDownVote", query = "SELECT a FROM ArticlesComments a WHERE a.commentDownVote = :commentDownVote")
    , @NamedQuery(name = "ArticlesComments.findByCommentContent", query = "SELECT a FROM ArticlesComments a WHERE a.commentContent = :commentContent")
    , @NamedQuery(name = "ArticlesComments.findByArticleIdComment", query = "SELECT a FROM ArticlesComments a WHERE a.articleIdComment = :articleIdComment")})
public class ArticlesComments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "comment_id")
    private Integer commentId;
    @Column(name = "user_id")
    private Integer userId;
    @Size(max = 255)
    @Column(name = "comment_date")
    private String commentDate;
    @Column(name = "comment_up_vote")
    private Integer commentUpVote;
    @Column(name = "comment_down_vote")
    private Integer commentDownVote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "comment_content")
    private String commentContent;
    @Column(name = "article_id_comment")
    private Integer articleIdComment;

    public ArticlesComments() {
    }

    public ArticlesComments(Integer commentId) {
        this.commentId = commentId;
    }

    public ArticlesComments(Integer commentId, String commentContent) {
        this.commentId = commentId;
        this.commentContent = commentContent;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getCommentUpVote() {
        return commentUpVote;
    }

    public void setCommentUpVote(Integer commentUpVote) {
        this.commentUpVote = commentUpVote;
    }

    public Integer getCommentDownVote() {
        return commentDownVote;
    }

    public void setCommentDownVote(Integer commentDownVote) {
        this.commentDownVote = commentDownVote;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getArticleIdComment() {
        return articleIdComment;
    }

    public void setArticleIdComment(Integer articleIdComment) {
        this.articleIdComment = articleIdComment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticlesComments)) {
            return false;
        }
        ArticlesComments other = (ArticlesComments) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ArticlesComments[ commentId=" + commentId + " ]";
    }
    
}
