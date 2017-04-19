package com.reference.spring.security.model;

import javax.persistence.*;

/**
 * Created by Srj on 9/26/16.
 */
@Entity
@Table(name="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int city_id;

    @Column(name = "city_name")
    private String city_name;

    @ManyToOne
    @JoinColumn(name = "state_id", insertable = false)
    private State state;

   /* @Column(name = "state_id")
    private int state_id;

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }*/

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString(){
        return "id=" + city_id + "city_name=" + city_name;
    }
}
