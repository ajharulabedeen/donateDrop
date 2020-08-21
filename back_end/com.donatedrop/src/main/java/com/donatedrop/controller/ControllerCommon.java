/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.controller;

import com.donatedrop.agent.Dao_Agen_I;
import com.donatedrop.agent.models.AgentBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dell
 */
@RestController
@RequestMapping("/public/")
public class ControllerCommon {

    @Autowired
    Dao_Agen_I dao_agen_i;

    @GetMapping("getAgentBasic")
    public AgentBasic agentBasic(@RequestParam String userID) {
        return dao_agen_i.getAgentBasic(userID);
    }

}
