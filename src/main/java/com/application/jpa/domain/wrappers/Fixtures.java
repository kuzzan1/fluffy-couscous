package com.application.jpa.domain.wrappers;

import com.application.jpa.domain.Fixture;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2017-06-12.
 */
@Data
public class Fixtures {

    @JsonProperty("data")
    private List<Fixture> data = new ArrayList();
}
