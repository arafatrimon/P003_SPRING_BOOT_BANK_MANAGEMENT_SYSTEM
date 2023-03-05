package com.example.bank_management_system.repository;

import com.example.bank_management_system.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    List<Currency> findByNameContaining(String name);
}
