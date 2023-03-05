package com.example.bank_management_system.repository;

import com.example.bank_management_system.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByNameContaining(String name);
}
