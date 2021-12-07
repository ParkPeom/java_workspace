package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// EMP ���̺� ����� ��� ����� �����ȣ , ����̸� , ���� , �޿��� �޿������� �������� ����
// �ǵ��� �˻��Ͽ� ����ϴ� JDBC ���α׷�

public class SelectEmpApp {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String id = "scott";
			String pwd = "tiger";
			String sql = "select empno , ename , job , sal from emp order by sal desc";
			
			conn = DriverManager.getConnection(url,id,pwd);
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String sal = rs.getString("sal");
						
				System.out.println("�����ȣ  : " + empno + " �̸� : " + ename 
						+ " ���� : " + job + " �޿� : " + sal);
			}
		
		} catch (ClassNotFoundException e) {
			System.out.println("Ŭ������ ã���� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("SQL ����");
		} finally {
			
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("SQL ����");
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println("SQL ����");
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("SQL ����");
				}
		}
		
		
		
	}
}
