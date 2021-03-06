package com.donatedrop.security.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "USER")
public class User  implements Serializable{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
//    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @Column(name = "USERNAME", length = 50, unique = true)
//    @NotNull
//    @Size(min = 4, max = 50)
    private String userName;

    @Column(name = "PASSWORD", length = 100)
//    @NotNull
//    @Size(min = 4, max = 100)
    private String password;

    @Column(name = "ENABLED")
//    @NotNull
    private Boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {
                @JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {
                @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private List<Authority> authorities;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public String[] getRoles() {
        String[] roles = {};
        int size = getAuthorities().size();
        if (size >= 1) {
            roles = new String[size];
            List<Authority> list = getAuthorities();
            int x = 0;
            for (Iterator<Authority> iterator = list.iterator(); iterator.hasNext();) {
                Authority authority = iterator.next();
//                System.out.println(authority.getName().toString());
                roles[x] = authority.getName();
            }
        }
        return roles;
    }

    //refactor
    public String getRoles(String s) {
        String[] roles = {};
        int size = getAuthorities().size();
        if (size >= 1) {
            roles = new String[size];
            List<Authority> list = getAuthorities();
            int x = 0;
            for (Iterator<Authority> iterator = list.iterator(); iterator.hasNext();) {
                Authority authority = iterator.next();
//                System.out.println(authority.getName().toString());
                roles[x] = authority.getName();
                s += roles[x] + ",";
            }
        } else {
            s = "NO_ROLE";
        }
        return s;
    }
}
