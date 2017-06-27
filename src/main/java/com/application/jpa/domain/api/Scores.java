package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by jonas on 2017-06-12.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Scores implements Serializable {
    @JsonProperty("localteam_score")
    private String localTeamScore;
    @JsonProperty("visitorteam_score")
    private String visitorTeamScore;
    @JsonProperty("ht_score")
    private String htScore;
    @JsonProperty("ft_score")
    private String ftScore;

    public String getLocalTeamScore() {
        return localTeamScore;
    }

    public void setLocalTeamScore( String localTeamScore ) {
        this.localTeamScore = localTeamScore;
    }

    public String getVisitorTeamScore() {
        return visitorTeamScore;
    }

    public void setVisitorTeamScore( String visitorTeamScore ) {
        this.visitorTeamScore = visitorTeamScore;
    }

    public String getHtScore() {
        return htScore;
    }

    public void setHtScore( String htScore ) {
        this.htScore = htScore;
    }

    public String getFtScore() {
        return ftScore;
    }

    public void setFtScore( String ftScore ) {
        this.ftScore = ftScore;
    }
}
