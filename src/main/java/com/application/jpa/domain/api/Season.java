package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2017-06-12.
 */
public class Season {

    @JsonProperty
    private Integer id;

    @JsonProperty("league_id")
    private Integer leagueId;

    @JsonProperty("is_current_season")
    private Boolean currentSeason;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public Boolean getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(Boolean currentSeason) {
        this.currentSeason = currentSeason;
    }
}
