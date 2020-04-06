/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author G7
 */
@Entity
@Table(name = "profilebasic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profilebasic.findAll", query = "SELECT p FROM Profilebasic p")
    , @NamedQuery(name = "Profilebasic.findById", query = "SELECT p FROM Profilebasic p WHERE p.id = :id")
    , @NamedQuery(name = "Profilebasic.findByAvailable", query = "SELECT p FROM Profilebasic p WHERE p.available = :available")
    , @NamedQuery(name = "Profilebasic.findByBirthDate", query = "SELECT p FROM Profilebasic p WHERE p.birthDate = :birthDate")
    , @NamedQuery(name = "Profilebasic.findByBloodGroup", query = "SELECT p FROM Profilebasic p WHERE p.bloodGroup = :bloodGroup")
    , @NamedQuery(name = "Profilebasic.findByCareOf", query = "SELECT p FROM Profilebasic p WHERE p.careOf = :careOf")
    , @NamedQuery(name = "Profilebasic.findByGender", query = "SELECT p FROM Profilebasic p WHERE p.gender = :gender")
    , @NamedQuery(name = "Profilebasic.findByMaritalStatus", query = "SELECT p FROM Profilebasic p WHERE p.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "Profilebasic.findByName", query = "SELECT p FROM Profilebasic p WHERE p.name = :name")
    , @NamedQuery(name = "Profilebasic.findByProfession", query = "SELECT p FROM Profilebasic p WHERE p.profession = :profession")
    , @NamedQuery(name = "Profilebasic.findByUserId", query = "SELECT p FROM Profilebasic p WHERE p.userId = :userId")})
public class Profilebasic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "available")
    private String available;
    @Size(max = 512)
    @Column(name = "birth_date")
    private String birthDate;
    @Size(max = 255)
    @Column(name = "blood_Group")
    private String bloodGroup;
    @Size(max = 1024)
    @Column(name = "care_of")
    private String careOf;
    @Size(max = 512)
    @Column(name = "gender")
    private String gender;
    @Size(max = 256)
    @Column(name = "marital_status")
    private String maritalStatus;
    @Size(max = 512)
    @Column(name = "name")
    private String name;
    @Size(max = 256)
    @Column(name = "profession")
    private String profession;
    @Size(max = 256)
    @Column(name = "user_id")
    private String userId;
    @JoinColumn(name = "address_permanent", referencedColumnName = "id")
    @ManyToOne
    private Address addressPermanent;
    @JoinColumn(name = "address_current", referencedColumnName = "id")
    @ManyToOne
    private Address addressCurrent;
    @OneToMany(mappedBy = "emergencyContact")
    private Collection<Emergencycontact> emergencycontactCollection;

    public Profilebasic() {
    }

    public Profilebasic(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCareOf() {
        return careOf;
    }

    public void setCareOf(String careOf) {
        this.careOf = careOf;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Address getAddressPermanent() {
        return addressPermanent;
    }

    public void setAddressPermanent(Address addressPermanent) {
        this.addressPermanent = addressPermanent;
    }

    public Address getAddressCurrent() {
        return addressCurrent;
    }

    public void setAddressCurrent(Address addressCurrent) {
        this.addressCurrent = addressCurrent;
    }

    @XmlTransient
    public Collection<Emergencycontact> getEmergencycontactCollection() {
        return emergencycontactCollection;
    }

    public void setEmergencycontactCollection(Collection<Emergencycontact> emergencycontactCollection) {
        this.emergencycontactCollection = emergencycontactCollection;
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
        if (!(object instanceof Profilebasic)) {
            return false;
        }
        Profilebasic other = (Profilebasic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donatedrop.Profilebasic[ id=" + id + " ]";
    }
    
}
