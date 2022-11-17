package com.bnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bnt.model.Student;
import com.bnt.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping("/addStudent")
	public String addNewStudent(@RequestBody Student s) {

		Student s1 = new Student();
		
		String stud = null;
		try {
			stud = studentService.addStudent(s);

			if (stud.length() != 0) {
				System.out.println("student in controller");
			} else {
				stud = "Add student Details Successfully";
			}
		} catch (Exception ex) {
			ex.getMessage();
		}

		return stud;

	}

	@GetMapping(value = "/getById/{studId}")
	public Student getAll(@PathVariable int studId) {
		Student list = studentService.displayStudent(studId);
		return list;

	}

	@GetMapping(value = "/getAllStudent")
	public List<Student> getAllStudent() {
		List<Student> list = studentService.displayAllStudent();
		return list;

	}

}
