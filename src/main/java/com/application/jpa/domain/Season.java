package com.application.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

/**
 * Created by jonas on 2017-06-12.
 */
@Data
@Entity
public class Season {

    @JsonProperty
    private @Id Integer id;
    @JsonProperty
    private String type;

    @JsonProperty
    @OneToMany(fetch = FetchType.LAZY)
    private List<Fixture> fixtures;

    @JsonProperty
    @OneToOne(mappedBy = "season")
    private League league;


    @JsonProperty("fixtures")
    public void setFixtures( Map<String, Object> fixtures ) {
        ObjectMapper mapper = new ObjectMapper();
        this.fixtures = mapper.convertValue(fixtures.get( "data" ), new TypeReference<List<Fixture>>() { });
    }
}
