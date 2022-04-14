package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDaoImpl {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int insert(Student student) {
		int i = (Integer) this.hibernateTemplate.save(student);
		return i;

	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}

	public List<Student> getAllStudent() {
		List<Student> student = this.hibernateTemplate.loadAll(Student.class);
		return student;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void deleteStudent(int studentId) {

		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}

	@Transactional
	public void updateStudent(Student student) {
			
		this.hibernateTemplate.update(student);
	}

}
