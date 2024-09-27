package com.collegeinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegeinfo.entity.College;
import com.collegeinfo.service.CollegeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    // Create College
    @PostMapping
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        College newCollege = collegeService.createCollege(college);
        return new ResponseEntity<>(newCollege, HttpStatus.CREATED);
    }

    // Read all Colleges
    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    // Read College by ID
    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        College college = collegeService.getCollegeById(id);
        return new ResponseEntity<>(college, HttpStatus.OK);
    }

    // Update College by ID
    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable Long id, @RequestBody College collegeDetails) {
        College updatedCollege = collegeService.updateCollege(id, collegeDetails);
        return new ResponseEntity<>(updatedCollege, HttpStatus.OK);
    }

    // Delete College by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable Long id) {
        collegeService.deleteCollege(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
