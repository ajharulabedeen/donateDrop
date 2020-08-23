/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.agent.donner;

import com.donatedrop.agent.donner.models.*;
import com.donatedrop.agent.models.RequestNote;
import com.donatedrop.agent.models.RequestReviewRequest;
import com.donatedrop.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author G7
 */
@RestController
@RequestMapping("/public/user/agent/donnerAssign")
public class Controller_DonnerAssign {

    @Autowired
    Service_DonnerAssign_I service_donnerAssign_i;

    @PostMapping("getAssingments")
    public List<DonnerAssingShow>
    getAssingments(@RequestBody RequestSearchDonnerAssing requestSearchDonnerAssing) {
        requestSearchDonnerAssing.setAgentID(Utils.getLoggedUserID());
        return service_donnerAssign_i.getAssingments(requestSearchDonnerAssing);
    }

    @PostMapping("getAssingmentsCount")
    public Map<String, String>
    getAssingmentsCount(@RequestBody RequestSearchDonnerAssing requestSearchDonnerAssing) {
        requestSearchDonnerAssing.setAgentID(Utils.getLoggedUserID());
        return service_donnerAssign_i.getAssingmentsCount(requestSearchDonnerAssing);
    }

    @DeleteMapping("delete")
    public Map<String, String> delete(@RequestParam String donnerAssingmentID) {
        return service_donnerAssign_i.delete(donnerAssingmentID);
    }
}
