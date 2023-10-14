package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsert4 {

	private static Connection connection;
	private static PreparedStatement preparedStatement ;
	private static String query ;
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id.");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the name.");
		String name = scanner.nextLine();
		System.out.println("Enter the email.");
		String email = scanner.nextLine();
		System.out.println("Enter the age.");
		int age = scanner.nextInt();
		System.out.println("Enter the fees");
		double fees = scanner.nextDouble();
		scanner.close();
		try {
			connection = openConnection();
			query = "insert into student values(?,?,?,?,?)" ;
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setInt(4, age);
			preparedStatement.setDouble(5, fees);
			
			int row = preparedStatement.executeUpdate();
			System.out.println(row + " rows are affected.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static Connection openConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
	}

	private static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (preparedStatement != null) {
			connection.close();
		}
		
	}
}
