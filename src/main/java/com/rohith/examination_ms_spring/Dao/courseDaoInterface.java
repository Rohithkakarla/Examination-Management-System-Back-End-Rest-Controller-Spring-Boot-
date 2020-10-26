package com.rohith.examination_ms_spring.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.models.course;
import com.rohith.examination_ms_spring.models.faculty;

@Component
public interface courseDaoInterface {

	public List<course> getallcourses();

	public boolean addcourse(course courseobj);

	public List<course> getcourseoffaculty(faculty faculty);
}
