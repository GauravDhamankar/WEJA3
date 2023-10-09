package com.jspiders.designpattern.creational;

import java.util.Scanner;

public class OlaMain {

	private static Ola ola ;
	
	public static void main(String[] args) {
		try {
			factory().order();
		} catch (Exception e) {
			System.out.println("Choose correct option.");
		}
	}
	
	public static Ola factory() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.Book Auto\n"
				+ "2.Book Bike\n"
				+ "3.Book sedan\n"
				+ "4.Book Mini");
		int choice = scanner.nextInt();
		
		switch (choice) {
		case 1 : ola = new Auto();
			break;

		case 2 : ola = new BIke();
			break ;
		
		case 3 : ola = new Sedan();
			break ;
		
		case 4 : ola = new Mini();
			break ;
			
		default: System.out.println("Enter valid choice.");
			break;
		}
		scanner.close();
		return ola;
		
	}
}
