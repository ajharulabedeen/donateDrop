/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.geocode;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author G7
 */
@RestController
@RequestMapping("/test/geocode")
public class Controller_GeoCode {

    @Autowired
    private Service_GeoCode_I service_GeoCode_I;

    @GetMapping(value = "divisions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DivisionsEngName> getDivisions(Model model) {
        model.addAttribute("employees", service_GeoCode_I.getDivisions());
        return service_GeoCode_I.getDivisions();
    }
}
