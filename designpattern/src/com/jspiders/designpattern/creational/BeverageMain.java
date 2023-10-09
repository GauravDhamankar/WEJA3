package com.jspiders.designpattern.creational;

import java.util.Scanner;

public class BeverageMain {

	private static Beverage beverage ;
	
	public static void main(String[] args) {
		try {
			factory().order();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public static Beverage factory() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to order Masala tea\n"
				+ "Enter 2 to order Ginger tea\n"
				+ "Enter 3 to order Green tea");
		
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1 : beverage = new MasalaTea(); break ;
		
		case 2 : beverage = new GingerTea(); break ;
		
		case 3 : beverage = new GreenTea(); break ;

		default: System.out.println("Enter valid choice.");
		}
		
		scanner.close();
		
		return beverage;
		
	}
}
