package com.example.bank_management_system.repository;

import com.example.bank_management_system.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByNameContaining(String name);
}
