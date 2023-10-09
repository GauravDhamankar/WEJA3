package com.jspiders.multithreading.resource;

public class Account {

	private double accountBalance;

	public Account(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public synchronized void deposite(double amount) {
		accountBalance += amount;
		System.out.println(amount + " has been credited.");
		System.out.println("Account balance is : "+accountBalance+" rs");
	}
	
	public synchronized void withdraw(double amount) {
		if(amount > accountBalance) {
			System.out.println("Insufficient balance");
		} else {
			accountBalance -= amount;
			System.out.println(amount + " has been debited.");
			System.out.println("Account balance : " + accountBalance);
		}
	}
	
}
