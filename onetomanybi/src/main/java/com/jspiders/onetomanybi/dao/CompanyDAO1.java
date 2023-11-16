package com.jspiders.onetomanybi.dao;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.onetomanybi.dto.Company;
import com.jspiders.onetomanybi.dto.Employee;

public class CompanyDAO1 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager ;
	private static EntityTransaction entityTransaction ;
	
	public static void main(String[] args) {
		
		openConnection();
		entityTransaction.begin();
		
		Employee employee = new Employee();
		employee.setName("Gaurav");
		employee.setEmail("gaurav@gmail.com");
		employee.setSalary(85000);
		
		Employee employee2 = new Employee();
		employee2.setName("Tejas");
		employee2.setEmail("tejas@gmail.com");
		employee2.setSalary(45000);
		
		Employee employee3 = new Employee();
		employee3.setName("Rohit");
		employee3.setEmail("rohit@gmail.com");
		employee3.setSalary(53000);
		
		Company company = new Company();
		company.setName("Tech Mahindra");
		company.setAddress("Mumbai");
		
		employee.setCompany(company);
		employee2.setCompany(company);
		employee3.setCompany(company);
		
		company.setEmployees(Arrays.asList(employee, employee2, employee3));
		entityManager.persist(company);
		
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
