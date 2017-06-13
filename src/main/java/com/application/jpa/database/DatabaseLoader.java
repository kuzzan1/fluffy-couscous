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
    private SeasonRepository seasonRepository;
    @Autowired
    private FixtureReposistory fixtureReposistory;
    @Autowired
    private FormationsRepository formationsRepository;
    @Autowired
    private ScoresRepository scoresRepository;

    public void save( League league) {
        leagueRepository.save( league );
    }

    public void save( Season season) {

        for( Fixture fixture : season.getFixtures() ) {
            formationsRepository.save(fixture.getFormations());
            scoresRepository.save(fixture.getScores());
            //formationRepository.save(fixture.getFormations());
            fixtureReposistory.save(fixture);
        }
        seasonRepository.save( season );
    }
}
