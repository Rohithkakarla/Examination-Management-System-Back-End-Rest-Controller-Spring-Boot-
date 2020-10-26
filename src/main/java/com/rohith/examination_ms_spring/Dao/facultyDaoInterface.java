package com.rohith.examination_ms_spring.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.models.faculty;

@Component
public interface facultyDaoInterface {
	public List<faculty> getallfaculty();

	public boolean addfaculty(faculty facultyobj);

	public faculty checkfaculty(faculty facultyobj);
}
