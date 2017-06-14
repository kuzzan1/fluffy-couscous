package com.application.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
    @OneToOne(mappedBy = "localTeam")
    private Fixture localFixture;

    @JsonProperty
    @OneToOne(mappedBy = "visitorTeam")
    private Fixture awayFixture;

    @JsonProperty("data")
    public void setFixtures( Map<String, Object> data ) {
        this.id = (Integer)data.get("id");
        this.name = (String)data.get("name");
        this.logo = (String)data.get("logo_path");
    }
}
