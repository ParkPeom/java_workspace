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
			
			// XE : ����Ŭ expression ����
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
	// DB�� ������ �ϸ� �׻� ���� �ִ� �۾��� �ؾ� �Ѵ�.
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
	// ������ �����ָ� �� �ȿ� ������ ���� ���� �ι��� ������ �ҋ��� Adapter ������ �߻� 
	// ������ �ȵȴ�.
	// �׻� ������ ������ dbConn�� null �� �ʱ�ȭ
	}
}