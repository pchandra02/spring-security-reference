package com.reference.spring.security.model;

import javax.persistence.*;

/**
 * Created by Srj on 9/26/16.
 */
@Entity
@Table(name="currency")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String currency_code;

    @Column(name="currency_name")
    private String currency_name;

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getCurrency_name() {
        return currency_name;
    }

    public void setCurrency_name(String currency_name) {
        this.currency_name = currency_name;
    }
    @Override
    public String toString(){
        return "currency_code=" + currency_code + "currency_name=" + currency_name;
    }
}
