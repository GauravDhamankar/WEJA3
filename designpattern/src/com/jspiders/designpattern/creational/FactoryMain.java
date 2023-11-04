package com.jspiders.designpattern.creational;

import java.util.Scanner;

public class FactoryMain {

	private static Beverage beverage ;
	
	public static void main(String[] args) {
		try {
			factory().order();
		} catch (NullPointerException e) {
//			e.printStackTrace();
			System.out.println("Beverage is not ordered.");
		}
	}
	
	private static Beverage factory() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 for Masala tea");
		System.out.println("Enter 2 for Ginger tea");
		System.out.println("Enter 3 for Black tea");
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1:
			beverage = new MasalaTea();
			break;
		
		case 2 : 
			beverage = new GingerTea();
			break ;
		
		case 3 : 
			beverage = new BlackTea();
			break ;
			
		default: System.out.println("Envalid choice.");
		}
		
		scanner.close();
		return beverage ;
	}
}
