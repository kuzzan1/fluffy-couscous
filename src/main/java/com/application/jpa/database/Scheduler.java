package com.application.jpa.database;

import com.application.jpa.api.MonksService;
import com.application.jpa.domain.League;
import com.application.jpa.domain.api.Fixture;
import com.application.jpa.domain.api.Fixtures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2017-06-24.
 */
@Component
public class Scheduler {

    @Autowired
    private SimpMessagingTemplate template;
    @Autowired
    private MonksService service;

    @Scheduled(fixedRate = 10000 )
    public void getTodaysFixtures() {
        String date = "2017-06-24";
        List<Fixture> fixtures = service.get( "fixtures/between/" + date + "/" + date + "?include=localTeam,visitorTeam,league", Fixtures.class ).getData();
        this.template.convertAndSend("/topic/greetings", getLeageus(fixtures));
    }


    private List<League> getLeageus(List<Fixture> fixtures ) {
        List<com.application.jpa.domain.League> leagues = new ArrayList<>();
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
        return leagues;
    }




}
