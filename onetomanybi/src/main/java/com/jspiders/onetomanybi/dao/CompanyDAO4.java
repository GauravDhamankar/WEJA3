package com.jspiders.onetomanybi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomanybi.dto.Employee;

public class CompanyDAO4 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager ;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Employee employee = entityManager.find(Employee.class, 2);
		employee.setName("Pratik");
		employee.setEmail("pratik@gmail.com");
		entityManager.persist(employee);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("onetomany");
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
