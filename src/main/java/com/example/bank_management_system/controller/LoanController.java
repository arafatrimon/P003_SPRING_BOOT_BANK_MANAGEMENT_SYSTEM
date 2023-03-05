package com.example.bank_management_system.controller;

import com.example.bank_management_system.model.Loan;
import com.example.bank_management_system.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Loan>> getAllLoan(@RequestParam(required = false) String name) {
        try {
            List<Loan> loans = new ArrayList<>();
            if (name == null) {
                loanRepository.findAll().forEach(loans::add);
            } else {
                loanRepository.findByNameContaining(name).forEach(loans::add);
            }
            if ((loans.isEmpty())) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable("id") long id) {

        Optional<Loan> projectData = loanRepository.findById(id);
        if (projectData.isPresent()) {
            return new ResponseEntity<>(projectData.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/save")
    public ResponseEntity<Loan> createLoan(@RequestBody Loan project) {
        try {
            Loan _project = loanRepository.save(project);
            return new ResponseEntity<>(_project, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Loan> updateProject(@PathVariable("id") long id, @RequestBody Loan loan) {
//        Optional<Loan> projectData = loanRepository.findById(id);
//        if (projectData.isPresent()) {
//            loan.setLoan_id(id);
//            return new ResponseEntity<>(loanRepository.save(loan), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") long id) {
        try {
            loanRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
