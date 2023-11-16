package com.jspiders.manytomanybi.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytomanybi.dto.Course;
import com.jspiders.manytomanybi.dto.Student;

public class StudentDAO1 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Course course1 = new Course();
		course1.setName("SQL");
		course1.setFees(10000);
		
		Course course2 = new Course();
		course2.setName("CORE JAVA");
		course2.setFees(15000);
		
		Course course3 = new Course();
		course3.setName("Web Tech");
		course3.setFees(20000);
		
		Course course4 = new Course();
		course4.setName("J2EE");
		course4.setFees(25000);
		
		Student student1 = new Student();
		student1.setName("Gaurav");
		student1.setEmail("gaurav@gmail.com");
		
		Student student2 = new Student();
		student2.setName("Tejas");
		student2.setEmail("tejas@gmail.com");
		
		Student student3 = new Student();
		student3.setName("Rohit");
		student3.setEmail("rohit@gmail.com");
		
		Student student4 = new Student();
		student4.setName("Ashutosh");
		student4.setEmail("ashutosh@gmail.com");
		
		course1.setStudents(Arrays.asList(student1,student2));
		course2.setStudents(Arrays.asList(student3,student4));
		course3.setStudents(Arrays.asList(student1,student4));
		course4.setStudents(Arrays.asList(student2,student3));
		
		student1.setCourses(Arrays.asList(course1,course3));
		entityManager.persist(student1);
		student2.setCourses(Arrays.asList(course1,course4));
		entityManager.persist(student2);
		student3.setCourses(Arrays.asList(course2,course4));
		entityManager.persist(student3);
		student4.setCourses(Arrays.asList(course2,course3));	
		entityManager.persist(student4);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("manytomany");
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
