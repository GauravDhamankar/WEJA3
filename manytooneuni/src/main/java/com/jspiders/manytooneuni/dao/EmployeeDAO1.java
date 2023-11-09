package com.jspiders.manytooneuni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.manytooneuni.dto.Company;
import com.jspiders.manytooneuni.dto.Employee;

public class EmployeeDAO1 {

	private static EntityManagerFactory entityManagerFactory ;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	
	public static void main(String[] args) {
		
		openConnection(); 
		entityTransaction.begin();
		
		Company company = new Company();
		company.setName("Tata");
		company.setAddress("Pune");
		entityManager.persist(company);
		
		Employee employee = new Employee();
		employee.setName("Gaurav");
		employee.setEmail("gaurav@gmail.com");
		employee.setSalary(45000);
		employee.setCompany(company);
		entityManager.persist(employee);
		
		Employee employee2 = new Employee();
		employee2.setName("Tejas");
		employee2.setEmail("tejas@gmail.com");
		employee2.setSalary(35000);
		employee2.setCompany(company);
		entityManager.persist(employee2);
		
		entityTransaction.commit();
		closeConnection();
	}
	
	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("employee");
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
