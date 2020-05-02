/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.agent;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author G7
 */
@Entity
@Table(name="agent_request")
public class AgentRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "profile_id")
    private String profileID;

    @Column(name = "date_request")
    private String dateRequest;

    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public AgentRequest() {
    }

    public AgentRequest(String profileID, String dateRequest, String status) {
        this.profileID = profileID;
        this.dateRequest = dateRequest;
        this.status = status;
    }

    public AgentRequest(Long id, String profileID, String dateRequest, String status) {
        this.id = id;
        this.profileID = profileID;
        this.dateRequest = dateRequest;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfileID() {
        return profileID;
    }

    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    public String getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(String dateRequest) {
        this.dateRequest = dateRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgentRequest)) {
            return false;
        }
        AgentRequest other = (AgentRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donatedrop.agent.AgentRequest[ id=" + id + " ]";
    }

}
