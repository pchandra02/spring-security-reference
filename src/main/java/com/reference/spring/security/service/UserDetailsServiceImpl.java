package com.reference.spring.security.service;
import com.reference.spring.security.model.JwtUserFactory;
import com.reference.spring.security.model.User;
import com.reference.spring.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Srj on 8/22/16.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (null == user) {

            throw new UsernameNotFoundException("No user present with username: " + username);

        }
        else {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();


            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));


            return JwtUserFactory.create(user,grantedAuthorities);
        }
    }
}
