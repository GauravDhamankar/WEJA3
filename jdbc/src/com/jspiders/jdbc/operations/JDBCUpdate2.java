package com.jspiders.jdbc.operations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class JDBCUpdate2 {

	private static Connection connection ;
	private static PreparedStatement preparedStatement ;
	private static String query ;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id of the student");
		int id = scanner.nextInt();
		System.out.println("Enter the fees of student.");
		double fees = scanner.nextDouble();
		scanner.close();
		
		try {
			connection = openConnection();
			
			query = "update student set fees = ? where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, fees);
			preparedStatement.setInt(2, id);
			int row = preparedStatement.executeUpdate();
			System.out.println(row + " rows are affected.");
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
		if (preparedStatement != null) {
			preparedStatement.close();
		}
	}
}
