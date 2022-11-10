package com.bnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bnt.model.Student;
import com.bnt.service.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImpl service;
	
	
	@GetMapping(value = "/getAllStd")
	public List<Student> getAllStudent(@RequestBody Student student) {

		List<Student> list = service.getAllStudent();

		System.out.println(list);
		return list;

	}

	@PostMapping(value = "/createStd")
	public ResponseEntity<String> save(@RequestBody Student student) {
		String error = "";
		try {
			error = service.addStudent(student);
			if (error.length() != 0) {
				return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity("Student Add", HttpStatus.OK);
			}
		} catch (Exception exception) {
			System.out.println("Exception in controller :" + exception.getStackTrace());
		}

		return new ResponseEntity(error, HttpStatus.OK);

	}
	
	@GetMapping(value = "/getStudent/{studId}")
	public Student select(@PathVariable int studId) {

		Student list = service.getStudentById(studId);
		System.out.println(studId);
		return list;

	}

	

}
