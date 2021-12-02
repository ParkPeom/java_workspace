package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteApp {

	public ExecuteApp() {
	}
	public static void main(String[] args) throws SQLException {
		Connection  con = ConnectionFactory.getConnection();

		/*
		Statement stmt = con.createStatement();	
		String sql1 = "update student set name = '�Ӱ���' where no = 2000";
		int rows = stmt.executeUpdate(sql1);
		
		System.out.println("[���] " + rows +"���� �л������� ���� �Ͽ����ϴ�.");

		System.out.println("==========================================");
		String sql2 = "select * from student order by no";
		ResultSet rs = stmt.executeQuery(sql2);
		
		while(rs.next()) {
			System.out.println("�й� = " + rs.getInt("no") + ", �̸� = " + rs.getString("name"));
		}
		ConnectionFactory.close(con,stmt,rs);
		*/
		
		// ������ �Է����� ��ɾ ��Ȯ������ ������ 
		// ���� �����ؾߵǴ� ��ɾ ��Ȯ�ϴٸ� 
		//�� ��Ȯ - ȸ������ insert ȸ��Ż�� - update 
		// erp ������ ������ ���ܼ� ������ ����
		// ȸ������ �� ���� - select , �α��� - select 
		// ȸ������ ���� update 
		
		
		
		// ------------------------------------���޵Ǵ� ��ɾ ��Ȯ���� �ʴٸ� -----------------------------------
		Statement stmt = con.createStatement();	
		//int choice = 1;
		int choice = 2;
		
		String sql = "";
		if(choice==1) {
			sql = "update student set name='�Ӳ���' where no = 2000";
		} else {
			sql = "select * from student order by no";
		}
		//Statement.exectue(String sql) - dml , dcl �Ҷ� : SQL����� �����Ͽ� �����ϴ� �޼��� - boolean ��ȯ
		// => false ��ȯ : DML ���(INSERT , UPDATE , DELETE)�� �����Ͽ� ������ ����� ��ȯ�� 
		// => true ��ȯ : DQL ���(SELECT)�� �����Ͽ� ������ ����� ��ȯ�� 
		boolean result = stmt.execute(sql);
		
		ResultSet rs = null;
		if(result) { // DQL ����� ���޵Ǿ� ����� ���
			// Statement.getResultSet() : SELECT ����� ������(�˻���)�� ResultSet �ν��Ͻ���
			// ��ȯ�ϴ� �޼��� , ���޵Ǽ� select �� ����� �޶�
			rs = stmt.getResultSet();
			
			while(rs.next()) {
				System.out.println("�й� = " + rs.getInt("no") + ", �̸� = " + rs.getString("name"));
			}
		} else { // DML ����� ���޵Ǿ� ����Ȱ��
			// Statement.getResultSet() : INSERT,UPDATE,DELETE ����� ������(������)�� ������
			// ���������� ��ȯ�ϴ� �޼��� 
			int rows = stmt.getUpdateCount();
			System.out.println("[���] " + rows +"���� �л������� ���� �Ͽ����ϴ�.");
		}
		
		ConnectionFactory.close(con, stmt, rs);
	}
}
