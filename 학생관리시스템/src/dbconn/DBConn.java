package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn {
	
	public Connection conn;

	public PreparedStatement pstmt;
	
	public ResultSet rs;
	
	public Connection getConn() {
		if(conn == null) {
			try {
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			
			// XE : 오라클 expression 버전
			String user = "scott";
			String pwd = "tiger";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
		return conn;
	}
	// DB는 연결을 하면 항상 끊어 주는 작업을 해야 한다.
	public void setDBClose() {
		if(conn != null) {
			try {
				if(conn.isClosed()) {
				conn.close();
			}
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	// 연결을 끊어주면 그 안에 쓰레기 값이 남아 두번쨰 연결을 할떄는 Adapter 에러가 발생 
	// 접속이 안된다.
	// 항상 연결을 끊으면 dbConn을 null 로 초기화
	}
}