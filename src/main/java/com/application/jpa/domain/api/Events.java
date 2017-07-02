package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by jonas on 2017-07-02.
 */
public class Events {

    @JsonProperty
    private Integer id;
    @JsonProperty("team_id")
    private Integer teamId;
    @JsonProperty
    private String type;
    @JsonProperty("player_name")
    private String playerName;
    @JsonProperty
    private Integer minute;
    @JsonProperty("related_player_name")
    private String relatedPlayerName;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String getRelatedPlayerName() {
        return relatedPlayerName;
    }

    public void setRelatedPlayerName(String relatedPlayerName) {
        this.relatedPlayerName = relatedPlayerName;
    }
}
