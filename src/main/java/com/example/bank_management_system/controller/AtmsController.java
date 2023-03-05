
package com.example.bank_management_system.controller;

import com.example.bank_management_system.model.Atms;
import com.example.bank_management_system.repository.AtmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AtmsController {

    @Autowired
    private AtmsRepository atmsRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Atms>> getAllAtms(@RequestParam(required = false) String name) {
        try {
            List<Atms> atmss = new ArrayList<>();
            if (name == null) {
                atmsRepository.findAll().forEach(atmss::add);
            } else {
                atmsRepository.findByNameContaining(name).forEach(atmss::add);
            }
            if ((atmss.isEmpty())) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Atms> getAtmsById(@PathVariable("id") long id) {

        Optional<Atms> projectData = atmsRepository.findById(id);
        if (projectData.isPresent()) {
            return new ResponseEntity<>(projectData.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/save")
    public ResponseEntity<Atms> createAtms(@RequestBody Atms project) {
        try {
            Atms _project = atmsRepository.save(project);
            return new ResponseEntity<>(_project, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Atms> updateProject(@PathVariable("id") long id, @RequestBody Atms atms) {
//        Optional<Atms> projectData = atmsRepository.findById(id);
//        if (projectData.isPresent()) {
//            atms.setAtms_id(id);
//            return new ResponseEntity<>(atmsRepository.save(atms), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") long id) {
        try {
            atmsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
