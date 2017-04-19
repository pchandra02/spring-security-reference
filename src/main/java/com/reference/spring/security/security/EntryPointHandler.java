package com.reference.spring.security.security;

import com.reference.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Srj on 9/7/16.
 */
@Component
public class EntryPointHandler implements AuthenticationEntryPoint {

    @Autowired
    UserRepository userRepository;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.sendError(httpServletResponse.SC_UNAUTHORIZED, "Access Denied");
    }
}
