package com.application.jpa.domain.api.wrapper;

import com.application.jpa.domain.api.Season;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by jonas on 2017-06-12.
 */
public class Seasons {

    @JsonProperty("data")
    private List<Season> data;

    public List<Season> getData() {
        return data;
    }

    public void setData(List<Season> data) {
        this.data = data;
    }
}
