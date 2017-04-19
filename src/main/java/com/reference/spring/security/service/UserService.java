package com.reference.spring.security.service;

import com.reference.spring.security.model.User;

/**
 * Created by Srj on 8/24/16.
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
