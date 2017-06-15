package com.application.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jonas on 2017-06-12.
 */
@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fixture {

    @JsonProperty
    private @Id Integer id;
    @JsonProperty
    @OneToOne
    private Formations formations;
    @JsonProperty
    @OneToOne
    private Scores scores;
    @JsonProperty
    @ManyToOne
    private Team localTeam;
    @JsonProperty
    @ManyToOne
    private Team visitorTeam;
    @JsonProperty
    @ManyToOne
    private League league;
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
        this.time = time.substring(0, time.length() -3);;
    }
}
