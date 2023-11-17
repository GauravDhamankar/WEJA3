package com.jspiders.studentmanagmenthibernate.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.studentmanagmenthibernate.dto.Student;

public class StudentDAO {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;
	
	
	public void addStudent(Student student) {
		
		openConnection();
		entityTransaction.begin();
		
		entityManager.persist(student);
		System.out.println("Student added successfully.");
		
		entityTransaction.commit();
		closeConnection();
	}
	
	public void deleteStudent(int id) {
		
		openConnection();
		entityTransaction.begin();
		
		Student student = entityManager.find(Student.class, id);
		if (student == null) {
			System.out.println("Student is not present !");
		} else {
			entityManager.remove(student);
			System.out.println("Student removed successfully.");
		}
		
		entityTransaction.commit();
		closeConnection();
	}
	
	public void updateStudent(int id, Scanner scanner) {
		
		openConnection();
		entityTransaction.begin();
		
		Student student = entityManager.find(Student.class, id);
		scanner.nextLine();
		System.out.println("Enter name of student : ");
		student.setName(scanner.nextLine());
		System.out.println("Enter email of student : ");
		student.setEmail(scanner.nextLine());
		System.out.println("Enter age of student : ");
		student.setAge(scanner.nextInt());
		
		entityManager.persist(student);
		System.out.println("Student details updated successfully.");
		
		entityTransaction.commit();
		closeConnection();
	}
	
	public void getStudentById(int id) {
		
		openConnection();
		entityTransaction.begin();
		
		Student student = entityManager.find(Student.class, id);
		if (student == null) {
			System.out.println("Student not found with id : " + id);
		} else {
			System.out.println(student);
		}
		
		entityTransaction.commit();
		closeConnection();
	}
	
	public void getAllStudent() {
		
		openConnection();
		entityTransaction.begin();
		
		Query query = entityManager.createQuery("select student from Student student");
		
		@SuppressWarnings("unchecked")
		List<Student> students = query.getResultList();
		for (Student student : students) {
			System.out.println(student);
		}
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private void closeConnection() {
		
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
}
