package com.application.jpa.controller;

import com.application.jpa.api.MonksService;
import com.application.jpa.database.DatabaseLoader;
import com.application.jpa.domain.League;
import com.application.jpa.domain.wrappers.Leagues;
import com.application.jpa.domain.Season;
import com.application.jpa.domain.wrappers.Seasons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jonas on 2017-06-12.
 */
@RestController
@RequestMapping("data/")
public class LeagueController {

    @Autowired
    private MonksService service;
    @Autowired
    private DatabaseLoader database;

    @RequestMapping("/populate/db")
    public List<League> getLeague() {
        List<League> leagues = service.get( "leagues", Leagues.class ).getData();
        for( League league : leagues ) {
            Season season = service.get( "seasons/" + league.getCurrentSeasonId() + "?include=fixtures", Seasons.class ).getData();
            database.save( season );
            league.setSeason(season);
            database.save( league );
            break;
        }
        return leagues;
    }

}