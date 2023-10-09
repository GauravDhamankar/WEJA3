package com.jspiders.designpattern.creational;

import java.util.Scanner;

public class CarMain {
	private static Car car ;
	
	public static void main(String[] args) {
		try {
			factory().order();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public static Car factory() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to order Thar.\n"
				+ "Enter 2 to order Nexon\n"
				+ "Enter 3 to order Harrier\n"
				+ "Enter 4 to order Scorpio");
		
		System.out.println("Enter your choice : ");
		int choice = scanner.nextInt();
		
		switch(choice) {
		case 1 : car = new Thar(); break ;
		
		case 2 : car = new Nexon(); break ;
		
		case 3 : car = new Harrier(); break ;
		
		case 4 : car = new Scorpio(); break ;
		
		default : System.out.println("Enter valid choice");
		
		}
		
		scanner.close();
		
		return car;
	}
}
