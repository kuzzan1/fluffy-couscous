package com.application.jpa.domain.api.wrapper;

import com.application.jpa.domain.api.Events;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2017-07-02.
 */
public class EventsWrapper {
    @JsonProperty
    private List<Events> data = new ArrayList();

    public List<Events> getData() {
        return data;
    }

    public void setData(List<Events> data) {
        this.data = data;
    }
}
