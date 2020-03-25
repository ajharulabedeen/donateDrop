/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.profile;

import com.donatedrop.model.User;
import com.donatedrop.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Dell-3460
 */
@RestController
public class Profile_Basic_Controller {

    @PostMapping("create")
    public User register(@RequestBody User u) {
//        System.out.println("User : " + u.toString());
////        System.out.println("Done -- User : " + u.toString());
//        u.setPassword(passwordEncoder.encode(u.getPassword()));
//        u.setLastPasswordResetDate(new Date());
        return null;
    }
}
