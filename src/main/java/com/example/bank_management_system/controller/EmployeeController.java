package com.example.bank_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeController {

    @Autowired
    private AttorneyRepository attorneyRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Attorney>> getAllAttorney(@RequestParam(required = false) String name) {
        try {
            List<Attorney> attorneys = new ArrayList<>();
            if (name == null) {
                attorneyRepository.findAll().forEach(attorneys::add);
            } else {
                attorneyRepository.findByNameContaining(name).forEach(attorneys::add);
            }
            if ((attorneys.isEmpty())) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Attorney> getAttorneyById(@PathVariable("id") long id) {

        Optional<Attorney> projectData = attorneyRepository.findById(id);
        if (projectData.isPresent()) {
            return new ResponseEntity<>(projectData.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/save")
    public ResponseEntity<Attorney> createAttorney(@RequestBody Attorney project) {
        try {
            Attorney _project = attorneyRepository.save(project);
            return new ResponseEntity<>(_project, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Attorney> updateProject(@PathVariable("id") long id, @RequestBody Attorney attorney) {
        Optional<Attorney> projectData = attorneyRepository.findById(id);
        if (projectData.isPresent()) {
            attorney.setAttorney_id(id);
            return new ResponseEntity<>(attorneyRepository.save(attorney), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") long id) {
        try {
            attorneyRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

