package com.reference.spring.security.json;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
/**
 * Created by Srj on 9/7/16.
 */
public class AuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;
    private String username;
    private String password;


    public AuthenticationRequest(){
        super();
    }

    public AuthenticationRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
