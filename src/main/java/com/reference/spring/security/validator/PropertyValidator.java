package com.reference.spring.security.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by Srj on 10/18/16.
 */
@Component
public class PropertyValidator {

    public boolean validateHotelExists(String name, String city ,String existingHotelName,String existingCityName, String state, String existingStateName) {

        name = name.toLowerCase();
        name = name.replace("hotel","");
        name = name.replace("the","");
        existingHotelName = existingHotelName.toLowerCase();
        existingHotelName = existingHotelName.replace("hotel","");
        existingHotelName = existingHotelName.replace("the","");
        name = StringUtils.delete(name," ");
        existingHotelName = StringUtils.delete(existingHotelName," ");

        return name.equals(existingHotelName) && city.toLowerCase().equals(existingCityName.toLowerCase())
                && state.toLowerCase().equals(existingStateName.toLowerCase());
    }


}
