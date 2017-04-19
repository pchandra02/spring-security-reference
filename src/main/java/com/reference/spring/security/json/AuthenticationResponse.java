package com.reference.spring.security.json;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.servlet.http.Cookie;

/**
 * Created by Srj on 9/7/16.
 */
public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private String token;

    public AuthenticationResponse(){
        super();
    }

    public AuthenticationResponse(String token) {
        this.setToken(token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
