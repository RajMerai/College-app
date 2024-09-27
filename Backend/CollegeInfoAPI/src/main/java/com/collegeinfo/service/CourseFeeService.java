package com.collegeinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeinfo.entity.College;
import com.collegeinfo.entity.CourseFee;
import com.collegeinfo.exception.ResourceNotFoundException;
import com.collegeinfo.repository.CourseFeeRepository;

@Service
public class CourseFeeService {
    
    @Autowired
    private CourseFeeRepository courseFeeRepository;
    
    @Autowired
    private CollegeService collegeService;

    // Create a new CourseFee associated with a specific college
    public CourseFee createCourseFee(Long collegeId, CourseFee courseFee) {
        College college = collegeService.getCollegeById(collegeId);
        courseFee.setCollege(college);
        return courseFeeRepository.save(courseFee);
    }

    // Get all CourseFees by college ID
    public List<CourseFee> getAllCourseFeesByCollegeId(Long collegeId) {
        College college = collegeService.getCollegeById(collegeId);
        return college.getCourseFees();
    }

    // Update a CourseFee by its ID
    public CourseFee updateCourseFee(Long collegeId, Long feeId, CourseFee courseFeeDetails) {
        CourseFee courseFee = getCourseFeeById(feeId);
        courseFee.setFee(courseFeeDetails.getFee());
        courseFee.setCollege(collegeService.getCollegeById(collegeId));
        return courseFeeRepository.save(courseFee);
    }

    // Delete a CourseFee by its ID
    public void deleteCourseFee(Long collegeId, Long feeId) {
        CourseFee courseFee = getCourseFeeById(feeId);
        courseFeeRepository.delete(courseFee);
    }

    // Helper method to get CourseFee by ID
    private CourseFee getCourseFeeById(Long feeId) {
        return courseFeeRepository.findById(feeId)
            .orElseThrow(() -> new ResourceNotFoundException("CourseFee not found with id: " + feeId));
    }
}
