package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by jonas on 2017-06-22.
 */
public class Player implements Serializable {

    @JsonProperty
    private Integer player_id;
    @JsonProperty
    private Integer position_id;
    @JsonProperty
    private Integer number;
    @JsonProperty
    private boolean injured;
    @JsonProperty
    private Integer minutes;
    @JsonProperty
    private Integer appearences;
    @JsonProperty
    private Integer goals;
    @JsonProperty
    private Integer assists;
    @JsonProperty
    private Integer yellowcards;
    @JsonProperty
    private Integer yellowred;
    @JsonProperty
    private Integer redcards;
    @JsonProperty
    private String fullname;
    @JsonProperty
    private String nationality;
    @JsonProperty
    private String height;
    @JsonProperty
    private String weight;
    @JsonProperty
    private String image_path;


    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id( Integer player_id ) {
        this.player_id = player_id;
    }

    public Integer getPosition_id() {
        return position_id;
    }

    public void setPosition_id( Integer position_id ) {
        this.position_id = position_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber( Integer number ) {
        this.number = number;
    }

    public boolean isInjured() {
        return injured;
    }

    public void setInjured( boolean injured ) {
        this.injured = injured;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes( Integer minutes ) {
        this.minutes = minutes;
    }

    public Integer getAppearences() {
        return appearences;
    }

    public void setAppearences( Integer appearences ) {
        this.appearences = appearences;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals( Integer goals ) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists( Integer assists ) {
        this.assists = assists;
    }

    public Integer getYellowcards() {
        return yellowcards;
    }

    public void setYellowcards( Integer yellowcards ) {
        this.yellowcards = yellowcards;
    }

    public Integer getYellowred() {
        return yellowred;
    }

    public void setYellowred( Integer yellowred ) {
        this.yellowred = yellowred;
    }

    public Integer getRedcards() {
        return redcards;
    }

    public void setRedcards( Integer redcards ) {
        this.redcards = redcards;
    }
}
