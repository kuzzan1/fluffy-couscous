package com.application.jpa.domain.projections;

import com.application.jpa.domain.Fixture;
import com.application.jpa.domain.Formations;
import com.application.jpa.domain.Scores;
import com.application.jpa.domain.Team;
import org.springframework.data.rest.core.config.Projection;

/**
 * Created by jonas on 2017-06-14.
 */
@Projection( name = "with_meta", types = Fixture.class )
public interface FixtureProjection {

    Scores getScores();
    Formations getFormations();
    Team getLocalTeam();
    Team getVisitorTeam();
}
