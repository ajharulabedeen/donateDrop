/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.history;

import com.donatedrop.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author G7
 */
@RestController
@RequestMapping("/public/user/history")
public class ControllerHistory {

    @Autowired
    Service_History_I service_history_i;

    @PostMapping("save")
    public Map<String, String> save(@RequestBody History history) {
        return service_history_i.save(history);
    }

    @PostMapping("update")
    public Map<String, String> update(@RequestBody History history) {
        return service_history_i.update(history, Utils.getLoggedUserID());
    }
}
