package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by jonas on 2017-06-14.
 */
public class Team {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String logo;

    @JsonProperty("data")
    public void setFixtures( Map<String, Object> data ) {
        this.id = (Integer)data.get("id");
        this.name = (String)data.get("name");
        this.logo = (String)data.get("logo_path");
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }
}