package com.rohith.examination_ms_spring.bussiness;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.models.exam;
import com.rohith.examination_ms_spring.models.faculty;
@Component
public interface examBussinessInterface {

	public List<exam> getexamsoffaculty(faculty facultyobj);

	public boolean addexam(exam examobj);

	public List<exam> getallexams();
}
