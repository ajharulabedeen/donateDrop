/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.agent;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author G7
 */
@Entity
@Table(name = "agent_request_review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgentRequestToReview.findAll", query = "SELECT a FROM AgentRequestToReview a")
    , @NamedQuery(name = "AgentRequestToReview.findByProfileId", query = "SELECT a FROM AgentRequestToReview a WHERE a.profileId = :profileId")
    , @NamedQuery(name = "AgentRequestToReview.findByName", query = "SELECT a FROM AgentRequestToReview a WHERE a.name = :name")
    , @NamedQuery(name = "AgentRequestToReview.findByGender", query = "SELECT a FROM AgentRequestToReview a WHERE a.gender = :gender")
    , @NamedQuery(name = "AgentRequestToReview.findByProfession", query = "SELECT a FROM AgentRequestToReview a WHERE a.profession = :profession")
    , @NamedQuery(name = "AgentRequestToReview.findByUserId", query = "SELECT a FROM AgentRequestToReview a WHERE a.userId = :userId")
    , @NamedQuery(name = "AgentRequestToReview.findByAddressPermanent", query = "SELECT a FROM AgentRequestToReview a WHERE a.addressPermanent = :addressPermanent")
    , @NamedQuery(name = "AgentRequestToReview.findByAddressPresent", query = "SELECT a FROM AgentRequestToReview a WHERE a.addressPresent = :addressPresent")
    , @NamedQuery(name = "AgentRequestToReview.findByRequestId", query = "SELECT a FROM AgentRequestToReview a WHERE a.requestId = :requestId")
    , @NamedQuery(name = "AgentRequestToReview.findByRequestDate", query = "SELECT a FROM AgentRequestToReview a WHERE a.requestDate = :requestDate")
    , @NamedQuery(name = "AgentRequestToReview.findByStatus", query = "SELECT a FROM AgentRequestToReview a WHERE a.status = :status")
    , @NamedQuery(name = "AgentRequestToReview.findByNote", query = "SELECT a FROM AgentRequestToReview a WHERE a.note = :note")
    , @NamedQuery(name = "AgentRequestToReview.findByPresentId", query = "SELECT a FROM AgentRequestToReview a WHERE a.presentId = :presentId")
    , @NamedQuery(name = "AgentRequestToReview.findByPresentDiv", query = "SELECT a FROM AgentRequestToReview a WHERE a.presentDiv = :presentDiv")
    , @NamedQuery(name = "AgentRequestToReview.findByPresentDist", query = "SELECT a FROM AgentRequestToReview a WHERE a.presentDist = :presentDist")
    , @NamedQuery(name = "AgentRequestToReview.findByPresentUpz", query = "SELECT a FROM AgentRequestToReview a WHERE a.presentUpz = :presentUpz")
    , @NamedQuery(name = "AgentRequestToReview.findByPresentUnion", query = "SELECT a FROM AgentRequestToReview a WHERE a.presentUnion = :presentUnion")
    , @NamedQuery(name = "AgentRequestToReview.findByPresentStreet", query = "SELECT a FROM AgentRequestToReview a WHERE a.presentStreet = :presentStreet")
    , @NamedQuery(name = "AgentRequestToReview.findByPermanentId", query = "SELECT a FROM AgentRequestToReview a WHERE a.permanentId = :permanentId")
    , @NamedQuery(name = "AgentRequestToReview.findByPermanentDiv", query = "SELECT a FROM AgentRequestToReview a WHERE a.permanentDiv = :permanentDiv")
    , @NamedQuery(name = "AgentRequestToReview.findByPermanentDist", query = "SELECT a FROM AgentRequestToReview a WHERE a.permanentDist = :permanentDist")
    , @NamedQuery(name = "AgentRequestToReview.findByPermanentUpz", query = "SELECT a FROM AgentRequestToReview a WHERE a.permanentUpz = :permanentUpz")
    , @NamedQuery(name = "AgentRequestToReview.findByPermanentUnion", query = "SELECT a FROM AgentRequestToReview a WHERE a.permanentUnion = :permanentUnion")
    , @NamedQuery(name = "AgentRequestToReview.findByPermanentStreet", query = "SELECT a FROM AgentRequestToReview a WHERE a.permanentStreet = :permanentStreet")})
public class AgentRequestToReview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Id
    @Column(name = "profile_id")
    private long profileId;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "profession")
    private String profession;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "address_permanent")
    private BigInteger addressPermanent;
    @Column(name = "address_present")
    private BigInteger addressPresent;
    @Basic(optional = false)
    @Column(name = "request_id")
    private long requestId;
    @Column(name = "request_date")
    private String requestDate;
    @Column(name = "status")
    private String status;
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @Column(name = "present_id")
    private long presentId;
    @Column(name = "present_div")
    private String presentDiv;
    @Column(name = "present_dist")
    private String presentDist;
    @Column(name = "present_upz")
    private String presentUpz;
    @Column(name = "present_union")
    private String presentUnion;
    @Column(name = "present_street")
    private String presentStreet;
    @Column
    private String username;
    @Basic(optional = false)
    @Column(name = "permanent_id")
    private long permanentId;
    @Column(name = "permanent_div")
    private String permanentDiv;
    @Column(name = "permanent_dist")
    private String permanentDist;
    @Column(name = "permanent_upz")
    private String permanentUpz;
    @Column(name = "permanent_union")
    private String permanentUnion;
    @Column(name = "permanent_street")
    private String permanentStreet;

    public AgentRequestToReview() {
    }

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigInteger getAddressPermanent() {
        return addressPermanent;
    }

    public void setAddressPermanent(BigInteger addressPermanent) {
        this.addressPermanent = addressPermanent;
    }

    public BigInteger getAddressPresent() {
        return addressPresent;
    }

    public void setAddressPresent(BigInteger addressPresent) {
        this.addressPresent = addressPresent;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getPresentId() {
        return presentId;
    }

    public void setPresentId(long presentId) {
        this.presentId = presentId;
    }

    public String getPresentDiv() {
        return presentDiv;
    }

    public void setPresentDiv(String presentDiv) {
        this.presentDiv = presentDiv;
    }

    public String getPresentDist() {
        return presentDist;
    }

    public void setPresentDist(String presentDist) {
        this.presentDist = presentDist;
    }

    public String getPresentUpz() {
        return presentUpz;
    }

    public void setPresentUpz(String presentUpz) {
        this.presentUpz = presentUpz;
    }

    public String getPresentUnion() {
        return presentUnion;
    }

    public void setPresentUnion(String presentUnion) {
        this.presentUnion = presentUnion;
    }

    public String getPresentStreet() {
        return presentStreet;
    }

    public void setPresentStreet(String presentStreet) {
        this.presentStreet = presentStreet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getPermanentId() {
        return permanentId;
    }

    public void setPermanentId(long permanentId) {
        this.permanentId = permanentId;
    }

    public String getPermanentDiv() {
        return permanentDiv;
    }

    public void setPermanentDiv(String permanentDiv) {
        this.permanentDiv = permanentDiv;
    }

    public String getPermanentDist() {
        return permanentDist;
    }

    public void setPermanentDist(String permanentDist) {
        this.permanentDist = permanentDist;
    }

    public String getPermanentUpz() {
        return permanentUpz;
    }

    public void setPermanentUpz(String permanentUpz) {
        this.permanentUpz = permanentUpz;
    }

    public String getPermanentUnion() {
        return permanentUnion;
    }

    public void setPermanentUnion(String permanentUnion) {
        this.permanentUnion = permanentUnion;
    }

    public String getPermanentStreet() {
        return permanentStreet;
    }

    public void setPermanentStreet(String permanentStreet) {
        this.permanentStreet = permanentStreet;
    }



    @Override
    public String toString() {
        return "AgentRequestToReview{" +
                "profileId=" + profileId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", profession='" + profession + '\'' +
                ", userId='" + userId + '\'' +
                ", addressPermanent=" + addressPermanent +
                ", addressPresent=" + addressPresent +
                ", requestId=" + requestId +
                ", requestDate='" + requestDate + '\'' +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", presentId=" + presentId +
                ", presentDiv='" + presentDiv + '\'' +
                ", presentDist='" + presentDist + '\'' +
                ", presentUpz='" + presentUpz + '\'' +
                ", presentUnion='" + presentUnion + '\'' +
                ", presentStreet='" + presentStreet + '\'' +
                ", username='" + username + '\'' +
                ", permanentId=" + permanentId +
                ", permanentDiv='" + permanentDiv + '\'' +
                ", permanentDist='" + permanentDist + '\'' +
                ", permanentUpz='" + permanentUpz + '\'' +
                ", permanentUnion='" + permanentUnion + '\'' +
                ", permanentStreet='" + permanentStreet + '\'' +
                '}';
    }
}
