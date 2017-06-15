package com.application.jpa.database;

import com.application.jpa.domain.*;
import com.application.jpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jonas on 2017-06-12.
 */
@Component
public class DatabaseLoader {

    @Autowired
    private LeagueRepository leagueRepository;
    @Autowired
    private FixtureReposistory fixtureReposistory;
    @Autowired
    private FormationsRepository formationsRepository;
    @Autowired
    private ScoresRepository scoresRepository;
    @Autowired
    private TeamsRepository teamsRepository;

    public void save( Fixture fixture ) {
        formationsRepository.save(fixture.getFormations());
        scoresRepository.save(fixture.getScores());
        teamsRepository.save(fixture.getLocalTeam());
        teamsRepository.save(fixture.getVisitorTeam());
        fixtureReposistory.save( fixture );
    }

    public void save( League league ) {
        league.getFixtures().forEach( this::save ) ;
        leagueRepository.save( league );
    }
}
