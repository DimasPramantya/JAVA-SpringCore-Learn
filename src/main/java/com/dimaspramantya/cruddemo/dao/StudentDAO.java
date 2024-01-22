package com.dimaspramantya.cruddemo.dao;

import java.util.List;

import com.dimaspramantya.cruddemo.entity.Student;

import jakarta.persistence.TypedQuery;

public interface StudentDAO {
	
	void save(Student theStudent);
	
	Student findStudentById(int id);
	
	List<Student> findAllStudent();
	
	TypedQuery<Student> findStudentByLastName(String name);
	
	void updateStudent(Student theStudent);
	
	void deleteStudentById(int id);
	
	int deleteAllStudent();
}
