package com.dimaspramantya.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dimaspramantya.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	// define field for entity manager
	private EntityManager entityManager;
	
	// inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	// implement save method
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}
	
	@Override
	public Student findStudentById(int id) {
		return entityManager.find(Student.class, id);
	}
	
	@Override
	public List<Student> findAllStudent() {
		TypedQuery<Student> fetchStudents = entityManager.createQuery("SELECT u FROM Student u", Student.class);
		return fetchStudents.getResultList();
	}
	
	@Override
	public TypedQuery<Student> findStudentByLastName(String name) {
		TypedQuery<Student> studentQuery = entityManager.createQuery("SELECT u FROM Student u WHERE u.lastName = :name", Student.class);
		studentQuery.setParameter("name", name);
		return studentQuery;
	}
	
	@Override
	@Transactional
	public void updateStudent(Student theStudent) {
		entityManager.merge(theStudent);
	}
	
	@Override
	@Transactional
	public void deleteStudentById(int id) {
		Student student = findStudentById(id);
		entityManager.remove(student);
	}
	
	@Override
	@Transactional
	public int deleteAllStudent() {
		int numRowsAffected = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsAffected;
	}
}
