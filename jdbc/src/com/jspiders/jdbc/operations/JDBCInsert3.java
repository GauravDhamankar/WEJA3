package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class JDBCInsert3 {

	private static Connection connection ;
	private static Statement statement ;
	private static Driver driver ;
	private static String query ;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id of student.");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter name of student.");
		String name = scanner.nextLine();
		System.out.println("Enter email of student.");
		String email = scanner.nextLine();
		System.out.println("Enter age of student.");
		int age = scanner.nextInt();
		System.out.println("Enter the fees of student.");
		int fees = scanner.nextInt();
		scanner.close();
		
		try {
			connection = openConnection();
			
			statement = connection.createStatement();
		
			query = "INSERT INTO student values("+id+",'"+name+"','"+email+"',"+age+","+fees+")";
			
			int row = statement.executeUpdate(query);
			System.out.println(row + " rows are affected.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Connection openConnection() throws SQLException {
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
	}
	
	private static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (statement != null) {
			statement.close();
		}
		
		DriverManager.deregisterDriver(driver);
	}
}
