package com.jspiders.jdbc.operations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCSelect1 {
	
	private static Connection connection ;
	private static Statement statement ;
	private static String query ;
	
	public static void main(String[] args) {
		
		try {
			connection = openConnection();
			statement = connection.createStatement();
			query = "select * from student" ;
			statement.execute(query);
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"||" + resultSet.getString(2) + "\t||" + resultSet.getString(3)+"||" + resultSet.getInt(4) + "||"+ resultSet.getInt(5));
			}
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
	
	private static Connection openConnection() throws ClassNotFoundException, SQLException, IOException {
		// register Driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// read the file 
		File file = new File("E:/db_info.txt");
		FileReader fileReader = new FileReader(file);
		Properties properties = new Properties();
		properties.load(fileReader) ;
		return DriverManager.getConnection(properties.getProperty("url"), properties) ;
	}
	
	private static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (statement != null) {
			statement.close();
		}
	}
}
