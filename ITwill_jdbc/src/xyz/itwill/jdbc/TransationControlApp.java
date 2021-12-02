package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//JDBC ���α׷��� �⺻������ AutoCommit ����� Ȱ��ȭ�Ǿ� �־� SQL ���(DML)�� ���޵Ǿ� 
//����� ��� �ڵ����� Ŀ�� ó�� - stmt.executeUpdate(sql); Ŀ�Ե� ���� ó���Ǿ� �ѹ��� �Ҽ� ����
// => ���α׷� ����� ���ܰ� �߻��� ��� ���� �߻��� ����� SQL ��ɿ� ���� �ѹ� ó�� �Ұ��� 
//AutoCommit ����� ��Ȱ��ȭ ó���Ͽ� ���α׷��� ���������� ����� ��� Ŀ�� ó���ϰ� ���ܰ� 
//�߻��� ��� �ѹ�ó���ϴ� ���� ����

//STUDENT ���̺��� �й��� [2000]�� �л��� �̸��� [�Ӳ���]���� �����ϴ� JDBC ���α׷�
public class TransationControlApp {
	public TransationControlApp() {}

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement  stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
	
		System.out.print("�ٲٽ� no > ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("�̸��� �������� ?  > ");
		String name = sc.nextLine();
		
		ConnectionFactory.getConnection();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String id = "scott";
			String pwd = "tiger";
			String sql = "update student set name = ? where no = ?";
			con = DriverManager.getConnection(url, id, pwd);
			// Connection.setAutoCommit(boolean autocommit : AutoCommit ����� ��뿩�θ� �����ϴ� �޼��� 
			// => false : AutoCommit ����� ��Ȱ��ȭ , true : AutoCommit ����� Ȱ��ȭ(�⺻)
			// Ŀ�Ժ��� �߿��Ѱ� �ѹ� �̴�. 
			//con.setAutoCommit(false);	
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, num);
		
			int row = pstmt.executeUpdate();		
			// Exception �޼����  �������� ���� �߻�- > catch(Exception e) 
			// if(con != null) throw new Exception(); 
			if(row > 0) {
				System.out.println("���� ����Ǿ����ϴ�.");
				SelectStudentApp ssd = new SelectStudentApp();
				ssd.selectStudent();
			} else {
				System.out.println("���� ������� �ʾҽ��ϴ�.");	
			}
			// �������̸� Ŀ�� 
			//Connection.commit() : COMMIT ����� �����ϴ� �޼��� 
			con.commit(); 				
		} catch (ClassNotFoundException e1) {
			System.out.println("Oracle����̹��� ã���� �����ϴ�.");
		} catch (SQLException e) { 
			System.out.println("[����] JDBC ���� ���� = " + e.getMessage());
		} catch (Exception e) { // ��� ���� ó��
			System.out.println("[����]���α׷��� ����ġ ���� ������ �߻� �Ǿ����ϴ�.");
		} finally {
			try {
				// � ���ܰ� �߻��Ǹ� �ѹ� ó�� ��Ŵ (���������̸�)
				// Connection.rollback() : ROLLBACK ����� �����Ͽ� �����ϴ� �޼���
				con.rollback();
			if(con != null) con.close();
			if(stmt != null) stmt.close();
		} catch(Exception e) {
			
			}
		}
	}
}
