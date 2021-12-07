package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Statement : ���ӵ� DBMS ������ SQL ����� �����Ͽ� ����� ����� ��ȯ�ϴ� ����� �����ϴ� �ν��Ͻ�
// ���� : �ϳ��� Statement �ν��Ͻ��� �ټ��� SQL ����� �����Ͽ� ���� ����
// ���� : SQL ��ɿ� Java �������� �����ϰ��� �� ��� ���ڿ� ���� ��� �̿�
// => ���ڿ� ������ �̿��� ��� ������ �� ���������� ȿ������ ���� 
// => InSQL ��ŷ ���(�� ��� �κ����� SQL ����� �����ϴ� ���)�� ���ȼ��� ����ϴ� 

public class StatementApp {
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		//Ű����� �л������� �Է¹޾� STUDENT ���̺� �����Ͽ� �����ϰ� ����� ���
		//�л������� �˻��Ͽ� ����ϴ� JDBC ���α׷� 
		
		//Ű����� �л������� �Է¹ޱ� ���� �Է½�Ʈ�� ���� 
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.in - 1����Ʈ��
		InputStreamReader 2����Ʈ �ѱ��ڸ�
		BufferedReader 2����Ʈ�� 
		
		//Ű����� �л������� �Է¹޾� ������ ����
		System.out.println("<<�л����� �Է�>>\n");
		System.err.print(" �й� �Է� >>");
		// Integer.parseInt(String s) : ���ڿ��� ���޹޾� ���������� ��ȯ�Ͽ� ��ȯ�ϴ� �޼���
		//=>NumberFormatException �߻� - ���޹��� ���ڿ��� ������ ������ �ƴ� ��� �߻�) �߻� ����
		// '���� x "123" -> 123 
		int num = Integer.parseInt(br.readLine());
		System.out.print("�̸� �Է� >> ");
		String name = br.readLine();
		System.out.print("��ȭ��ȣ �Է� >> ");
		String phone = br.readLine();
		System.out.print("�ּ� �Է� >> ");
		String address = br.readLine();
		System.out.print("������� �Է� >> ");
		String birthday = br.readLine();
		System.out.println("============================================");
		//Ű����� �Էµ� �л������� STUDENT ���̺��� ������ �����Ͽ� ����
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		
		String sql1 = "insert into student values('"+num+"','"+name+"',"
				+ phone + ",'"+address+"','"+birthday+"')";
		int rows = stmt.executeUpdate(sql1);
		
		System.out.println("[���]" + rows +"���� �л������� ���� �Ͽ����ϴ�.");
		System.out.println("========================================");
		// STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� ���
		String sql2 = "select * from student order by no";
		ResultSet rs = stmt.executeQuery(sql2);
		
		System.out.println("<<�л���� ���>>");
		while(rs.next()) {
			System.out.println("�й� = " + rs.getInt("no") 
			+ "�̸� = " + rs.getString("name"));
		}
		
		ConnectionFactory.close(con,stmt,rs);
		System.out.println("=========================================");
		*/
		//Ű����� �̸��� �Է¹޾� STUDENT ���̺� ����� �л����� �� �Է� �̸��� ���� 
		//�̸��� �л������� �˻��Ͽ� ����ϴ� JDBC ���α׷� 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Ű����� �̸��� �Է¹޾� ����
		System.out.println("<<�л����� �˻�>>");
		System.out.print("�̸� �Է� >> ");
		String name = br.readLine();
		System.out.println("=================================================================");
		//STUDENT ���̺� ����� �л� ���� �� �Է� �̸��� ���� �̸��� �л������� �˻��Ͽ� ���
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		
		String sql = "select * from student where name = '" + name + "' order by no";
		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println("<<�˻� ��� ���>>");
		if(rs.next()) {
			do {
				System.out.println("�й� = " + rs.getInt("no") + " , �̸� = " + rs.getString("name"));
			}while(rs.next());
		} else {
			System.out.println("�˻��� �л������� �����ϴ�.");
		}
	
		// ' or '1'='1 �� �Է��ϸ� ��ü ��� 
		// ' or '1'='1 
		// name = '' + or '1'='1' �̸��̾��ų� 1 = 1 ������ ���� �� �̱� ������ ��� �л����� �˻��� 
		// ���ǽ��� �Ϻκ��� ���� �����ϸ� ������ ���� ���� ��Ÿ�� 
		// �� �۾��� ���� �ƴ϶� Ű����� �Է��Ѱ� �ƴ϶� sql������� ���Ե� 
		// ���ǽ��� �Ϻΰ� �Ǹ鼭 ���������� ���� �Ǽ� �˻��� �ȴ�. 
		// ���� ������ ���� ŉ�濡 ���������� �����Ҽ��ִ�. 
		
		// �̰ɾ��°� �ټ��� sql ����� �����Ͽ� ���� ���������� ����� �ϳ��� �����ҋ� ������ ����
		//
	}
}
