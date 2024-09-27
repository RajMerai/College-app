package com.collegeinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.collegeinfo")
public class CollegeInfoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeInfoApiApplication.class, args);
	}

}
