package com.reference.spring.security.controller;

/**
 * Created by Srj on 8/12/16.
 */
import com.reference.spring.security.model.JwtUser;
import com.reference.spring.security.model.User;
import com.reference.spring.security.security.TokenUtils;
import com.reference.spring.security.service.UserService;
import com.reference.spring.security.validator.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller

public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private FieldValidator fieldValidator;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    TokenUtils tokenUtils;


    @RequestMapping(value="/", method=RequestMethod.GET)
    public String homePage() {
        return "homePage";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)

    public String registration(Model model, @ModelAttribute("userForm") User userForm, BindingResult bindingResult){

        fieldValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()){
            model.addAttribute("error", true);
            return "registration";
        }

        userService.save(userForm);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error){
        if (error != null) {
            model.addAttribute("error", true);
        }

    return "login";

    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginpage(@ModelAttribute("user") User user, HttpServletRequest httpRequest, HttpServletResponse httpResponse){
        String username = user.getUsername();
        String password = user.getPassword();
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(userDetails != null){
            if(bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
                JwtUser jwtUser = (JwtUser) userDetails;
                String token = this.tokenUtils.generateToken(jwtUser);
                Cookie cookie = new Cookie("jwtToken", token);
                cookie.setPath("/");
               // cookie.setDomain(".axisrooms.com");
                httpResponse.addCookie(cookie);
                return "redirect:/app/hotel";
            }
        }
        return "login";
    }

}