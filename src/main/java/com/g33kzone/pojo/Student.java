package com.g33kzone.pojo;

import java.util.List;

public class Student {
	private int studentId;
	private String studentName;
	private List<Course> courseName;

	public Student() {
	}

	public Student(int studentId, String studentName, List<Course> courseName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseName = courseName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<Course> getCourseName() {
		return courseName;
	}

	public void setCourseName(List<Course> courseName) {
		this.courseName = courseName;
	}

}
