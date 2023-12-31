package com.jspiders.onetomanybi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomanybi.dto.Employee;

public class CompanyDAO3 {

	private static EntityManagerFactory entityManagerFactory ;
	private static EntityManager entityManager ;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Employee employee = entityManager.find(Employee.class, 3);
		if (employee != null) {
			entityManager.remove(employee);
		} else {
			System.out.println("===== Employee not found ! =====");
		}
		
		entityTransaction.commit();
		closeConnetion();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("onetomany");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	private static void closeConnetion() {
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
