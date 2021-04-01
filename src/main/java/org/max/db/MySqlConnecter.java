package org.max.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnecter {

	static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
	static final String USER = "admin";
	static final String PASS = "1234";

	public Connection getConn() throws SQLException {
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}
	
}
