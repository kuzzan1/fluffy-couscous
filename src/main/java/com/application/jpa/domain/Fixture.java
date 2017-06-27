package com.application.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by jonas on 2017-06-12.
 */
public class Fixture implements Serializable {
    @JsonProperty
    private String currentMinute;
    @JsonProperty
    private  Integer id;
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
    @JsonProperty
    private String time;


    public Fixture() {
    }

    public Fixture( com.application.jpa.domain.api.Fixture fixture ) {
        this.id = fixture.getId();
        this.formations = new Formations(fixture.getFormations());
        this.scores = new Scores(fixture.getScores());
        this.localTeam = new Team(fixture.getLocalTeam());
        this.visitorTeam = new Team( fixture.getVisitorTeam());
        String time = fixture.getTime().getStarting().getTime();
        this.time = time;
        //this.currentMinute =fixture.getTime().getMinute();
        this.currentMinute = String.valueOf(Math.floor(Math.random() * 100));
    }
}
