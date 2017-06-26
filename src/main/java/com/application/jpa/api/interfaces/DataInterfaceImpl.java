package com.application.jpa.api.interfaces;

import com.application.jpa.api.MonksService;
import com.application.jpa.domain.League;
import com.application.jpa.domain.api.*;
import com.application.jpa.domain.api.wrapper.Players;
import com.application.jpa.domain.api.wrapper.Standings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2017-06-26.
 */
@Component
public class DataInterfaceImpl implements DataInterface {

    @Autowired
    private MonksService service;


    @Override
    public List<Standing> getStandings( Integer seasonId ) {
        return service.get("standings/season/" + seasonId+"?includes=team", Standings.class).getData();
    }

    @Override
    public Player getPlayer( Integer playerId ) {
        return service.get("players/" + playerId, Players.class).getData();
    }

    @Override
    public List<Fixture> getTopMatches() {
        List<Fixture> returnList = new ArrayList<>();
        String date = LocalDate.now().format( DateTimeFormatter.ofPattern( "yyyy-MM-dd"));
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

    @Override
    public Team getTeam(Integer teamId) {
        return service.get("teams/"+teamId+"?include=squad,venue,coach", Teams.class).getData();
    }

    @Override
    public List<League> getMatchesForDay( String date ) {
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
