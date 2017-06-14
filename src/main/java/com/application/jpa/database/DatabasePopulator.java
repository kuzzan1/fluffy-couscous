package com.application.jpa.database;

import com.application.jpa.api.MonksService;
import com.application.jpa.database.DatabaseLoader;
import com.application.jpa.domain.Fixture;
import com.application.jpa.domain.wrappers.Fixtures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        LocalDate sevenDatsDate = localDate.plusDays( 7 );
        String sevendays = sevenDatsDate.format( formatter );

        List<Fixture> fixtures = service.get( "fixtures/between/"+today+"/"+sevendays+"?include=localTeam,visitorTeam,league", Fixtures.class).getData();

        for( Fixture fixture : fixtures ) {
            database.save( fixture );
        }

        return fixtures;
    }

}