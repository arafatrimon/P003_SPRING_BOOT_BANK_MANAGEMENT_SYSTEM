package com.example.bank_management_system.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommonService {
    ResponseEntity<List<?>> getAll();
    ResponseEntity<?> getById();
    ResponseEntity<?> save();
    ResponseEntity<?> update();
    ResponseEntity<?> deleteById();
}
