package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2017-06-12.
 */
public class Time {
    @JsonProperty
    private String status;
    @JsonProperty("starting_at")
    private Starting starting;
    @JsonProperty
    private String minute;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Starting getStarting() {
        return starting;
    }

    public void setStarting(Starting starting) {
        this.starting = starting;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }
}
