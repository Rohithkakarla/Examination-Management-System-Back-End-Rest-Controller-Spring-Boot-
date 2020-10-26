package com.rohith.examination_ms_spring.models;

import org.springframework.stereotype.Component;

@Component
public class Student {

	String Userid;
	String name;
	String email;
	String password;
	boolean status;

	public Student() {

	}

	public Student(String userid, String name, String email, String password, boolean status) {
		super();
		Userid = userid;
		this.name = name;
		this.email = email;
		this.password = password;
		this.status = status;
	}

	public String getUserid() {
		return Userid;
	}

	public void setUserid(String userid) {
		Userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [Userid=" + Userid + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", status=" + status + "]";
	}

}
