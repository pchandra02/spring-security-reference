package com.reference.spring.security.validator;

import com.reference.spring.security.model.Hotel;
import com.reference.spring.security.model.User;
import com.reference.spring.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;
import java.lang.String;


/**
 * Created by Srj on 8/25/16.
 */
@Component
public class FieldValidator implements Validator {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailValidator emailValidator;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    private Pattern pattern;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (!emailValidator.validate(user.getUsername())) {
            errors.rejectValue("username", "Pattern.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
    }
    public void validateHotel(Object o, Errors errors) {

        Hotel hotel = (Hotel)o;
        if(!emailValidator.validate(hotel.getEmail())){
            errors.rejectValue("email", "Pattern.username" );
        }

    }
}
