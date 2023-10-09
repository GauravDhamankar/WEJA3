package com.jspiders.designpattern.creational;

import java.util.Scanner;

public class MobileMain {

	private static Mobile mobile ;
	
	public static void main(String[] args) {
		try {
			factory().order();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Choose correct option.");
		}
	}
	
	public static Mobile factory() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.Order Iphone\n"
				+ "2.Order Realmi\n"
				+ "3.Order Samsung\n"
				+ "4.Order Oneplus");
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1: mobile = new Iphone();break;
		
		case 2 : mobile = new Realmi(); break ;
		
		case 3 : mobile = new Samsung(); break ;
		
		case 4 : mobile = new Onplus(); break;
		

		default: System.out.print("Enter valid choice.");
			break;
		}
		
		scanner.close();
		return mobile;
		
	}
}
