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
@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Scores {
    private @Id @GeneratedValue Integer id;
    @JsonProperty("localTeam_Score")
    private String localTeamScore;
    @JsonProperty("visitorTeam_score")
    private String visitorTeamScore;
    @JsonProperty("ht_score")
    private String htScore;
    @JsonProperty("ft_score")
    private String ftScore;

    @OneToOne(mappedBy = "scores")
    private Fixture fixture;

    public Scores( com.application.jpa.domain.api.Scores scores ) {
        this.localTeamScore = scores.getLocalTeamScore();
        this.visitorTeamScore =scores.getVisitorTeamScore();
        this.htScore = scores.getHtScore();
        this.ftScore = scores.getFtScore();

    }

    public Scores() {
    }
}
