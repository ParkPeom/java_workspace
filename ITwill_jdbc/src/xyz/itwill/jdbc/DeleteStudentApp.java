package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Student ���̺� ����� �л����� �� �й��� [] 
public class DeleteStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1522:orcl";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			stmt=con.createStatement();
			
			String sql="delete from student where no=4000";
			int rows=stmt.executeUpdate(sql);
			
			if(rows>0) {//�������� ������ ���
				System.out.println("[�޼���]"+rows+"���� �л������� ���� �Ͽ����ϴ�.");
			} else {//�������� �������� ���� ���
				System.out.println("[�޼���]�����ϰ��� �ϴ� �й��� �л������� �������� �ʽ��ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("[����]OracleDriver Ŭ������ ã�� �� �����ϴ�.");
		} catch (SQLException e) {
			System.out.println("[����]JDBC ���� ���� = "+e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (Exception e) {}
		}
	}
}
