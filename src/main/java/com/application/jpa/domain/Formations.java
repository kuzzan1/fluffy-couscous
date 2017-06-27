package com.application.jpa.domain;

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

    public Formations( com.application.jpa.domain.api.Formations formations ) {
        this.localTeamFormation = formations.getLocalTeamFormation();
        this.visitorTeamFormation = formations.getVisitorTeamFormation();
    }

    public Formations() {
    }
}
