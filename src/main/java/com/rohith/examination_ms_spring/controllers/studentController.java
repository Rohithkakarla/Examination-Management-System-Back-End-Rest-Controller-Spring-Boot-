package com.rohith.examination_ms_spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohith.examination_ms_spring.bussiness.studentBussinessInterface;
import com.rohith.examination_ms_spring.models.Student;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class studentController {

	@Autowired
	studentBussinessInterface sbi;

	@GetMapping("/getallstudents")
	public List<Student> getAllstudents() {
		return sbi.getallstudents();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/addstudent", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addstudent(@RequestBody Student studentobj) {
		boolean value = sbi.addstudent(studentobj);

		if (value == true) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/checkstudent", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> checkstudent(@RequestBody Student studentobj) {
		Student studentobjreturned = sbi.checkstudent(studentobj);

		if (studentobjreturned == null) {
			return new ResponseEntity<Student>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<Student>(studentobjreturned, HttpStatus.ACCEPTED);
	}
}
