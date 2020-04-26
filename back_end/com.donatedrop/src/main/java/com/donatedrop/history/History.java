/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.history;

import com.donatedrop.profile.model.ProfileBasic;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.sql.Clob;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author G7
 */
@Entity
public class History implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "date")
    private String date;

    @Column(name = "location")
    private String location;

    @Lob
//    not working
//    @Size(min = 1, max = 16777215)
//    @Column(name = "patient_description",
//            columnDefinition = "CLOB",
//            length = 16777215)
//    @Column(name = "patient_description", columnDefinition = "CLOB")
    @Column(name = "patient_description")
    private String patientDescription;

    @Column(name = "reffered_by")
    private String refferedBy;

    @Lob
//    not working
//    @Column(name = "note", columnDefinition = "CLOB", length = 16777215)
//    @Column(name = "note", columnDefinition = "CLOB")
//    @Size(min = 1, max = 16777215)
//    @Column(name = "note")
    @Column(name = "note")
    private String note;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileBasic profileBasic;

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
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof History)) {
            return false;
        }
        History other = (History) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donatedrop.history.History[ id=" + id + " ]";
    }

}
