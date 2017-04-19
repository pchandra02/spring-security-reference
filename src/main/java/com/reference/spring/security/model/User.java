package com.reference.spring.security.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Srj on 8/19/16.
 */
@Entity
@Table(name="users")
public class User {


    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int userid;

    @Column(name="username", unique = true, nullable = false)
   // @Email(regexp = "^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$")
    private String username;

    @Column(name = "first_name", nullable = false, length = 60)
    private String firstname;

    @Column(name = "last_name", nullable = false, length = 80)
    private String lastname;

    @Column(name = "password", nullable = false, length = 80)
    private String password;

    public User() {
        super();
    }

    public int getId() {
        return userid;
    }

    public void setId(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString()
    {
        return  "username =" + username + ", firstname=" + firstname + ", lastname=" + lastname +
                ",password=" + password ;
    }
}
