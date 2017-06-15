package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2017-06-12.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fixture {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private Formations formations;
    @JsonProperty
    private Scores scores;
    @JsonProperty
    private Team localTeam;
    @JsonProperty
    private Team visitorTeam;
    @JsonProperty
    private League league;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Formations getFormations() {
        return formations;
    }

    public void setFormations( Formations formations ) {
        this.formations = formations;
    }

    public Scores getScores() {
        return scores;
    }

    public void setScores( Scores scores ) {
        this.scores = scores;
    }

    public Team getLocalTeam() {
        return localTeam;
    }

    public void setLocalTeam( Team localTeam ) {
        this.localTeam = localTeam;
    }

    public Team getVisitorTeam() {
        return visitorTeam;
    }

    public void setVisitorTeam( Team visitorTeam ) {
        this.visitorTeam = visitorTeam;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague( League league ) {
        this.league = league;
    }
}