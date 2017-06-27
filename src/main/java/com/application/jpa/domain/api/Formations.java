package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by jonas on 2017-06-12.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Formations implements Serializable {

    @JsonProperty("localTeam_Formation")
    private String localTeamFormation;
    @JsonProperty("visitorTeam_Formation")
    private String visitorTeamFormation;

    public String getLocalTeamFormation() {
        return localTeamFormation;
    }

    public void setLocalTeamFormation( String localTeamFormation ) {
        this.localTeamFormation = localTeamFormation;
    }

    public String getVisitorTeamFormation() {
        return visitorTeamFormation;
    }

    public void setVisitorTeamFormation( String visitorTeamFormation ) {
        this.visitorTeamFormation = visitorTeamFormation;
    }
}
