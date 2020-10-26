package com.rohith.examination_ms_spring.models;

public class course {

	String courseid;
	String name;
	String facultyid;
	boolean status;

	public course(String courseid, String name, String facultyid, boolean status) {
		super();
		this.courseid = courseid;
		this.name = name;
		this.facultyid = facultyid;
		this.status = status;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(String facultyid) {
		this.facultyid = facultyid;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "course [courseid=" + courseid + ", name=" + name + ", facultyid=" + facultyid + ", status=" + status
				+ "]";
	}
	
	

}
