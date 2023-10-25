package com.jspiders.jdbc.operations;

import java.util.List;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		StudentJDBC  jdbc = new StudentJDBC();
		Scanner scanner = new Scanner(System.in);
		boolean flag = true ;
		
		while(flag) {
			System.out.println("1. Add student\n2. Get all students\n3. Get student by id\n4. Delete student\n5. Update student\n6. Exit.");
			System.out.println("Enter your choice.");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				Student student = new Student();
				System.out.println("Enter student id.");
				student.setId(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter student name.");
				student.setName(scanner.nextLine());
				System.out.println("Enter student email.");
				student.setEmail(scanner.nextLine());
				System.out.println("Enter student age.");
				student.setAge(scanner.nextInt());
				System.out.println("Enter student fees");
				student.setFees(scanner.nextDouble());
				jdbc.addStudent(student);
				break;

			case 2 : 
				List<Student> students = jdbc.getAllStudents();
				for (Student student2 : students) {
					System.out.println(student2);
				}
				break ;
				
			case 3 : 
				System.out.println("Enter student id.");
				Student student2 = jdbc.getStudentById(scanner.nextInt());
				System.out.println(student2);
				break;
				
			case 4 : 
				System.out.println("Enter student id.");
				jdbc.deleteStudent(scanner.nextInt());
				break;
				
			case 5 : 
				System.out.println("Enter student id.");
				jdbc.updateStudent(scanner.nextInt(), scanner);
				break ;
				
			case 6 : 
				System.out.println("Thank You!");
				flag = false ;
				break;
				
			default:
				System.out.println("Invalid choice.");
			}
		}
		scanner.close();
	}
}
