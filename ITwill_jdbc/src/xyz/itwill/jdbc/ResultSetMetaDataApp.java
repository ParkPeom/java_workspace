package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

// STUDENT ���̺� ����� ��� �л� �������� �˻��Ͽ� ����ϰ� �˻��� ����� ���� �÷������� ����ϴ� JDBC ���α׷� 
public class ResultSetMetaDataApp {
	public ResultSetMetaDataApp() {}
	public static void main(String[] args) throws SQLException { // jvm�� �� �޼��带 ȣ���Ѱ�����  �˾Ƽ� ó�� ���ְ� throws 
		Connection con = ConnectionFactory.getConnection();
		
		Statement stmt = con.createStatement();
		
		String sql = "select * from student order by no";
		//ResultSet : �˻������ �����ϱ� ���� �ν��Ͻ� 
		ResultSet rs = stmt.executeQuery(sql); 
		
		while(rs.next()) {
			System.out.print("�й� = " + rs.getInt("no") + ", �̸� = " + rs.getString("name"));
			System.out.println();
		}
		System.out.println("==============================================================");
		
		// ResultSet.getMetaData() : �˻����(ResultSet �ν��Ͻ�)�� ���� �ΰ����� ������ 
		// �����ϰ� �ִ�  ResultSetMetaData �ν��Ͻ��� ��ȯ�ϴ� �޼��� 
		// ��Ÿ�����ʹ� ���� ������ �Ҽ����� - ��ġ ���� ���� 
 		ResultSetMetaData rsmd = rs.getMetaData();
		
 		// ResultSetMetaData.getColumnCount() : �˻����� �÷� ������ ��ȯ�ϴ� �޼��� 
		int columnCount = rsmd.getColumnCount();
		
		System.out.println("�˻����� �÷� ���� = " + columnCount);
 		
		
		// ����Ŭ �ε����� 1���� ���� ������ ��ŭ
		// �ڹٴ� 0���� 
		for(int i=1;i<=columnCount;i++) {
			//ResultSetMetaData.getColumnLabel(int columnIndex) : columnIndex ��ġ�� �÷����� ��ȯ�ϴ� �޼ҵ�
			String columnLabel=rsmd.getColumnLabel(i);
			
			//ResultSetMetaData.isNullable(int columnIndex) : columnIndex ��ġ�� �÷��� ����\
			//NULL ��� ������(0 �Ǵ� 1)�� ��ȯ�ϴ� �޼ҵ�
			int isNull=rsmd.isNullable(i);
			String nullResult="NULL";
			//ResultSetMetaData.columnNoNulls : NULL�� ������� �ʴ� ���(0)
			if(isNull==ResultSetMetaData.columnNoNulls) {
				nullResult="NOT NULL";
			}
			
			//ResultSetMetaData.getColumnTypeName(int columnIndex) : columnIndex ��ġ�� �÷���
			//���� ����Ŭ �ڷ����� ��ȯ�ϴ� �޼ҵ�
			String columnTypeName=rsmd.getColumnTypeName(i);
			
			//ResultSetMetaData.getColumnDisplaySize(int columnIndex) : columnIndex ��ġ�� 
			//�÷��� ���� ���ũ�⸦ ��ȯ�ϴ� �޼ҵ�
			int columnDisplaySize=rsmd.getColumnDisplaySize(i);
			
			System.out.println("�÷��� = "+columnLabel);
			System.out.println("NULL ��� ���� = "+nullResult);
			System.out.println("�÷� �ڷ��� = "+columnTypeName);
			System.out.println("�÷� ���ũ�� = "+columnDisplaySize);
			System.out.println("==============================================================");
		}
		ConnectionFactory.close(con, stmt, rs);
 	}
}