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

import com.rohith.examination_ms_spring.bussiness.courseBussinessInterface;
import com.rohith.examination_ms_spring.models.course;
import com.rohith.examination_ms_spring.models.faculty;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class courseController {

	@Autowired
	courseBussinessInterface cbi;

	@GetMapping("/getallcourses")
	public List<course> getallcourses() {
		return cbi.getallcourses();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/addcourse", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addstudent(@RequestBody course courseobj) {
		boolean value = cbi.addcourse(courseobj);

		if (value == true) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/getcoursesoffaculty", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<course>> getallcoursesoffaculty(@RequestBody faculty faculty) {
		List<course> course = cbi.getcoursesoffaculty(faculty);
		return new ResponseEntity<List<course>>(course, HttpStatus.ACCEPTED);
	}
}
