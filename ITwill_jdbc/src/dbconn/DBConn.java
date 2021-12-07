package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	// 내가 한거 
	// 컨넥션을 리턴하는 메서드
	static Connection conn;
	static Connection getConn() {
		// 드라이버 로딩
		// 컨넥션 객체 생성
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String id = "scorr";
			String pwd = "tiger";
			DriverManager.getConnection(url,id,pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch ( SQLException e) {
			e.printStackTrace();
		}
		if( conn == null) return null;
		return conn;
	}
	
}
