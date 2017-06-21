package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by jonas on 2017-06-12.
 */
public class League {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private Integer currentSeasonId;
    @JsonProperty
    private String name;

    @JsonProperty("data")
    public void setFixtures( Map<String, Object> data ) {
        this.id = (Integer)data.get("id");
        this.name = (String)data.get("name");
        this.currentSeasonId = (Integer) data.get("current_season_id");
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getCurrentSeasonId() {
        return currentSeasonId;
    }

    public void setCurrentSeasonId( Integer currentSeasonId ) {
        this.currentSeasonId = currentSeasonId;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
}
