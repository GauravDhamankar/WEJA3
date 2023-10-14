package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCSelect3 {

	private static Connection connection ;
	private static PreparedStatement preparedStatement ;
	private static ResultSet resultSet ;
	private static String query ;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in) ;
		System.out.println("Enter the id of student : ");
		int id = scanner.nextInt();
		scanner.close();
		
		try {
			connection = openOnnection();
			
			query = "select * from student where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"||" + resultSet.getString(2)+"||"+resultSet.getString(3)+"||"+resultSet.getInt(4)+"||"+resultSet.getDouble(5));
			}
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
	
	private static Connection openOnnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root") ;
	}
	
	private static void closeConnection() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (connection != null) {
			connection.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
	}
}
