package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2017-06-21.
 */
public class Standing {
    @JsonProperty
    private Integer position;
    @JsonProperty
    private String team_id;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }
}
