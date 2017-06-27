package com.application.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2017-06-12.
 */
public class League implements Serializable {

    @JsonProperty
    private Integer id;
    @JsonProperty("current_season_id")
    private Integer currentSeasonId;
    @JsonProperty
    private String name;
    @JsonProperty
    private List<Fixture> fixtures = new ArrayList<>();

    public League(  ) {
    }

    public League( com.application.jpa.domain.api.League league ) {
        this.id = league.getId();
        this.currentSeasonId = league.getCurrentSeasonId();
        this.name = league.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getCurrentSeasonId() {
        return currentSeasonId;
    }

    public void setCurrentSeasonId( Integer currentSeasonId ) {
        this.currentSeasonId = currentSeasonId;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public List<Fixture> getFixtures() {
        return fixtures;
    }

    public void setFixtures( List<Fixture> fixtures ) {
        this.fixtures = fixtures;
    }

    @Override
    public boolean equals( Object o ) {
        if( this == o ) { return true; }
        if( o == null || getClass() != o.getClass() ) { return false; }

        League league = (League) o;

        return id != null ? id.equals( league.id ) : league.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
