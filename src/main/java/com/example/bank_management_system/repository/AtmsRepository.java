package com.example.bank_management_system.repository;

import com.example.bank_management_system.model.Atms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtmsRepository extends JpaRepository<Atms, Long> {
    List<Atms> findByNameContaining(String name);
}
