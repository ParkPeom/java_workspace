package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Connection �ν��Ͻ��� �����Ͽ� ��ȯ�ϰų� JDBC ���� �ν��Ͻ��� �����ϴ� ����� �����ϴ� Ŭ���� 
// => JDBC ���α׷� �ۼ��� �ʿ��� �������� ��ɵ��� �޼���� ����
// => ���α׷� ���꼺�� ���Ǹ� ���������� ȿ������ �����ȴ�.
public class ConnectionFactory {
	//Connection �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼���
	public static Connection getConnection() {// static ��ü ���ξ��� Ŭ������ ���ٰ��� (���� �޼���) 
										      // ������ : �� �޼��常 �����ָ� ��  , �������� �ڵ带 ���� ��Ŵ 
											  // ���� : ������������ ������. ��? ��� �������̽��� �Ѱ� �ƴ϶�.
											  // �����������ӿ�ũ : ��ü���⿡ �°� ���α׷��� �� �߻�ȭ �������̽�
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
		} catch (Exception e) {
			System.out.println("[����] Connection �ν��Ͻ��� ������ �� �����ϴ�.");
		}
		return con; // ���� ���� ��ȯ 
	}
	
	// JDBC ���� �ν��Ͻ��� ���޹޾� �����ϴ� �޼��� - �޼ҵ� �����ε� ���� - �޼ҵ� �����ε忡 ���� ������ 
	// 2. �θ�� �ڽ� �θ� �����ְ� �ڽİ� ���� - �������̵忡 ���� ������ 
	 
	public static void close(Connection con) {
		try {
			if(con!=null) con.close();
		}catch(SQLException e) {
			e.printStackTrace(); // ���ܰ� �߻������� statck �� �� ��ü�� ���� 
		}
	}
	
	public static void close(Connection con, Statement stmt) {
		try {
			if(con!=null) con.close();
			if(stmt!=null) stmt.close();
		}catch(SQLException e) {
			e.printStackTrace(); // ���ܰ� �߻������� statck �� �� ��ü�� ���� 
		}
	}
	
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}catch(SQLException e) {
			e.printStackTrace(); // ���ܰ� �߻������� statck �� �� ��ü�� ���� 
		}
	}
}
