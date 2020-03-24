/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.security.newcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dell-3460
 */
@RestController
public class UserRegistration {

    @GetMapping(value = "user_register_")
    public String user_register() {
        return "@GetMapping(value = \"tes..>>>>>>>.\")";
    }
}
