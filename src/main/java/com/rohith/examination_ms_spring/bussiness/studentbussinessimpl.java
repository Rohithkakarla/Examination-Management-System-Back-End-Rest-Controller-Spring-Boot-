package com.rohith.examination_ms_spring.bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.Dao.StudentDaoInterface;
import com.rohith.examination_ms_spring.models.Student;

@Component
public class studentbussinessimpl implements studentBussinessInterface {

	@Autowired
	StudentDaoInterface sdi;
	
	@Override
	public List<Student> getallstudents() {
		return sdi.getallstudents();
	}

	@Override
	public boolean addstudent(Student student) {
		return sdi.addstudent(student);
	}

	@Override
	public Student checkstudent(Student studentobj) {
		return sdi.checkstudent(studentobj);
	}

}
