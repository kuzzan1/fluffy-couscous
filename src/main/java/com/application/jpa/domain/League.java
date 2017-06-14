package com.application.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jonas on 2017-06-12.
 */
@Data
@Entity
public class League {

    @JsonProperty
    private @Id Integer id;
    @JsonProperty("current_season_id")
    private Integer currentSeasonId;
    @JsonProperty
    private String name;

}
