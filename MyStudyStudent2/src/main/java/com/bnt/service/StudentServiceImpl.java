package com.bnt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnt.dao.StudentDaoImpl;
import com.bnt.model.Student;

@Service
public class StudentServiceImpl{

	@Autowired
	private StudentDaoImpl studentDaoImpl;

	public String validate(Student student) {
		String error = "";
		if (student != null) {
			if (student.getRollNo() == 0) {
				error = error.concat("*Rollno should not be empty* ");
			}
			if (student.getName() == null || student.getName().trim().isEmpty()) {
				error = error.concat("*Name should not be null or empty* ");
			}
			if (student.getSubject() == null || student.getSubject().isEmpty()) {
				error = error.concat("*SUbject should not be null or empty* ");
			}
		} else {
			error = error.concat("*Request should not be empty* ");
		}

		return error;
	}

	@Transactional
	public List<Student> getAllStudent() {
		List<Student> list = studentDaoImpl.getAllStudent();
		return list;
	}
	
	@Transactional
	public String addStudent(Student student) {
		String error = validate(student);
		if (error.length() != 0) {
			return error;
		} else {
			try {
				studentDaoImpl.addStudent(student) ;
			}
			catch (Exception e) {
				error = error + " Please try with new Rollno this Student RollNo alredy exist!!";
			}
			}
			return error;
	}

	@Transactional
	public Student getStudentById(int studId) {
		return studentDaoImpl.getStudentById(studId);
	}

}
