package com.example.bank_management_system.repository;

import com.example.bank_management_system.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByNameContaining(String name);
}

