package com.rohith.examination_ms_spring.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.models.Student;

@Component
public interface StudentDaoInterface {

	public List<Student> getallstudents();

	public boolean addstudent(Student student);

	public Student checkstudent(Student studentobj);
}
