package com.rohith.examination_ms_spring.models;

public class exam {

	private String name;
	private String courseid;
	private String facultyid;

	public exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public exam(String name, String courseid, String facultyid) {
		super();
		this.name = name;
		this.courseid = courseid;
		this.facultyid = facultyid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(String facultyid) {
		this.facultyid = facultyid;
	}

	@Override
	public String toString() {
		return "exam [name=" + name + ", courseid=" + courseid + ", facultyid=" + facultyid + "]";
	}

}
