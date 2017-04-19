package com.reference.spring.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Srj on 9/6/16.
 */
@Component
public class JwtAuthenticationInterceptor implements HandlerInterceptor {

   @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Override
    public boolean preHandle(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object o) throws Exception {


        Cookie[] authToken = httpRequest.getCookies();
        Cookie cookieToProcess = null;
        if(authToken != null) {
            for (Cookie cookie : authToken) {
                if ("jwtToken".equals(cookie.getName())) {
                    cookieToProcess = cookie;
                }
            }

            if (cookieToProcess != null) {
                String username = tokenUtils.parseToken(cookieToProcess.getValue()).getUsername();
                if (tokenUtils.validateToken(cookieToProcess.getValue(), userDetailsServiceImpl.loadUserByUsername(username))) {
                    return true;
                }
            }
        }
        httpResponse.sendRedirect("login.jsp");
        return false;

    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
