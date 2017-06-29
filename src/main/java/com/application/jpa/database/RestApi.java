package com.application.jpa.database;

import com.application.jpa.api.interfaces.DataInterface;
import com.application.jpa.domain.League;
import com.application.jpa.domain.api.Fixture;
import com.application.jpa.domain.api.Player;
import com.application.jpa.domain.api.Standing;
import com.application.jpa.domain.api.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jonas on 2017-06-12.
 */
@RestController
@RequestMapping("data/")
public class RestApi {

    @Autowired
    private DataInterface dataInterface;


    @RequestMapping("standings/{seasonId}")
    private List<Standing> getStandings(@PathVariable Integer seasonId) {
        return dataInterface.getStandings( seasonId );
    }

    @RequestMapping("player/{playerId}")
    private Player getPlayer( @PathVariable Integer playerId) {
        return dataInterface.getPlayer( playerId );
    }

    @RequestMapping("fixture/topMatch")
    private List<Fixture> getTopMatches() {
        return dataInterface.getTopMatches();
    }

    @RequestMapping("team/{teamId}")
    private Team getTeam(@PathVariable Integer teamId) {
        return dataInterface.getTeam(teamId);
    }


    @RequestMapping("fixtures/{date}")
    private List<League> getMatchesForDay( @PathVariable String date) {
        return dataInterface.getMatchesForDay(date);
    }
}