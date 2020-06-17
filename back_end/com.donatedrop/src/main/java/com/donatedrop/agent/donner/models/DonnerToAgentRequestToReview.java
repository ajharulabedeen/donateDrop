/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.agent.donner.models;

import com.donatedrop.profile.model.PhoneNumber;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author G7
 */
@Entity
@Table(name = "donner_to_agent_request_review")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DonnerToAgentRequestToReview.findAll", query = "SELECT d FROM DonnerToAgentRequestToReview d")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByProfileId", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.profileId = :profileId")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByName", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.name = :name")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByGender", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.gender = :gender")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByProfession", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.profession = :profession")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByUserId", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.userId = :userId")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByAddressPermanent", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.addressPermanent = :addressPermanent")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByAddressPresent", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.addressPresent = :addressPresent")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByRequestId", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.requestId = :requestId")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByRequestDate", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.requestDate = :requestDate")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByAcceptDate", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.acceptDate = :acceptDate")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByRejectDate", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.rejectDate = :rejectDate")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByRemoveDate", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.removeDate = :removeDate")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByStatus", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.status = :status")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPresentId", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.presentId = :presentId")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPresentDiv", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.presentDiv = :presentDiv")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPresentDist", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.presentDist = :presentDist")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPresentUpz", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.presentUpz = :presentUpz")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPresentUnion", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.presentUnion = :presentUnion")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPresentStreet", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.presentStreet = :presentStreet")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByUsername", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.username = :username")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPermanentId", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.permanentId = :permanentId")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPermanentDiv", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.permanentDiv = :permanentDiv")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPermanentDist", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.permanentDist = :permanentDist")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPermanentUpz", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.permanentUpz = :permanentUpz")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPermanentUnion", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.permanentUnion = :permanentUnion")
        , @NamedQuery(name = "DonnerToAgentRequestToReview.findByPermanentStreet", query = "SELECT d FROM DonnerToAgentRequestToReview d WHERE d.permanentStreet = :permanentStreet")})
public class DonnerToAgentRequestToReview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
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
    @Column(name = "accept_date")
    private String acceptDate;
    @Column(name = "reject_date")
    private String rejectDate;
    @Column(name = "remove_date")
    private String removeDate;
    @Column(name = "status")
    private String status;
    @Lob
    @Column(name = "note_donner")
    private String noteDonner;
    @Lob
    @Column(name = "note_agent")
    private String noteAgent;
    @Lob
    @Column(name = "note_agent_personal")
    private String noteAgentPersonal;

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
    @Column(name = "username")
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


    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id")
    private List<PhoneNumber> phone_number;

    public DonnerToAgentRequestToReview() {
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

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getRejectDate() {
        return rejectDate;
    }

    public void setRejectDate(String rejectDate) {
        this.rejectDate = rejectDate;
    }

    public String getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(String removeDate) {
        this.removeDate = removeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNoteDonner() {
        return noteDonner;
    }

    public void setNoteDonner(String noteDonner) {
        this.noteDonner = noteDonner;
    }

    public String getNoteAgent() {
        return noteAgent;
    }

    public void setNoteAgent(String noteAgent) {
        this.noteAgent = noteAgent;
    }

    public String getNoteAgentPersonal() {
        return noteAgentPersonal;
    }

    public void setNoteAgentPersonal(String noteAgentPersonal) {
        this.noteAgentPersonal = noteAgentPersonal;
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

    public List<PhoneNumber> getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(List<PhoneNumber> phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "DonnerToAgentRequestToReview{" +
                "profileId=" + profileId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", profession='" + profession + '\'' +
                ", userId='" + userId + '\'' +
                ", addressPermanent=" + addressPermanent +
                ", addressPresent=" + addressPresent +
                ", requestId=" + requestId +
                ", requestDate='" + requestDate + '\'' +
                ", acceptDate='" + acceptDate + '\'' +
                ", rejectDate='" + rejectDate + '\'' +
                ", removeDate='" + removeDate + '\'' +
                ", status='" + status + '\'' +
                ", noteDonner='" + noteDonner + '\'' +
                ", noteAgent='" + noteAgent + '\'' +
                ", noteAgentPersonal='" + noteAgentPersonal + '\'' +
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
                ", phone_number=" + phone_number +
                '}';
    }
}
