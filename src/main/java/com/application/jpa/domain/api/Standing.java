package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2017-06-21.
 */
public class Standing {
    @JsonProperty
    private Integer position;
    @JsonProperty("team_id")
    private String teamId;
    @JsonProperty
    private Integer points;
    @JsonProperty("team_name")
    private String teamName;
    @JsonProperty
    private String status;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId( String teamId ) {
        this.teamId = teamId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints( Integer points ) {
        this.points = points;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName( String teamName ) {
        this.teamName = teamName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }
}
