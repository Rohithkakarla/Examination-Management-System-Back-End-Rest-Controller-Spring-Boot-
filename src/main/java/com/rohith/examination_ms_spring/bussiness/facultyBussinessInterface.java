package com.rohith.examination_ms_spring.bussiness;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.models.faculty;

@Component
public interface facultyBussinessInterface {

	public List<faculty> getallfaculty();

	public boolean addfaculty(faculty facultyobj);

	public faculty checkfaculty(faculty facultyobj);
}
