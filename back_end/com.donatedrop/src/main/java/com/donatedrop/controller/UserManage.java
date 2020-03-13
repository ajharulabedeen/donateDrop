/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.controller;

import com.donatedrop.model.User;
import com.donatedrop.repo.UserRepository;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dell-3460
 */
@RestController
public class UserManage
    {
        @Autowired
        PasswordEncoder passwordEncoder;
    
        @Autowired
        UserRepository userRepository;
        
        @PostMapping("register")
        public User register(@RequestBody User u)
            {
                u.setPassword(passwordEncoder.encode(u.getPassword()));
                u.setLastPasswordResetDate(new Date());
                return userRepository.save(u);
            }
    }
