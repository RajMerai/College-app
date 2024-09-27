package com.collegeinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegeinfo.entity.College;
import com.collegeinfo.exception.ResourceNotFoundException;
import com.collegeinfo.repository.CollegeRepository;

@Service
public class CollegeService {
    
    @Autowired
    private CollegeRepository collegeRepository;
    
    // Get all colleges
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    // Get college by ID
    public College getCollegeById(Long id) {
        return collegeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("College not found with id: " + id));
    }

    // Create a new college
    public College createCollege(College college) {
        return collegeRepository.save(college);
    }

    // Update college by ID
    public College updateCollege(Long id, College collegeDetails) {
        College college = getCollegeById(id);
        college.setName(collegeDetails.getName());
        college.setCourseName(collegeDetails.getCourseName());
        college.setDuration(collegeDetails.getDuration());
        college.setAccommodationType(collegeDetails.getAccommodationType());
        college.setAccommodationFee(collegeDetails.getAccommodationFee());
        return collegeRepository.save(college);
    }

    // Delete college by ID
    public void deleteCollege(Long id) {
        College college = getCollegeById(id);
        collegeRepository.delete(college);
    }
}
