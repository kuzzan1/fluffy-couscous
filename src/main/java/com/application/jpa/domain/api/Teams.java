package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2017-06-21.
 */
public class Teams {

    @JsonProperty("data")
    private Team data;

    public Team getData() {
        return data;
    }

    public void setData( Team    data ) {
        this.data = data;
    }
}
