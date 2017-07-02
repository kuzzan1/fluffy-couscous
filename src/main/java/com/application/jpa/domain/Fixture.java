package com.application.jpa.domain;

import com.application.jpa.domain.api.Events;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    @JsonProperty
    private List<Events> events = new ArrayList();

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
        this.events = fixture.getEvents() != null ? fixture.getEvents().getData() : null;
        //this.currentMinute =fixture.getTime().getMinute();
        this.currentMinute = String.valueOf(Math.floor(Math.random() * 100));
    }
}
