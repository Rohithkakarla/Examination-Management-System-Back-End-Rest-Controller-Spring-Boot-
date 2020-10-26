package com.rohith.examination_ms_spring.bussiness;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.models.course;
import com.rohith.examination_ms_spring.models.faculty;

@Component
public interface courseBussinessInterface {

	public List<course> getallcourses();

	public boolean addcourse(course courseobj);

	public List<course> getcoursesoffaculty(faculty faculty);
}
