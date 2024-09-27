package com.collegeinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collegeinfo.entity.CourseFee;

@Repository
public interface CourseFeeRepository extends JpaRepository<CourseFee, Long>{

}
