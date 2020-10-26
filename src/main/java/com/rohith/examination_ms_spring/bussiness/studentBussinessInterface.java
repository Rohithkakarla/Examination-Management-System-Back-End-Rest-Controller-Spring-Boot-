package com.rohith.examination_ms_spring.bussiness;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.models.Student;

@Component
public interface studentBussinessInterface {

	public List<Student> getallstudents();
	public boolean addstudent(Student student);
	public Student checkstudent(Student studentobj);
}
