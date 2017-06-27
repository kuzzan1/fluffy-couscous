package com.application.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by jonas on 2017-06-14.
 */
public class Team implements Serializable {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String logo;

    @JsonProperty
    private List<Fixture> localFixture;

    @JsonProperty
    private List<Fixture> awayFixture;


    public Team( com.application.jpa.domain.api.Team team ) {
        this.id = team.getId();
        this.name = team.getName();
        this.logo = team.getLogo();
    }

    public Team() {
    }

    @JsonProperty("data")
    public void setFixtures( Map<String, Object> data ) {
        this.id = (Integer)data.get("id");
        this.name = (String)data.get("name");
        this.logo = (String)data.get("logo_path");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<Fixture> getLocalFixture() {
        return localFixture;
    }

    public void setLocalFixture(List<Fixture> localFixture) {
        this.localFixture = localFixture;
    }

    public List<Fixture> getAwayFixture() {
        return awayFixture;
    }

    public void setAwayFixture(List<Fixture> awayFixture) {
        this.awayFixture = awayFixture;
    }
}
