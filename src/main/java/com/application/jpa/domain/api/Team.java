package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by jonas on 2017-06-14.
 */
public class Team implements Serializable{
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty("logo_path")
    private String logo;
    @JsonProperty
    private Squad squad;
    @JsonProperty
    private Venue venue;
    @JsonProperty
    private Coach coach;


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
