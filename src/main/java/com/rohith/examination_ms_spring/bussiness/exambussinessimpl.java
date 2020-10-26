package com.rohith.examination_ms_spring.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.Dao.examDaoInterface;
import com.rohith.examination_ms_spring.models.exam;
import com.rohith.examination_ms_spring.models.faculty;

@Component
public class exambussinessimpl implements examBussinessInterface {

	@Autowired
	examDaoInterface edi;

	@Override
	public List<exam> getexamsoffaculty(faculty facultyobj) {
		return edi.getexamsoffaculty(facultyobj);

	}

	@Override
	public boolean addexam(exam examobj) {
		return edi.addexam(examobj);
	}

	@Override
	public List<exam> getallexams() {
		return edi.getallexams();
	}

}
