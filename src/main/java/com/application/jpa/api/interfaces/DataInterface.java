package com.application.jpa.api.interfaces;

import com.application.jpa.domain.League;
import com.application.jpa.domain.api.Fixture;
import com.application.jpa.domain.api.Player;
import com.application.jpa.domain.api.Standing;
import com.application.jpa.domain.api.Team;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jonas on 2017-06-26.
 */
@Service
public interface DataInterface {
    List<Standing> getStandings(Integer seasonId);
    Player getPlayer(Integer playerId);
    List<Fixture> getTopMatches();
    Team getTeam(Integer teamId);
    List<League> getMatchesForDay( String date);

}
