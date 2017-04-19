package com.reference.spring.security.repository;

import com.reference.spring.security.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Srj on 9/27/16.
 */
public interface CurrencyRepository extends JpaRepository<Currency, String> {
}
