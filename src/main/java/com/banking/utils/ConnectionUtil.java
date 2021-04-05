package com.banking.utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException{
	
	//makes java aware of our database driver
	try {
		Class.forName("org.postgresql.Driver");
		
	} catch (Exception e) {
		e.printStackTrace();
	} 
	
	String url ="jdbc:postgresql://localhost:5432/user_accounts";
	String user ="postgres";
	String pass ="password";
	
	//creates our connection to our database
	return DriverManager.getConnection(url, user, pass);

	//tests our connection
//	try (Connection conn = ConnectionUtil.getConnection()) {
//		System.out.println("Connection Successful");
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}

	}
}
