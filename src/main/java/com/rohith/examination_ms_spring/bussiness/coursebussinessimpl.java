package com.rohith.examination_ms_spring.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.Dao.courseDaoInterface;
import com.rohith.examination_ms_spring.models.course;
import com.rohith.examination_ms_spring.models.faculty;

@Component
public class coursebussinessimpl implements courseBussinessInterface {

	@Autowired
	courseDaoInterface cdi;

	@Override
	public List<course> getallcourses() {
		return cdi.getallcourses();
	}

	@Override
	public boolean addcourse(course courseobj) {
		return cdi.addcourse(courseobj);
	}

	@Override
	public List<course> getcoursesoffaculty(faculty faculty) {
		return cdi.getcourseoffaculty(faculty);
	}

}
