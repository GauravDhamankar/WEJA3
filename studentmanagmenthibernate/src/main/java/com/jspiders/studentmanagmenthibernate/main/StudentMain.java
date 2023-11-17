package com.jspiders.studentmanagmenthibernate.main;

import java.util.Scanner;

import com.jspiders.studentmanagmenthibernate.dao.StudentDAO;
import com.jspiders.studentmanagmenthibernate.dto.Student;

public class StudentMain {

	private static StudentDAO studentDAO = new StudentDAO();
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean flag = true ;
		
		while (flag) {
			System.out.println("Welcome to Student Managment System");
			System.out.println("1. Add student\n2. Delete student\n3. Update student\n4. Get student by Id\n5. Get all student\n6. Exit");
			System.out.println("Enter your choice : ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				Student student = new Student();
				System.out.println("Enter name of student : ");
				student.setName(scanner.nextLine());
				System.out.println("Enter email of student : ");
				student.setEmail(scanner.nextLine());
				System.out.println("Enter age of student : ");
				student.setAge(scanner.nextInt());
				
				studentDAO.addStudent(student);
				
				break;

			case 2 : 
				System.out.println("Enter id to delete student : ");
				studentDAO.deleteStudent(scanner.nextInt());
				break;
				
			case 3 : 
				System.out.println("Enter student id to update it : ");
				studentDAO.updateStudent(scanner.nextInt(),scanner);
				break;
				
			case 4 :
				System.out.println("Enter ID to get student : ");
				studentDAO.getStudentById(scanner.nextInt());
				break;
				
			case 5 :
				studentDAO.getAllStudent();
				break;
				
			case 6 : 
				System.out.println("Thank You !");
				flag = false;
				break;
				
			default: 
				System.out.println("Enter valid choice !");
				break;
			}
			
		}
		
		scanner.close();
	}
}
