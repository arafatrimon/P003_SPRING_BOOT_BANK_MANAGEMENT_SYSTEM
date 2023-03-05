
package com.example.bank_management_system.controller;

import com.example.bank_management_system.model.Branch;
import com.example.bank_management_system.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BranchController {

    @Autowired
    private BranchRepository branchRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Branch>> getAllBranch(@RequestParam(required = false) String name) {
        try {
            List<Branch> branchs = new ArrayList<>();
            if (name == null) {
                branchRepository.findAll().forEach(branchs::add);
            } else {
                branchRepository.findByNameContaining(name).forEach(branchs::add);
            }
            if ((branchs.isEmpty())) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Branch> getBranchById(@PathVariable("id") long id) {

        Optional<Branch> projectData = branchRepository.findById(id);
        if (projectData.isPresent()) {
            return new ResponseEntity<>(projectData.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/save")
    public ResponseEntity<Branch> createBranch(@RequestBody Branch project) {
        try {
            Branch _project = branchRepository.save(project);
            return new ResponseEntity<>(_project, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Branch> updateProject(@PathVariable("id") long id, @RequestBody Branch branch) {
        Optional<Branch> projectData = branchRepository.findById(id);
        if (projectData.isPresent()) {
            branch.setBranch_id(id);
            return new ResponseEntity<>(branchRepository.save(branch), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") long id) {
        try {
            branchRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
