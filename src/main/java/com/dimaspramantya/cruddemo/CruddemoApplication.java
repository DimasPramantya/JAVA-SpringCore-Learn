package com.dimaspramantya.cruddemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dimaspramantya.cruddemo.dao.StudentDAO;
import com.dimaspramantya.cruddemo.entity.Student;

import jakarta.persistence.TypedQuery;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	@Autowired
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			
			//readStudentById(studentDAO);
			
			readAllStudents(studentDAO);
			
			//readStudentByLastName(studentDAO);
			
			//updateStudent(studentDAO);
			
			//deleteStudentById(studentDAO);
			
			//deleteAllStudent(studentDAO);
			
			//readAllStudents(studentDAO);
		};
	}
	
	private void createStudent(StudentDAO studentDAO) {

		// CREATE
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Dudul", "I Gusti", "dudul@gmail.com"); 
		
		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		
		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
	
	private void readStudentById(StudentDAO studentDAO) {
		//READ
		Student firstStudent = studentDAO.findStudentById(1);
		System.out.println(firstStudent);
	}
	
	private void readAllStudents(StudentDAO studentDAO) {
		//READ ALL
		List<Student> allStudent = studentDAO.findAllStudent();
		for(Student student : allStudent) {
			System.out.println(student);
		}
	}
	
	private void readStudentByLastName (StudentDAO studentDAO) {
		TypedQuery<Student> student = studentDAO.findStudentByLastName("I Gusti");
		System.out.println(student.getSingleResult());
	}
	
	private void updateStudent(StudentDAO studentDAO) {
		Student theStudent = studentDAO.findStudentById(2);
		theStudent.setLastName("Itsugi");
		theStudent.setFirstName("Samid");
		studentDAO.updateStudent(theStudent);
		System.out.println(studentDAO.findStudentById(2));
	}
	
	private void deleteStudentById(StudentDAO studentDAO) {
		studentDAO.deleteStudentById(2);
	}
	
	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("DELETING ALL THE STUDENT DATA....");
		System.out.println(studentDAO.deleteAllStudent() + " students has been deleted!"); 
	}

}
