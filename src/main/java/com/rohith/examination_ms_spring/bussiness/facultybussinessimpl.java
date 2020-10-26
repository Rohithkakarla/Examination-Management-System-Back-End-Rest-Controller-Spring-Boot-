package com.rohith.examination_ms_spring.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.Dao.facultyDaoInterface;
import com.rohith.examination_ms_spring.models.faculty;

@Component
public class facultybussinessimpl implements facultyBussinessInterface {

	@Autowired
	facultyDaoInterface fdi;

	@Override
	public List<faculty> getallfaculty() {
		return fdi.getallfaculty();
	}

	@Override
	public boolean addfaculty(faculty facultyobj) {
		return fdi.addfaculty(facultyobj);
	}

	@Override
	public faculty checkfaculty(faculty facultyobj) {
		return fdi.checkfaculty(facultyobj);
	}

}
