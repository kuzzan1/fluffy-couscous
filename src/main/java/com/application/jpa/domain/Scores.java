package com.application.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by jonas on 2017-06-12.
 */
public class Scores {
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
