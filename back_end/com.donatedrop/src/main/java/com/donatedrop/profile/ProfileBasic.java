/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.profile;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author G7
 */
@Entity
@Table(name = "profile_basics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfileBasic.findAll", query = "SELECT p FROM ProfileBasic p")
    , @NamedQuery(name = "ProfileBasic.findById", query = "SELECT p FROM ProfileBasic p WHERE p.id = :id")
    , @NamedQuery(name = "ProfileBasic.findByUserId", query = "SELECT p FROM ProfileBasic p WHERE p.userId = :userId")
    , @NamedQuery(name = "ProfileBasic.findByDept", query = "SELECT p FROM ProfileBasic p WHERE p.dept = :dept")
    , @NamedQuery(name = "ProfileBasic.findByBatch", query = "SELECT p FROM ProfileBasic p WHERE p.batch = :batch")
    , @NamedQuery(name = "ProfileBasic.findByStudentId", query = "SELECT p FROM ProfileBasic p WHERE p.studentId = :studentId")
    , @NamedQuery(name = "ProfileBasic.findByPassingYear", query = "SELECT p FROM ProfileBasic p WHERE p.passingYear = :passingYear")
    , @NamedQuery(name = "ProfileBasic.findByFirstName", query = "SELECT p FROM ProfileBasic p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "ProfileBasic.findByLastName", query = "SELECT p FROM ProfileBasic p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "ProfileBasic.findByBirthDate", query = "SELECT p FROM ProfileBasic p WHERE p.birthDate = :birthDate")
    , @NamedQuery(name = "ProfileBasic.findByGender", query = "SELECT p FROM ProfileBasic p WHERE p.gender = :gender")
    , @NamedQuery(name = "ProfileBasic.findByBloodGroup", query = "SELECT p FROM ProfileBasic p WHERE p.bloodGroup = :bloodGroup")
    , @NamedQuery(name = "ProfileBasic.findByEmail", query = "SELECT p FROM ProfileBasic p WHERE p.email = :email")
    , @NamedQuery(name = "ProfileBasic.findByPhone", query = "SELECT p FROM ProfileBasic p WHERE p.phone = :phone")
    , @NamedQuery(name = "ProfileBasic.findByAddressPresent", query = "SELECT p FROM ProfileBasic p WHERE p.addressPresent = :addressPresent")
    , @NamedQuery(name = "ProfileBasic.findByAddressPermanent", query = "SELECT p FROM ProfileBasic p WHERE p.addressPermanent = :addressPermanent")
    , @NamedQuery(name = "ProfileBasic.findBySocialMediaLink", query = "SELECT p FROM ProfileBasic p WHERE p.socialMediaLink = :socialMediaLink")
    , @NamedQuery(name = "ProfileBasic.findByResearchInterest", query = "SELECT p FROM ProfileBasic p WHERE p.researchInterest = :researchInterest")
    , @NamedQuery(name = "ProfileBasic.findBySkills", query = "SELECT p FROM ProfileBasic p WHERE p.skills = :skills")
    , @NamedQuery(name = "ProfileBasic.findByImageAddress", query = "SELECT p FROM ProfileBasic p WHERE p.imageAddress = :imageAddress")
    , @NamedQuery(name = "ProfileBasic.findByCreatedAt", query = "SELECT p FROM ProfileBasic p WHERE p.createdAt = :createdAt")
    , @NamedQuery(name = "ProfileBasic.findByUpdatedAt", query = "SELECT p FROM ProfileBasic p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "ProfileBasic.findByReligion", query = "SELECT p FROM ProfileBasic p WHERE p.religion = :religion")})
public class ProfileBasic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 512)
    @Column(name = "user_id")
    private String userId;
    @Size(max = 512)
    @Column(name = "dept")
    private String dept;
    @Size(max = 512)
    @Column(name = "batch")
    private String batch;
    @Size(max = 512)
    @Column(name = "student_id")
    private String studentId;
    @Size(max = 512)
    @Column(name = "passing_year")
    private String passingYear;
    @Size(max = 512)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 512)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 512)
    @Column(name = "birth_date")
    private String birthDate;
    @Size(max = 512)
    @Column(name = "gender")
    private String gender;
    @Size(max = 512)
    @Column(name = "blood_group")
    private String bloodGroup;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 512)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 512)
    @Column(name = "phone")
    private String phone;
    @Size(max = 512)
    @Column(name = "address_present")
    private String addressPresent;
    @Size(max = 512)
    @Column(name = "address_permanent")
    private String addressPermanent;
    @Size(max = 512)
    @Column(name = "social_media_link")
    private String socialMediaLink;
    @Size(max = 512)
    @Column(name = "research_interest")
    private String researchInterest;
    @Size(max = 512)
    @Column(name = "skills")
    private String skills;
    @Size(max = 512)
    @Column(name = "image_address")
    private String imageAddress;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Size(max = 512)
    @Column(name = "religion")
    private String religion;

    public ProfileBasic() {
    }

    public ProfileBasic(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(String passingYear) {
        this.passingYear = passingYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressPresent() {
        return addressPresent;
    }

    public void setAddressPresent(String addressPresent) {
        this.addressPresent = addressPresent;
    }

    public String getAddressPermanent() {
        return addressPermanent;
    }

    public void setAddressPermanent(String addressPermanent) {
        this.addressPermanent = addressPermanent;
    }

    public String getSocialMediaLink() {
        return socialMediaLink;
    }

    public void setSocialMediaLink(String socialMediaLink) {
        this.socialMediaLink = socialMediaLink;
    }

    public String getResearchInterest() {
        return researchInterest;
    }

    public void setResearchInterest(String researchInterest) {
        this.researchInterest = researchInterest;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
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
        if (!(object instanceof ProfileBasic)) {
            return false;
        }
        ProfileBasic other = (ProfileBasic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donatedrop.profile.ProfileBasic[ id=" + id + " ]";
    }
    
}
