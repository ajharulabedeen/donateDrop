/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.profile.basic;

import com.donatedrop.profile.model.ProfileBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author G-7,
 */
@RestController
@RequestMapping("/public/profile/basic/")
public class Profile_Basic_Controller {

    @Autowired
    Service_Profile_Basic_I service_profile_basic_i;

    @PostMapping("save")
    public Map<String, String> save(@RequestBody ProfileBasic profileBasic) {
        return service_profile_basic_i.save(profileBasic);
    }
}
