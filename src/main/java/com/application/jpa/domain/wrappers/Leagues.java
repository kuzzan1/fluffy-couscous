package com.application.jpa.domain.wrappers;

import com.application.jpa.domain.League;
import com.application.jpa.domain.Meta;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jonas on 2017-06-12.
 */
@Data
public class Leagues {

    @JsonProperty("data")
    private List<League> data = new ArrayList();

    @JsonProperty("meta")
    private Meta meta;
}
