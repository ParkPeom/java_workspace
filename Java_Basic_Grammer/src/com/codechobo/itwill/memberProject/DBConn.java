package com.codechobo.itwill.memberProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn {
	static {
		try {//드라이브 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {}
	}
	Connection conn;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	public DBConn() {		
	}
	public void getConn() {//DB연결
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="c##scott";
		String password="tiger";
		try {
			conn = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("DB연결에러");
		}
	}
	public void setDBClose() {//sql닫기
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {e.printStackTrace();}
	}
}







