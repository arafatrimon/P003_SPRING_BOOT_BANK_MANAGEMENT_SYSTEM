package com.example.bank_management_system.controller;

import com.example.bank_management_system.model.Security;
import com.example.bank_management_system.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SecurityController {

    @Autowired
    private SecurityRepository securityRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Security>> getAllSecurity(@RequestParam(required = false) String name) {
        try {
            List<Security> securitys = new ArrayList<>();
            if (name == null) {
                securityRepository.findAll().forEach(securitys::add);
            } else {
                securityRepository.findByNameContaining(name).forEach(securitys::add);
            }
            if ((securitys.isEmpty())) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Security> getSecurityById(@PathVariable("id") long id) {

        Optional<Security> projectData = securityRepository.findById(id);
        if (projectData.isPresent()) {
            return new ResponseEntity<>(projectData.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/save")
    public ResponseEntity<Security> createSecurity(@RequestBody Security project) {
        try {
            Security _project = securityRepository.save(project);
            return new ResponseEntity<>(_project, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Security> updateProject(@PathVariable("id") long id, @RequestBody Security security) {
        Optional<Security> projectData = securityRepository.findById(id);
        if (projectData.isPresent()) {
            security.setSecurity_id(id);
            return new ResponseEntity<>(securityRepository.save(security), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") long id) {
        try {
            securityRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

