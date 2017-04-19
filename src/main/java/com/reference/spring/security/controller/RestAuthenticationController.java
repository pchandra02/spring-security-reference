package com.reference.spring.security.controller;

import com.reference.spring.security.json.AuthenticationRequest;
import com.reference.spring.security.json.AuthenticationResponse;
import com.reference.spring.security.model.JwtUser;
import com.reference.spring.security.model.User;
import com.reference.spring.security.security.TokenUtils;
import com.reference.spring.security.service.UserService;
import com.reference.spring.security.validator.FieldValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Srj on 9/7/16.
 */
@RestController
public class RestAuthenticationController {

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    FieldValidator fieldValidator;

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(method = RequestMethod.POST, value = "/registration/")
    public ResponseEntity<Void> register(@RequestBody User user, BindingResult bindingResult) {
        fieldValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        userService.save(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login/")
    public ResponseEntity<?> authenticationRequest(@RequestBody AuthenticationRequest authenticationRequest, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws AuthenticationException {

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String password = authenticationRequest.getPassword();
        String token = null;
        if (userDetails != null) {
            if (bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
                JwtUser jwtUser = (JwtUser) userDetails;
                token = this.tokenUtils.generateToken(jwtUser);
                Cookie cookie = new Cookie("jwtToken", token);
                cookie.setPath("/");
                httpResponse.addCookie(cookie);
            }
        }
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
}
