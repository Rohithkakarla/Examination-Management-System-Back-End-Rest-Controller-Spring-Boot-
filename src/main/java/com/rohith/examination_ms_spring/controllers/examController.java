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

import com.rohith.examination_ms_spring.bussiness.examBussinessInterface;
import com.rohith.examination_ms_spring.models.exam;
import com.rohith.examination_ms_spring.models.faculty;

@RestController
@RequestMapping("/exams")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class examController {

	@Autowired
	examBussinessInterface ebi;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/getexamsoffaculty", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<exam>> getallexamsoffaculty(@RequestBody faculty facultyobj) {
		List<exam> list = ebi.getexamsoffaculty(facultyobj);
		System.out.println(list);
		return new ResponseEntity<List<exam>>(list, HttpStatus.ACCEPTED);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/addexam", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addstudent(@RequestBody exam examobj) {
		boolean value = ebi.addexam(examobj);

		if (value == true) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@GetMapping("/getallexams")
	public ResponseEntity<List<exam>> getallexams() {
		List<exam> list = ebi.getallexams();

		return new ResponseEntity<List<exam>>(list, HttpStatus.ACCEPTED);

	}
}
