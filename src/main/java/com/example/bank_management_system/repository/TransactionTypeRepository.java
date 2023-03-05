package com.example.bank_management_system.repository;

import com.example.bank_management_system.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
    List<TransactionType> findByNameContaining(String name);
}
