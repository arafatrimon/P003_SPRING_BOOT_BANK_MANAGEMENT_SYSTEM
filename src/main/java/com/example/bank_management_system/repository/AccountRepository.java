package com.example.bank_management_system.repository;

import com.example.bank_management_system.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByNameContaining(String name);
}
