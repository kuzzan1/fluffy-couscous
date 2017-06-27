package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by jonas on 2017-06-21.
 */
public class Teams implements Serializable {

    @JsonProperty("data")
    private Team data;

    public Team getData() {
        return data;
    }

    public void setData( Team    data ) {
        this.data = data;
    }
}
