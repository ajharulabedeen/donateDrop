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
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id")
    , @NamedQuery(name = "Address.findByDistrict", query = "SELECT a FROM Address a WHERE a.district = :district")
    , @NamedQuery(name = "Address.findByDivision", query = "SELECT a FROM Address a WHERE a.division = :division")
    , @NamedQuery(name = "Address.findByStreetAddress", query = "SELECT a FROM Address a WHERE a.streetAddress = :streetAddress")
    , @NamedQuery(name = "Address.findByUnionWard", query = "SELECT a FROM Address a WHERE a.unionWard = :unionWard")
    , @NamedQuery(name = "Address.findByUpzilla", query = "SELECT a FROM Address a WHERE a.upzilla = :upzilla")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @Size(max = 255)
    @Column(name = "district")
    private String district;
    @Size(max = 255)
    @Column(name = "division")
    private String division;
    @Size(max = 255)
    @Column(name = "street_address")
    private String streetAddress;
    @Size(max = 255)
    @Column(name = "union_ward")
    private String unionWard;
    @Size(max = 255)
    @Column(name = "upzilla")
    private String upzilla;
    @OneToMany(mappedBy = "addressPermanent")
    private Collection<Profilebasic> profilebasicCollection;
    @OneToMany(mappedBy = "addressCurrent")
    private Collection<Profilebasic> profilebasicCollection1;

    public Address() {
    }

    public Address(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getUnionWard() {
        return unionWard;
    }

    public void setUnionWard(String unionWard) {
        this.unionWard = unionWard;
    }

    public String getUpzilla() {
        return upzilla;
    }

    public void setUpzilla(String upzilla) {
        this.upzilla = upzilla;
    }

    @XmlTransient
    public Collection<Profilebasic> getProfilebasicCollection() {
        return profilebasicCollection;
    }

    public void setProfilebasicCollection(Collection<Profilebasic> profilebasicCollection) {
        this.profilebasicCollection = profilebasicCollection;
    }

    @XmlTransient
    public Collection<Profilebasic> getProfilebasicCollection1() {
        return profilebasicCollection1;
    }

    public void setProfilebasicCollection1(Collection<Profilebasic> profilebasicCollection1) {
        this.profilebasicCollection1 = profilebasicCollection1;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donatedrop.Address[ id=" + id + " ]";
    }
    
}
