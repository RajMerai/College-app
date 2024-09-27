package com.collegeinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collegeinfo.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long>{

}
