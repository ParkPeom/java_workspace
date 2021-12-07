package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

//Ű����� �й��� �Է¹޾� STUDENT ���̺� ����� �л����� �� �Է� �й��� �л������� 
//�����ϴ� JDBC ���α׷� - ���� ���ν���(Stored Procedure) ȣ��
public class CallableStatementApp {
	public static void main(String[] args) throws IOException,SQLException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<�л����� ����>>");
		System.out.print("�й� �Է� >> ");
		int no=Integer.parseInt(in.readLine());
		System.out.println("==============================================================");
		Connection con=ConnectionFactory.getConnection();
		
		/*
		//DELETE_STUDENT ���� ���ν��� ���� ( �ڹ߰����� ���� DB�����ڵ��� ����) OCP,OCD
		CREATE OR REPLACE PROCEDURE DELETE_STUDENT(VNO IN NUMBER) IS
		BEGIN 
		    DELETE FROM STUDENT WHERE NO=VNO;
		    COMMIT;
		END;
		/
		*/
				
		//Connection.prepareCall(String sql) : SQL ����� ����� CallableStatement �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		// => CallableStatement �ν��Ͻ����� ���� ���ν����� ȣ���ϴ� SQL ��ɸ��� ����
		//CallableStatement �ν��Ͻ��� ����� ���� ���ν����� ȣ���ϴ� SQL ���
		// => ����){call ���ν�����({��|����},{��|����},...)}
		// => ? ��ȣ(InParameter) ��� ����
		String sql="{call delete_student(?)}"; // call ��ɾ�� ���ν��� ȣ�� �ʿ��Ѱ� ���� ����
		CallableStatement cstmt=con.prepareCall(sql);
		cstmt.setInt(1, no);
		
		//CallableStatement.execute() : CallableStatement �ν��Ͻ��� ����� SQL ����� �����Ͽ� �����ϴ� �޼ҵ�
		cstmt.execute(); // ? ���Ķ���� ��� �ؼ� execute() ��ɾ� ȣ�� 
						 // ���������� true ������ �ȵ����� false 
		
		System.out.println("[���]���� ���ν����� ����Ͽ� �л������� ���� �Ͽ����ϴ�.");
		
		ConnectionFactory.close(con, cstmt);
	}
}











