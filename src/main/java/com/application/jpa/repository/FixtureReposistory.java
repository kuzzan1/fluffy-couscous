package com.application.jpa.repository;

import com.application.jpa.domain.Fixture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by jonas on 2017-06-12.
 */

public interface FixtureReposistory extends PagingAndSortingRepository<Fixture, Integer> {
}
