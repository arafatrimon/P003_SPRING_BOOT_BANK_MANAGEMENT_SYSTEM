package com.example.bank_management_system.controller;

import com.example.bank_management_system.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

public class CurrencyController {

//    @Autowired
//    private CurrencyRepository attorneyRepository;
//
//    @GetMapping("/list")
//    public ResponseEntity<List<Currency>> getAllCurrency(@RequestParam(required = false) String name) {
//        try {
//            List<Currency> attorneys = new ArrayList<>();
//            if (name == null) {
//                attorneyRepository.findAll().forEach(attorneys::add);
//            } else {
//                attorneyRepository.findByNameContaining(name).forEach(attorneys::add);
//            }
//            if ((attorneys.isEmpty())) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/findById/{id}")
//    public ResponseEntity<Currency> getCurrencyById(@PathVariable("id") long id) {
//
//        Optional<Currency> projectData = attorneyRepository.findById(id);
//        if (projectData.isPresent()) {
//            return new ResponseEntity<>(projectData.get(), HttpStatus.OK);
//
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<Currency> createCurrency(@RequestBody Currency project) {
//        try {
//            Currency _project = attorneyRepository.save(project);
//            return new ResponseEntity<>(_project, HttpStatus.CREATED);
//
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Currency> updateProject(@PathVariable("id") long id, @RequestBody Currency attorney) {
//        Optional<Currency> projectData = attorneyRepository.findById(id);
//        if (projectData.isPresent()) {
//            attorney.setCurrency_id(id);
//            return new ResponseEntity<>(attorneyRepository.save(attorney), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") long id) {
//        try {
//            attorneyRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
}
