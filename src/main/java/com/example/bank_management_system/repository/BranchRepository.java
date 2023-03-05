package com.example.bank_management_system.repository;

import com.example.bank_management_system.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    List<Branch> findByNameContaining(String name);
}
