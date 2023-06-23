package dev.mouse.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {
	static final String DB_URL = "jdbc:mysql://localhost:3306/";
	static final String DATABASE_NAME = "testdb";
	static final String USER = "root";
	static final String PASSWORD = "1234";
	static final String DRIVE_NAME = "com.mysql.cj.jdbc.Driver";
	
	public static Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName(DRIVE_NAME);
			Connection conn = DriverManager.getConnection(DB_URL + DATABASE_NAME, USER, PASSWORD);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
