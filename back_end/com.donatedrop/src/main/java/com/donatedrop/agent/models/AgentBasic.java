package com.donatedrop.agent.models;

import com.donatedrop.profile.model.PhoneNumber;

import javax.persistence.*;
import java.util.List;

public class AgentBasic {
    //    private String profileId;
    private String name;
    private String emmail;
    private List<PhoneNumber> phoneNumbers;

    public AgentBasic(String name, String emmail, List<PhoneNumber> phoneNumbers) {
        this.name = name;
        this.emmail = emmail;
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "AgentBasic{" +
                "name='" + name + '\'' +
                ", emmail='" + emmail + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
