package com.application.jpa.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by jonas on 2017-06-12.
 */
@Data
@Entity
public class Starting {

    private @Id
    @GeneratedValue Integer id;
    @JsonProperty("date_time")
    private String dateTime;
    @OneToOne(mappedBy = "starting")
    private Time time;
}
