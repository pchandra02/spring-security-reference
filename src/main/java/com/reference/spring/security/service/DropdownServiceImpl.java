package com.reference.spring.security.service;

import com.reference.spring.security.model.City;
import com.reference.spring.security.model.Country;
import com.reference.spring.security.model.Currency;
import com.reference.spring.security.model.State;
import com.reference.spring.security.repository.CityRepository;
import com.reference.spring.security.repository.CountryRepository;
import com.reference.spring.security.repository.CurrencyRepository;
import com.reference.spring.security.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Srj on 9/27/16.
 */

@Service
public class DropdownServiceImpl implements DropdownService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Override
    public List<Country> getCountryList() {
        return (List<Country>) this.countryRepository.findAll();
    }

    @Override
    public List<State> getStateList(int country_id) {
        return (List<State>) this.stateRepository.findByCountryId(country_id);
    }

    @Override
    public List<City> getCityList(int state_id) {
        return (List<City>) this.cityRepository.findByStateId(state_id);
    }

    @Override
    public List<Currency> getCurrencyList() {
        return (List<Currency>) this.currencyRepository.findAll();
    }

}
