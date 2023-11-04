package com.jspiders.hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate1.dto.Student;

public class StudentDAO1 {

	private static EntityManagerFactory entityManagerFactory ;
	private static EntityManager entityManager ;
	private static EntityTransaction entityTransaction ;
	
	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		
		Student student = new Student();
		student.setId(1);
		student.setName("Gaurav");
		student.setEmail("gaurav@gmail.com");
		student.setAge(23);
		student.setFees(35400);
		
		entityManager.persist(student);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("student");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		
	}
	
	private static void closeConnection() {
		
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
}
