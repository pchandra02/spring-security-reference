package com.reference.spring.security.repository;

import com.reference.spring.security.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Srj on 9/27/16.
 */
@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

    @Query("select s from State s where s.country.id=?1")
    public List<State> findByCountryId(int countryid);
}
