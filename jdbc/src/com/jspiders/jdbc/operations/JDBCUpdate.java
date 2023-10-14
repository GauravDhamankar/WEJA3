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

public class JDBCUpdate {

	private static Connection connection ;
	private static Statement statement ;
	private static Driver driver ;
	private static String query ;
	
	public static void main(String[] args) {
		try {
			connection = openConnection();
			
			statement = connection.createStatement();
			
			query = "update student set age = 23 where id = 1";
			
			int row = statement.executeUpdate(query);
			System.out.println(row + "rows affected.");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static Connection openConnection() throws ClassNotFoundException, IOException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver") ;
		
		File file = new File("E:/db_info.txt");
		FileReader fileReader = new FileReader(file);
		Properties properties = new Properties();
		properties.load(fileReader);
		
		return DriverManager.getConnection(properties.getProperty("url"), properties) ;
	}
	
	private static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (statement != null) {
			connection.close();
		}
		
		DriverManager.deregisterDriver(driver);
	}
}
