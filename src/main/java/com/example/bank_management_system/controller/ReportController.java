package com.example.bank_management_system.controller;

import com.example.bank_management_system.model.Report;
import com.example.bank_management_system.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Report>> getAllReport(@RequestParam(required = false) String name) {
        try {
            List<Report> reports = new ArrayList<>();
            if (name == null) {
                reportRepository.findAll().forEach(reports::add);
            } else {
                reportRepository.findByNameContaining(name).forEach(reports::add);
            }
            if ((reports.isEmpty())) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable("id") long id) {

        Optional<Report> projectData = reportRepository.findById(id);
        if (projectData.isPresent()) {
            return new ResponseEntity<>(projectData.get(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/save")
    public ResponseEntity<Report> createReport(@RequestBody Report project) {
        try {
            Report _project = reportRepository.save(project);
            return new ResponseEntity<>(_project, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Report> updateProject(@PathVariable("id") long id, @RequestBody Report report) {
//        Optional<Report> projectData = reportRepository.findById(id);
//        if (projectData.isPresent()) {
//            report.setReport_id(id);
//            return new ResponseEntity<>(reportRepository.save(report), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") long id) {
        try {
            reportRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

