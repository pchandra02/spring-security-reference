package com.reference.spring.security.repository;

import com.reference.spring.security.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Srj on 9/27/16.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

    @Query("select c from City c where c.state.id=?1")
    public List<City> findByStateId(int stateid);
}
