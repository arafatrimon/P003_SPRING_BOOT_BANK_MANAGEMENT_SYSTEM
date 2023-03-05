package com.example.bank_management_system.repository;

import com.example.bank_management_system.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecurityRepository extends JpaRepository<Security, Long> {
    List<Security> findByNameContaining(String name);
}
