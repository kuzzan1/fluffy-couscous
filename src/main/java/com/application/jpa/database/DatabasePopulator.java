package com.application.jpa.database;

import com.application.jpa.api.MonksService;
import com.application.jpa.domain.api.Fixture;
import com.application.jpa.domain.api.Fixtures;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private DatabaseLoader database;

    @RequestMapping("/populate/db")
    public List<Fixture> getLeague() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
        String today = localDate.format( formatter );
        LocalDate sevenDatsDate = localDate.plusDays( 20 );
        String sevendays = sevenDatsDate.format( formatter );

        List<Fixture> fixtures = service.get( "fixtures/between/"+today+"/"+sevendays+"?include=localTeam,visitorTeam,league", Fixtures.class).getData();

        List<com.application.jpa.domain.League> leagues = new ArrayList<>();

        fixtures.forEach( fixture -> {
            com.application.jpa.domain.League exportLeague = new com.application.jpa.domain.League( fixture.getLeague() );
            com.application.jpa.domain.Fixture exportFixture = new com.application.jpa.domain.Fixture( fixture );

            if(leagues.contains( exportLeague )) {
                leagues.get( leagues.indexOf( exportLeague )).getFixtures().add(exportFixture);
            } else {
                exportLeague.getFixtures().add(exportFixture);
                leagues.add( exportLeague );
            }
        } );


        leagues.forEach( league -> database.save( league ) );



        return fixtures;
    }

}