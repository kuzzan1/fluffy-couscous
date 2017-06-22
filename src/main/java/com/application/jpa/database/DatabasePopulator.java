package com.application.jpa.database;

import com.application.jpa.api.MonksService;
import com.application.jpa.domain.League;
import com.application.jpa.domain.api.*;
import com.application.jpa.domain.api.wrapper.Players;
import com.application.jpa.domain.api.wrapper.Standings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2017-06-12.
 */
@RestController
@RequestMapping("data/")
public class DatabasePopulator {

    @Autowired
    private MonksService service;

    @RequestMapping("standings/{seasonId}")
    private List<Standing> getStandings(@PathVariable Integer seasonId) {
        return service.get("standings/season/" + seasonId+"?includes=team", Standings.class).getData();
    }

    @RequestMapping("player/{playerId}")
    private Player getPlayer( @PathVariable Integer playerId) {
        return service.get("players/" + playerId, Players.class).getData();
    }

    @RequestMapping("fixture/topMatch")
    private List<Fixture> getFixtures() {
        List<Fixture> returnList = new ArrayList<>();
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Fixture> fixtures = service.get( "fixtures/between/" + date + "/" + date + "?include=localTeam,visitorTeam,league", Fixtures.class ).getData();
        //List<Fixture> fixtures = service.get( "fixtures/between/2017-07-01/2017-07-01?include=localTeam,visitorTeam,league", Fixtures.class ).getData();

        fixtures.forEach(fixture -> {
            //TODO add BR logic for topmatches
            if(returnList.size() < 3) {
                returnList.add(fixture);
            }
        });

        return returnList;

    }

    @RequestMapping("team/{id}")
    private Team getTeam(@PathVariable String id) {
        return service.get("teams/"+id+"?include=squad,venue", Teams.class).getData();

    }


    @RequestMapping("fixtures/{date}")
    private List<League> getTodaysMatches( @PathVariable String date) {
        List<Fixture> fixtures = service.get( "fixtures/between/" + date + "/" + date + "?include=localTeam,visitorTeam,league", Fixtures.class ).getData();

        List<com.application.jpa.domain.League> leagues = new ArrayList<>();

        getLeageus( fixtures, leagues );

        return leagues;
    }


    private void getLeageus( List<Fixture> fixtures, List<League> leagues ) {
        fixtures.forEach( fixture -> {
            League exportLeague = new League( fixture.getLeague() );
            com.application.jpa.domain.Fixture exportFixture = new com.application.jpa.domain.Fixture( fixture );

            if(leagues.contains( exportLeague )) {
                leagues.get( leagues.indexOf( exportLeague )).getFixtures().add(exportFixture);
            } else {
                exportLeague.getFixtures().add(exportFixture);
                leagues.add( exportLeague );
            }
        } );
    }

}