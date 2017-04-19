package com.reference.spring.security.model;

import javax.persistence.*;

/**
 * Created by Srj on 9/26/16.
 */
@Entity
@Table(name="state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int state_id;

    @Column(name = "state_name")
    private String state_name;

    @ManyToOne
    @JoinColumn(name = "country_id", insertable = false)
    private Country country;

   /* @Column(name = "country_id")
    private int country_id;

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }*/

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return "id=" + state_id + "state_name=" + state_name;
    }
}
