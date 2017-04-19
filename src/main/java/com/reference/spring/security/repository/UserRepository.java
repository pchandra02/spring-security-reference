package com.reference.spring.security.repository;

import com.reference.spring.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Srj on 8/24/16.
 */


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
