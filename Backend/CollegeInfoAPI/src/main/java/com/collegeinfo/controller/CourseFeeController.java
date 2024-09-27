package com.collegeinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collegeinfo.entity.CourseFee;
import com.collegeinfo.service.CourseFeeService;

@RestController
@RequestMapping("/api/courses")
public class CourseFeeController {

    @Autowired
    private CourseFeeService courseFeeService;

    // Create CourseFee
    @PostMapping("/{collegeId}/fees")
    public ResponseEntity<CourseFee> addCourseFee(@PathVariable Long collegeId, @RequestBody CourseFee courseFee) {
        CourseFee newCourseFee = courseFeeService.createCourseFee(collegeId, courseFee);
        return new ResponseEntity<>(newCourseFee, HttpStatus.CREATED);
    }

    // Read all CourseFees by College ID
    @GetMapping("/{collegeId}/fees")
    public ResponseEntity<List<CourseFee>> getAllCourseFeesByCollegeId(@PathVariable Long collegeId) {
        List<CourseFee> courseFees = courseFeeService.getAllCourseFeesByCollegeId(collegeId);
        return new ResponseEntity<>(courseFees, HttpStatus.OK);
    }

    // Update CourseFee by ID
    @PutMapping("/{collegeId}/fees/{feeId}")
    public ResponseEntity<CourseFee> updateCourseFee(
        @PathVariable Long collegeId,
        @PathVariable Long feeId,
        @RequestBody CourseFee courseFeeDetails) {
        
        CourseFee updatedCourseFee = courseFeeService.updateCourseFee(collegeId, feeId, courseFeeDetails);
        return new ResponseEntity<>(updatedCourseFee, HttpStatus.OK);
    }

    // Delete CourseFee by ID
    @DeleteMapping("/{collegeId}/fees/{feeId}")
    public ResponseEntity<Void> deleteCourseFee(@PathVariable Long collegeId, @PathVariable Long feeId) {
        courseFeeService.deleteCourseFee(collegeId, feeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
