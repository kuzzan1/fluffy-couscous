package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2017-06-12.
 */
public class Starting {

    @JsonProperty
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
