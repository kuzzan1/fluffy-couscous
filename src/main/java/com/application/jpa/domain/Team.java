package com.application.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Map;

/**
 * Created by jonas on 2017-06-14.
 */
@Data
@Entity
public class Team {
    @JsonProperty
    private @Id Integer id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String logo;

    @JsonProperty
    @OneToMany(mappedBy = "localTeam")
    private List<Fixture> localFixture;

    @JsonProperty
    @OneToMany(mappedBy = "visitorTeam")
    private List<Fixture> awayFixture;


    public Team( com.application.jpa.domain.api.Team team ) {
        this.id = team.getId();
        this.name = team.getName();
        this.logo = team.getLogo();
    }

    public Team() {
    }

    @JsonProperty("data")
    public void setFixtures( Map<String, Object> data ) {
        this.id = (Integer)data.get("id");
        this.name = (String)data.get("name");
        this.logo = (String)data.get("logo_path");
    }
}
