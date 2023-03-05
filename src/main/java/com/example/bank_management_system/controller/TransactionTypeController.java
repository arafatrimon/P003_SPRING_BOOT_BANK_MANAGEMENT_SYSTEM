package com.example.bank_management_system.controller;

import com.example.bank_management_system.model.TransactionType;
import com.example.bank_management_system.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionTypeController {

    @Autowired
    private TransactionTypeRepository transactionRepository;

    @GetMapping("/list")
    public ResponseEntity<List<TransactionType>> getAllTransactionType(@RequestParam(required = false) String name) {
        try {
            List<TransactionType> transactions = new ArrayList<>();
            if (name == null) {
                transactionRepository.findAll().forEach(transactions::add);
            } else {
                transactionRepository.findByNameContaining(name).forEach(transactions::add);
            }
            if ((transactions.isEmpty())) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<TransactionType> getTransactionTypeById(@PathVariable("id") long id) {

        Optional<TransactionType> projectData = transactionRepository.findById(id);
        if (projectData.isPresent()) {
            return new ResponseEntity<>(projectData.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/save")
    public ResponseEntity<TransactionType> createTransactionType(@RequestBody TransactionType project) {
        try {
            TransactionType _project = transactionRepository.save(project);
            return new ResponseEntity<>(_project, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<TransactionType> updateProject(@PathVariable("id") long id, @RequestBody TransactionType transaction) {
//        Optional<TransactionType> projectData = transactionRepository.findById(id);
//        if (projectData.isPresent()) {
//            transaction.setTransactionType_id(id);
//            return new ResponseEntity<>(transactionRepository.save(transaction), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") long id) {
        try {
            transactionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
