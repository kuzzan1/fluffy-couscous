package com.application.jpa.domain.api.wrapper;

import com.application.jpa.domain.api.Standing;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by jonas on 2017-06-21.
 */
public class Standings {
    @JsonProperty("data")
    private List<Standing> data;

    public List<Standing> getData() {
        return data;
    }

    public void setData(List<Standing> data) {
        this.data = data;
    }

}
