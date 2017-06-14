package com.application.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

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
    @OneToOne
    private Team localTeam;

    @JsonProperty
    @OneToOne
    private Team visitorTeam;

}
