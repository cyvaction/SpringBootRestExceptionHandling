package com.g33kzone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.g33kzone.pojo.Course;
import com.g33kzone.pojo.Student;

@SpringBootApplication
public class SpringRestExceptionApplication {

	// public static List<String> coursesList = new ArrayList<>();

	// Initialize list
	public static List<Course> courseList = new ArrayList<>();
	public static List<Student> studentList = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(SpringRestExceptionApplication.class, args);

		// Add few courses
		courseList.add(new Course(1, "Java"));
		courseList.add(new Course(2, "JEE"));

	}
}
