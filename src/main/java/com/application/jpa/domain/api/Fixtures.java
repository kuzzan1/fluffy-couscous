package com.application.jpa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2017-06-12.
 */
public class Fixtures implements Serializable {

    @JsonProperty("data")
    private List<Fixture> data = new ArrayList();

    public List<Fixture> getData() {
        return data;
    }

    public void setData( List<Fixture> data ) {
        this.data = data;
    }
}
