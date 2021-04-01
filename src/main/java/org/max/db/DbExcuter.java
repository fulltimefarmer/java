package org.max.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbExcuter {

	static MySqlConnecter db = new MySqlConnecter();
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	
	static String TABLE_NAME = "TINSTALLER_DESC";
	
	public static void main(String[] args) {
		try {
			createTable();
			insertRecords(retrieveRecords());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void createTable() throws SQLException {
		stmt = db.getConn().createStatement();
		String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
		stmt.executeUpdate(sql);
		sql = "CREATE TABLE " 
				+ TABLE_NAME
				+ " (pid INTEGER not NULL AUTO_INCREMENT, " 
				+ " INSTALLER_DISPLAY_NAME VARCHAR(80), " 
				+ " INSTALLER_ID VARCHAR(80), " 
				+ " INSTALLER_NAME VARCHAR(80), " 
				+ " PRIMARY KEY (pid))";
		stmt.executeUpdate(sql);
	}
	
	static ResultSet retrieveRecords() throws SQLException {
		String sql = "SELECT DISTINCT INSTALLER_DISPLAY_NAME, INSTALLER_ID FROM TINSTALLER";
		stmt = db.getConn().createStatement();
		return stmt.executeQuery(sql);
	}
	
	static void insertRecords(ResultSet rs) throws SQLException {
		String sql = "INSERT INTO " + TABLE_NAME + " (INSTALLER_DISPLAY_NAME, INSTALLER_ID) VALUES (?, ?)";
		pstmt = db.getConn().prepareStatement(sql);
		while(rs.next()) {
//			StringBuilder sb = new StringBuilder();
//			sb.append(rs.getString("INSTALLER_DISPLAY_NAME"));
//			sb.append("\t\t");
//			sb.append(rs.getString("INSTALLER_ID"));
//			System.out.println(sb.toString());
			pstmt.setString(1, rs.getString("INSTALLER_DISPLAY_NAME"));
			pstmt.setString(2, rs.getString("INSTALLER_ID"));
			pstmt.executeUpdate();
		}
	}
	
}
