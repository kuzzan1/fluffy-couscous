package com.application.jpa.api.interfaces;

import com.application.jpa.domain.League;
import com.application.jpa.domain.api.Fixture;
import com.application.jpa.domain.api.Player;
import com.application.jpa.domain.api.Standing;
import com.application.jpa.domain.api.Team;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jonas on 2017-06-26.
 */
@Service
public interface DataInterface {
    @Cacheable("standings")
    List<Standing> getStandings(Integer seasonId);
    @Cacheable("player")
    Player getPlayer(Integer playerId);
    @Cacheable("topmatches")
    List<Fixture> getTopMatches();
    @Cacheable("team")
    Team getTeam(Integer teamId);
    @Cacheable("matchesForDay")
    List<League> getMatchesForDay( String date);

}
