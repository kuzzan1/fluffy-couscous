package com.application.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by jonas on 2017-06-12.
 */
public class Scores implements Serializable {
    @JsonProperty("localTeam_Score")
    private String localTeamScore;
    @JsonProperty("visitorTeam_score")
    private String visitorTeamScore;
    @JsonProperty("ht_score")
    private String htScore;
    @JsonProperty("ft_score")
    private String ftScore;

    public Scores( com.application.jpa.domain.api.Scores scores ) {
        this.localTeamScore = scores.getLocalTeamScore();
        this.visitorTeamScore =scores.getVisitorTeamScore();
        this.htScore = scores.getHtScore();
        this.ftScore = scores.getFtScore();

    }

    public Scores() {
    }
}
