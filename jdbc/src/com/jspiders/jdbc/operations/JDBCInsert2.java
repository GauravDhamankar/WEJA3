package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

// code standardization

public class JDBCInsert2 {
	
	private static Driver driver ;
	private static Connection connection ;
	private static Statement statement ;
	private static String query ;
	
	
	public static void main(String[] args) {
		
		try {
			connection = openConnection();
			
			// 3--->>> create or prepare statement
			statement = connection.createStatement();
			query = "insert into student values(2,'Suresh','suresh@gmail.com',23,34000) ";
			
			// 4--->>> execute statements and process result
			int row = statement.executeUpdate(query);
			System.out.println(row + " rows are affected.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 5--->>> close connection
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// create connection using openConnection()
	private static Connection openConnection() throws SQLException {
		
		// 1--->>>> Register Driver
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		// 2--->>>> get connection between java application and database application
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
	}
	
	// 5--->>> close connection
	private static void closeConnection() throws SQLException {
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
		
		// 6--->>> deregister the driver
		DriverManager.deregisterDriver(driver);
	}
}
