package com.donatedrop.agent.donner;

import com.donatedrop.agent.donner.models.DonnerAssingment;
import com.donatedrop.agent.donner.models.DonnerRequestToAgent;

import java.util.Map;

public interface Dao_DonnerAssign_I {
    public Map<String, String> save(DonnerAssingment donnerAssingment);

    public DonnerAssingment findOne(String donnerAssingment);

    public Map<String, String> delete(String donnerAssingmentID);

    public Map<String, String> update(DonnerAssingment donnerAssingment);

}
