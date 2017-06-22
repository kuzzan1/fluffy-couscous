package com.application.jpa.domain.api.wrapper;

import com.application.jpa.domain.api.Player;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2017-06-22.
 */
public class Players {

    @JsonProperty("data")
    private Player data;

    public Player getData() {
        return data;
    }

    public void setData( Player data ) {
        this.data = data;
    }
}
