package com.jspiders.jdbc.operations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class JDBCDelete {

	private static Connection connection ;
	private static Driver driver ;
	private static Statement statement ;
	private static String query ;
	
	public static void main(String[] args) {
		
		try {
			connection = openConnection();
			
			statement = connection.createStatement();
			query = "delete from student where id = 1" ;
			int row = statement.executeUpdate(query);
			System.out.println(row + " rows are affected.");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Connection openConnection( ) throws ClassNotFoundException, IOException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		File file = new File("E:/db_info.txt");
		FileReader fileReader = new FileReader(file);
		Properties properties = new Properties();
		properties.load(fileReader);
		
		return DriverManager.getConnection(properties.getProperty("url"), properties);
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
