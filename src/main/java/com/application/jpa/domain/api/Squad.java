package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2017-06-22.
 */
public class Squad implements Serializable {

    @JsonProperty("data")
    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers( List<Player> players ) {
        this.players = players;
    }
}
