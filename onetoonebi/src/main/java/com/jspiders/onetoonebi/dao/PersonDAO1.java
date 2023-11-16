package com.jspiders.onetoonebi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetoonebi.dto.AdharCard;
import com.jspiders.onetoonebi.dto.Person;

public class PersonDAO1 {

	private static EntityManagerFactory entityManagerFactory ;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Person person = new Person();
		person.setName("Rohit Chavan");
		person.setEmail("rohit@gmail.com");
		
		AdharCard adharCard = new AdharCard();
		adharCard.setAdharNumber(897654332112l);
		entityManager.persist(adharCard);
		
		person.setAdharCard(adharCard);
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
