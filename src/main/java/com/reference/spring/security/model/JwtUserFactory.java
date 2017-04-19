package com.reference.spring.security.model;


import org.springframework.security.core.GrantedAuthority;
import java.util.Set;
/**
 * Created by Srj on 9/12/16.
 */
public class JwtUserFactory {

    public  static JwtUser create(User user,Set<GrantedAuthority>grantedAuthorities){
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstname(),
                user.getLastname(),
                grantedAuthorities
        );
    }
}
