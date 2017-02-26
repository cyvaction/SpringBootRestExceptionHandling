package com.g33kzone.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.g33kzone.SpringRestExceptionApplication;
import com.g33kzone.exception.NoDataFoundException;
import com.g33kzone.pojo.Course;
import com.g33kzone.service.CourseService;

@RestController
@RequestMapping("rest/")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "course/greeting", method = RequestMethod.GET, produces = "application/text")
	public ResponseEntity<String> addMessage() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello World");
	}

	@RequestMapping(value = "course", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Course>> fetchAllCourse() {

		return ResponseEntity.status(HttpStatus.OK).body(SpringRestExceptionApplication.courseList);
	}

	@RequestMapping(value = "course/{name}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Course>> addCourse(@PathVariable String name) {
		courseService.addCourse(name);
		return ResponseEntity.status(HttpStatus.CREATED).body(SpringRestExceptionApplication.courseList);
	}

	@RequestMapping(value = "course/{name}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<List<Course>> deleteCourse(@PathVariable String name) {
		courseService.deleteCourse(name);
		return ResponseEntity.status(HttpStatus.OK).body(SpringRestExceptionApplication.courseList);
	}

	@RequestMapping(value = "course/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Course>> fetchCourseById(@PathVariable int id) throws NoDataFoundException {

		List<Course> courseList = courseService.fetchCourseById(id);

		// throw custom exception
		if (courseList.isEmpty()) {
			throw new NoDataFoundException();
		}
		return ResponseEntity.status(HttpStatus.OK).body(courseService.fetchCourseById(id));
	}

	@RequestMapping(value = "course/coursename", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Course>> fetchCourseByName(@RequestParam("name") String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return ResponseEntity.status(HttpStatus.OK).body(courseService.fetchCourseByName(name));
	}

	@ExceptionHandler(TypeMismatchException.class)
	public void handleTypeMismatchException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), "Please try again with valid input type");
	}

	// Custom Exception Class
	@ExceptionHandler(NoDataFoundException.class)
	public void handleNoDataFoundException(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), "No data found. Please try again with valid input");
	}

}
