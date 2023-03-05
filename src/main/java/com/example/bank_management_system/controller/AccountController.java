package com.example.bank_management_system.controller;

import com.example.bank_management_system.model.Account;
import com.example.bank_management_system.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Account>> getAllAccount(@RequestParam(required = false) String name) {
        try {
            List<Account> accounts = new ArrayList<>();
            if (name == null) {
                accountRepository.findAll().forEach(accounts::add);
            } else {
                accountRepository.findByNameContaining(name).forEach(accounts::add);
            }
            if ((accounts.isEmpty())) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") long id) {

        Optional<Account> projectData = accountRepository.findById(id);
        if (projectData.isPresent()) {
            return new ResponseEntity<>(projectData.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/save")
    public ResponseEntity<Account> createAccount(@RequestBody Account project) {
        try {
            Account _project = accountRepository.save(project);
            return new ResponseEntity<>(_project, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Account> updateProject(@PathVariable("id") long id, @RequestBody Account account) {
        Optional<Account> projectData = accountRepository.findById(id);
        if (projectData.isPresent()) {
            account.setAccount_id(id);
            return new ResponseEntity<>(accountRepository.save(account), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") long id) {
        try {
            accountRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

