/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author G7
 */
@Entity
@Table(name = "emergencycontact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emergencycontact.findAll", query = "SELECT e FROM Emergencycontact e")
    , @NamedQuery(name = "Emergencycontact.findById", query = "SELECT e FROM Emergencycontact e WHERE e.id = :id")
    , @NamedQuery(name = "Emergencycontact.findByAddress", query = "SELECT e FROM Emergencycontact e WHERE e.address = :address")
    , @NamedQuery(name = "Emergencycontact.findByMail", query = "SELECT e FROM Emergencycontact e WHERE e.mail = :mail")
    , @NamedQuery(name = "Emergencycontact.findByName", query = "SELECT e FROM Emergencycontact e WHERE e.name = :name")
    , @NamedQuery(name = "Emergencycontact.findByPhone", query = "SELECT e FROM Emergencycontact e WHERE e.phone = :phone")
    , @NamedQuery(name = "Emergencycontact.findByRelation", query = "SELECT e FROM Emergencycontact e WHERE e.relation = :relation")})
public class Emergencycontact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 1024)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "mail")
    private String mail;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "phone")
    private String phone;
    @Size(max = 255)
    @Column(name = "relation")
    private String relation;
    @JoinColumn(name = "emergency_contact", referencedColumnName = "id")
    @ManyToOne
    private Profilebasic emergencyContact;

    public Emergencycontact() {
    }

    public Emergencycontact(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Profilebasic getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(Profilebasic emergencyContact) {
        this.emergencyContact = emergencyContact;
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
        if (!(object instanceof Emergencycontact)) {
            return false;
        }
        Emergencycontact other = (Emergencycontact) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donatedrop.Emergencycontact[ id=" + id + " ]";
    }
    
}
