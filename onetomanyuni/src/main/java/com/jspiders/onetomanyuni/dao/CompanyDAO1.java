package com.jspiders.onetomanyuni.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomanyuni.dto.Company;
import com.jspiders.onetomanyuni.dto.Employee;

public class CompanyDAO1 {

	private static EntityManagerFactory entityManagerFactory ;
	private static EntityManager entityManager ;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Employee employee1 = new Employee();
		employee1.setName("Gaurav");
		employee1.setEmail("gaurav@gmail.com");
		employee1.setSalary(54000);
		
		Employee employee2 = new Employee();
		employee2.setName("tejas");
		employee2.setEmail("tejas@gmail.com");
		employee2.setSalary(63000);
		
		Company company = new Company();
		company.setName("Tata");
		company.setAdress("Pune");
		company.setEmployees(Arrays.asList(employee1, employee2));
		entityManager.persist(company);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("company");
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
