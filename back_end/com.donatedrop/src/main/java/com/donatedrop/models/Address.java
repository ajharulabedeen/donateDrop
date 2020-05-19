/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.models;

import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author G7
 */
@Entity
//@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String division;
    
    @Column
    private String district;
    
    /**
     * Municipality also can be added.
     */
    @Column
    private String upzilla;
    
    /**
     * Union also can be added.
     */
    @Column
    private String union_ward;
    
    @Column
    private String street_address;

    //lombok dont show param hints in intelJ
    public Address(String division, String district, String upzilla, String union_ward, String street_address) {
        this.division = division;
        this.district = district;
        this.upzilla = upzilla;
        this.union_ward = union_ward;
        this.street_address = street_address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", division='" + division + '\'' +
                ", district='" + district + '\'' +
                ", upzilla='" + upzilla + '\'' +
                ", union_ward='" + union_ward + '\'' +
                ", street_address='" + street_address + '\'' +
                '}';
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

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUpzilla() {
        return upzilla;
    }

    public void setUpzilla(String upzilla) {
        this.upzilla = upzilla;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getUnion_ward() {
        return union_ward;
    }

    public void setUnion_ward(String union_ward) {
        this.union_ward = union_ward;
    }
    
}
