package com.application.jpa.repository;

import com.application.jpa.domain.Season;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jonas on 2017-06-12.
 */
public interface SeasonRepository extends CrudRepository<Season, Integer> {
}
