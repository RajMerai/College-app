package com.collegeinfo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class College {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private String name;
	private String courseName;
	private int duration;
	private String accommodationType;
	private String accommodationFee;
	
	@OneToMany(mappedBy = "college", cascade = CascadeType.ALL)
	
	private List<CourseFee> courseFees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAccommodationType() {
		return accommodationType;
	}

	public void setAccommodationType(String accommodationType) {
		this.accommodationType = accommodationType;
	}

	public String getAccommodationFee() {
		return accommodationFee;
	}

	public void setAccommodationFee(String accommodationFee) {
		this.accommodationFee = accommodationFee;
	}

	public List<CourseFee> getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(List<CourseFee> courseFees) {
		this.courseFees = courseFees;
	}
	
	
	

}
