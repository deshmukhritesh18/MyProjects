package com.bnt.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bnt.model.Student;
@Repository
public class StudentDaoImpl  {
	
	@Autowired
	private SessionFactory sf;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
		System.out.println("*******************1"+sf);
	}

	public List<Student> getAllStudent() {
		System.out.println("**************"+sf);
		Session session = sf.getCurrentSession();
		CriteriaBuilder cb = (CriteriaBuilder) session.getCriteriaBuilder();
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	public Student addStudent(Student student) {
		sf.getCurrentSession().save(student);
		return student;
	}

	public Student getStudentById(int studId) {
		return sf.getCurrentSession().get(Student.class, studId);
	}

}
