package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	// ���� �Ѱ� 
	// ���ؼ��� �����ϴ� �޼���
	static Connection conn;
	static Connection getConn() {
		// ����̹� �ε�
		// ���ؼ� ��ü ����
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
