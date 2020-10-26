package com.rohith.examination_ms_spring.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.models.exam;
import com.rohith.examination_ms_spring.models.faculty;
@Component
public interface examDaoInterface {

	public List<exam> getexamsoffaculty(faculty facultyobj);

	public boolean addexam(exam examobj);
	
	public List<exam> getallexams();
}
