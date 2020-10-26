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

import com.rohith.examination_ms_spring.bussiness.facultyBussinessInterface;
import com.rohith.examination_ms_spring.models.faculty;

@RestController
@RequestMapping("/faculty")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class facultyController {

	@Autowired
	facultyBussinessInterface fbi;

	@GetMapping("/getallfaculty")
	public List<faculty> getallfaculty() {
		return fbi.getallfaculty();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/addfaculty", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addstudent(@RequestBody faculty facultyobj) {
		boolean value = fbi.addfaculty(facultyobj);

		if (value == true) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/checkfaculty", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<faculty> checkstudent(@RequestBody faculty facultyobj) {
		faculty facultyobjreturned = fbi.checkfaculty(facultyobj);

		if (facultyobjreturned == null) {
			return new ResponseEntity<faculty>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<faculty>(facultyobjreturned, HttpStatus.ACCEPTED);
	}

}
