package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by jonas on 2017-06-22.
 */
public class Coach {

    @JsonProperty
    private Integer coach_id;
    @JsonProperty
    private String fullName;

    @JsonProperty("data")
    public void setCoach( Map<String, Object> data ) {
        this.coach_id = (Integer)data.get("coach_id");
        this.fullName = (String)data.get("fullname");
    }
}
