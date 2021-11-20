package com.codechobo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDBConnect {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1522:orcl", 
				"scott", 
				"tiger"
			);
			stmt = conn.createStatement();
			stmt.executeQuery("SELECT 'DB조회성공' FROM DUAL");
			rs = stmt.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {	
		}
	}
}

