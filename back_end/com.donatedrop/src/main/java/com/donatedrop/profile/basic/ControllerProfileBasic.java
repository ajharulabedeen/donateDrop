/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.profile.basic;

import com.donatedrop.profile.model.ProfileBasic;
import com.donatedrop.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.rmi.CORBA.Util;
import java.util.Date;
import java.util.Map;

/**
 * @author G-7,
 */
@RestController
@RequestMapping("/public/profile/basic/")
public class ControllerProfileBasic {

    @Autowired
    Service_Profile_Basic_I service_profile_basic_i;

    @PostMapping("save")
    public Map<String, String> save(@RequestBody ProfileBasic profileBasic) {
        return service_profile_basic_i.save(profileBasic);
    }

    @GetMapping("findOneByUser")
    public ProfileBasic findOneByUser() {
        ProfileBasic profileBasic = service_profile_basic_i.findOneByUser(Utils.getLoggedUserID());
        System.out.println("\n\n----");
        System.out.println(profileBasic);
        System.out.println("\n\n----");
        return profileBasic;
    }
}
