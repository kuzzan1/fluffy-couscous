package com.application.jpa.repository;

import com.application.jpa.domain.Team;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jonas on 2017-06-14.
 */
public interface TeamsRepository extends CrudRepository<Team, Integer>{
}
