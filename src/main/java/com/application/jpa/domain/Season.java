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
public class Season {

    @JsonProperty
    private @Id Integer id;
    @JsonProperty
    private String type;


/*
    @JsonProperty("fixtures")
    public void setFixtures( Map<String, Object> fixtures ) {
        ObjectMapper mapper = new ObjectMapper();
        this.fixtures = mapper.convertValue(fixtures.get( "data" ), new TypeReference<List<Fixture>>() { });
    }*/
}
