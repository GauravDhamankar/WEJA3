package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCInsert {

	public static void main(String[] args) throws SQLException {
		
		// register Driver 
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		// open connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3?user=root&password=root");
		
		// create statements
		Statement statement = connection.createStatement();
		
		// execute statements
		statement.execute("INSERT INTO student values(1,'Ram','ram@gmail.com',24,20000)");
		
		// process result
		System.out.println("Data inserted succesfully!!!");
		
		// close connection
		connection.close();
		statement.close();
		
	}
}
