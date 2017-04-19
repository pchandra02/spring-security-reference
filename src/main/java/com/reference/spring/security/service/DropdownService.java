package com.reference.spring.security.service;

import com.reference.spring.security.model.City;
import com.reference.spring.security.model.Country;
import com.reference.spring.security.model.Currency;
import com.reference.spring.security.model.State;

import java.util.List;

/**
 * Created by Srj on 9/27/16.
 */
public interface DropdownService {

    public List<City> getCityList(int state_id);
    public List<State> getStateList(int country_id);
    public List<Country> getCountryList();
    public List<Currency> getCurrencyList();

}
