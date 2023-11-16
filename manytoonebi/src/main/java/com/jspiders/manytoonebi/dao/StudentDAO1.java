package com.jspiders.manytoonebi.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytoonebi.dto.Course;
import com.jspiders.manytoonebi.dto.Student;

public class StudentDAO1 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Student student = new Student();
		student.setName("Gaurav");
		student.setEmail("gaurav@gmail.com");
		
		Student student2 = new Student();
		student2.setName("Rohit");
		student2.setEmail("rohit@gmail.com");
		
		Course course = new Course();
		course.setName("Development");
		
		student.setCourse(course);
		student2.setCourse(course);
		
		course.setStudents(Arrays.asList(student,student2));
		entityManager.persist(course);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("manytoone");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnection() {
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
