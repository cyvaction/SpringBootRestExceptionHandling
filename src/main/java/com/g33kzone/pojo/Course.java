package com.g33kzone.pojo;

public class Course {

	private int courseId;
	private String CourseName;

	public Course() {
	}

	public Course(int courseId, String courseName) {
		this.courseId = courseId;
		CourseName = courseName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (CourseName != other.CourseName)
			return false;
		return true;
	}
}
