package com.reference.spring.security.repository;

import com.reference.spring.security.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Srj on 9/26/16.
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("select country_code from Country c where lower(country_name)=?1")
    public String getCountryCode(String country_name);
}
