package com.jspiders.onetoonebi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoonebi.dto.Person;

public class PersonDAO4 {

	private static EntityManagerFactory entityManagerFactory ;
	private static EntityManager entityManager ;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Person person = entityManager.find(Person.class, 2);
		person.setName("Ashutosh Powar");
		person.setEmail("ashutosh@gmail.com");
		entityManager.persist(person);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("onetoone");
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
