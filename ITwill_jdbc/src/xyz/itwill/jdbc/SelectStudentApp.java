package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SelectStudentApp {
	
	
	public void selectStudent() {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String url="jdbc:oracle:thin:@localhost:1522:orcl";
			String user="scott";
			String password="tiger";
			con = DriverManager.getConnection(url, user, password);
			
			stmt = con.createStatement();
			
			String sql="select * from student order by no";
			//Statement.executeQuery(String sql) : SQL ���(SELECT)�� �����ϴ� �޼ҵ�
			// => SELECT ����� �����Ͽ� �˻��� ���� ResultSet �ν��Ͻ��� �����Ͽ� ��ȯ
			//ResultSet : �˻������ ���̺�(2���� �迭) �������� ������ �ν��Ͻ�
			rs = stmt.executeQuery(sql); 
			
			//ResultSet �ν��Ͻ��� ����� �˻����� ������� ó���ϱ� ���� Ŀ��(Cursor) ����
			// => ResultSet Ŀ���� ���� BOF(Before Of File) ������ ��ġ
			//ResultSet.next() : ResultSet Ŀ���� ���������� �̵��ϴ� �޼ҵ� - boolean ��ȯ
			// => false ��ȯ : ResultSet Ŀ�� ��ġ�� ó������ ���� ����� ��ȯ�� - EOF(End Of File)
			// => true ��ȯ : ResultSet Ŀ�� ��ġ�� ó������ �ִ� ����� ��ȯ��
		
			// if���� ���ؼ� 
			if(rs.next()) { // ResultSet Ŀ���� ���������� �̵��Ͽ� ó������ �����ϴ� ���
				// System.out.println("[�޼���]�˻��� �л������� �ֽ��ϴ�.");
				// ù��° ���� �������� �ʴ� do-while��
				// �ݺ����� �̿��Ͽ� ResultSet Ŀ���� ���������� �̵��Ͽ� ���� �ϳ��� �ݺ� ó���Ѵ�.
				// =>  ResultSet Ŀ�� ��ġ�� ó������ ���� �ݺ��� ���� 
				// while(rs.next()) { if ������ �̹� ���������� �ѱ�� while������ �� �̵��ϸ� ù���� ���� ������
				// �׷��� do while���� ����. 
				do {
					// ResultSet Ŀ�� ��ġ�� ó���࿡ �÷����� ��ȯ�޾� ���� 
					// ResultSet.getXXX(int columnIndex) �Ǵ� ResultSet.getXXX(String columnLabel)
					// => ResultSet Ŀ�� ��ġ�� ó���࿡ �÷����� ��ȯ�ϴ� �޼���
					// => xxx�� �÷����� ��ȯ�ޱ� ���� Java �ڷ����� ǥ��  
					// => columnIndex : �˻����� �÷� ��ġ�� (OracleIndex : 1���� 1�� �����Ǵ� ������)
					// => columnLabel : �˻��࿡ ���� �÷���(��Ī)
					// int no = rs.nextInt(1);
					int no = rs.getInt("no"); // �÷��� ���� ����Ȱ� - �÷����� ���°� ���� ��������
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					//Date birthday = rs.getDate("birthday"); // java.sql.date
					//ResultSet Ŀ�� ��ġ�� ó���࿡ �÷����� ����Ŭ �ڷ����� ������� 
					//getString() �޼��带 ȣ���Ͽ� Date�� ���ڿ��� ��ȯ ����
					// ��ȯ�޾Ƽ� ó���Ϸ��� �ϳ��ϳ��� ó���ϴ°� ���� 
					String birthday = rs.getString("birthday"); // 1995-02-23 00:00:00.0 
																// �ú��ʸ� ���� ������ subString
					
					System.out.println("�й� = " + no);
					System.out.println("�̸� = " + name);
					System.out.println("��ȭ��ȣ = " + phone);
					System.out.println("�ּ� = " + address);
					System.out.println("������� = " + birthday.substring(0,10)); // 0 ~ 10������ ���� 
					System.out.println("==================================");
				} while(rs.next());
			} else {
				System.out.println("[�޼���]�˻��� �л������� �����ϴ�.");
				}
			} catch (SQLException e) {
				System.out.println("[����]JDBC ���� ���� = "+e.getMessage());
			} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(con!=null) con.close();
				} catch (Exception e) {}
			}
	}
	
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String url="jdbc:oracle:thin:@localhost:1522:orcl";
			String user="scott";
			String password="tiger";
			con = DriverManager.getConnection(url, user, password);
			
			stmt = con.createStatement();
			
			String sql="select * from student order by no";
			//Statement.executeQuery(String sql) : SQL ���(SELECT)�� �����ϴ� �޼ҵ�
			// => SELECT ����� �����Ͽ� �˻��� ���� ResultSet �ν��Ͻ��� �����Ͽ� ��ȯ
			//ResultSet : �˻������ ���̺�(2���� �迭) �������� ������ �ν��Ͻ�
			rs = stmt.executeQuery(sql); 
			
			//ResultSet �ν��Ͻ��� ����� �˻����� ������� ó���ϱ� ���� Ŀ��(Cursor) ����
			// => ResultSet Ŀ���� ���� BOF(Before Of File) ������ ��ġ
			//ResultSet.next() : ResultSet Ŀ���� ���������� �̵��ϴ� �޼ҵ� - boolean ��ȯ
			// => false ��ȯ : ResultSet Ŀ�� ��ġ�� ó������ ���� ����� ��ȯ�� - EOF(End Of File)
			// => true ��ȯ : ResultSet Ŀ�� ��ġ�� ó������ �ִ� ����� ��ȯ��
		
			// if���� ���ؼ� 
			if(rs.next()) { // ResultSet Ŀ���� ���������� �̵��Ͽ� ó������ �����ϴ� ���
				// System.out.println("[�޼���]�˻��� �л������� �ֽ��ϴ�.");
				// ù��° ���� �������� �ʴ� do-while��
				// �ݺ����� �̿��Ͽ� ResultSet Ŀ���� ���������� �̵��Ͽ� ���� �ϳ��� �ݺ� ó���Ѵ�.
				// =>  ResultSet Ŀ�� ��ġ�� ó������ ���� �ݺ��� ���� 
				// while(rs.next()) { if ������ �̹� ���������� �ѱ�� while������ �� �̵��ϸ� ù���� ���� ������
				// �׷��� do while���� ����. 
				do {
					// ResultSet Ŀ�� ��ġ�� ó���࿡ �÷����� ��ȯ�޾� ���� 
					// ResultSet.getXXX(int columnIndex) �Ǵ� ResultSet.getXXX(String columnLabel)
					// => ResultSet Ŀ�� ��ġ�� ó���࿡ �÷����� ��ȯ�ϴ� �޼���
					// => xxx�� �÷����� ��ȯ�ޱ� ���� Java �ڷ����� ǥ��  
					// => columnIndex : �˻����� �÷� ��ġ�� (OracleIndex : 1���� 1�� �����Ǵ� ������)
					// => columnLabel : �˻��࿡ ���� �÷���(��Ī)
					// int no = rs.nextInt(1);
					int no = rs.getInt("no"); // �÷��� ���� ����Ȱ� - �÷����� ���°� ���� ��������
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					//Date birthday = rs.getDate("birthday"); // java.sql.date
					//ResultSet Ŀ�� ��ġ�� ó���࿡ �÷����� ����Ŭ �ڷ����� ������� 
					//getString() �޼��带 ȣ���Ͽ� Date�� ���ڿ��� ��ȯ ����
					// ��ȯ�޾Ƽ� ó���Ϸ��� �ϳ��ϳ��� ó���ϴ°� ���� 
					String birthday = rs.getString("birthday"); // 1995-02-23 00:00:00.0 
																// �ú��ʸ� ���� ������ subString
					
					System.out.println("�й� = " + no);
					System.out.println("�̸� = " + name);
					System.out.println("��ȭ��ȣ = " + phone);
					System.out.println("�ּ� = " + address);
					System.out.println("������� = " + birthday.substring(0,10)); // 0 ~ 10������ ���� 
					System.out.println("==================================");
				} while(rs.next());
			} else {
				System.out.println("[�޼���]�˻��� �л������� �����ϴ�.");
				}
			} catch (SQLException e) {
				System.out.println("[����]JDBC ���� ���� = "+e.getMessage());
			} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(con!=null) con.close();
				} catch (Exception e) {}
			}
		}
	}


