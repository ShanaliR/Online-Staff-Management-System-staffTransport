package com.staffTransport;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	// Define database connection parameters
	private static String url="jdbc:mysql://localhost:3306/staff";// JDBC URL for MySQL
	private static String userName="root";// MySQL username
	private static String password="sql123";// MySQL password
	private static Connection con;// Connection object to hold the database connection
	
	// A method to establish a database connection and return a Connection object
	public static Connection getConnection() {
		
		try {
			// Load the MySQL JDBC driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			// Establish a connection to the database using the specified URL, username, and password
			con=DriverManager.getConnection(url, userName, password);
			
		}
		catch(Exception e) {
			// Handle any exceptions that might occur during the connection process
			System.out.println("Database connection is not success!!");
		}
		// Return the established connection
		return con;
	}
	
}
