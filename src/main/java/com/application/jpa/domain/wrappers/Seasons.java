package com.application.jpa.domain.wrappers;

import com.application.jpa.domain.Season;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by jonas on 2017-06-12.
 */
@Data
public class Seasons {

    private @Id @GeneratedValue Integer id;

    @JsonProperty("data")
    private Season data;
}
