package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC ���α׷��� �ۼ��ϱ� ���� JDBC Driver ���� Ŭ������ ���Ե� ���̺귯���� ������Ʈ�� ���� ó��
// => Oracle JDBC Driver : ojdbc6.jar , ojdbc8.jar , ojdbc11.jar - JDK ���� ����

// STUDENT ���̺� : �й�(������-PRIMARY KEY) , �̸�(������) , ��ȭ��ȣ(������) , �ּ�(������) , �������

/*
create table student (
	    no NUMBER(4) primary key ,
	    name varchar2(30) ,
	    phone varchar2(20) ,
	    address varchar2(100) ,
	    birthday date
	)
*/
//STUDENT ���̺� �л�����(��)�� �����Ͽ� �����ϴ� JDBC ���α׷�
public class InsertStudentApp {
	public static void main(String[] args) {
		//JDBC ���� �ν��Ͻ��� �����ϱ� ���� ���������� try ���� �ܺο��� ����
		// =>   
		Connection con = null;
		Statement stmt = null;
		//1. OracleDriver Ŭ������ �о� �޸𸮿� ����
		// => OracleDriver Ŭ������ ������������ OracleDriver �ν��Ͻ��� �����Ͽ� DriverManager ����
		// Ŭ������ JDBC Driver  ��� ó�� - 1���� ����  
		// => DriverManager.registerDriver(new OracleDriver()) ����� 1���� ����
		// JDBC Driver : DriverManager Ŭ������ ��ϵ� �ټ��� Driver �ν��Ͻ�
		// => Driver �ν��Ͻ� : URL �ּҷ� ���ϴ� DBMS ������ ������ �� �ִ� ��� ����
		// DriverManager Ŭ���� : JDBC Driver�� �����ϱ� ���� ����� �����ϴ� Ŭ���� 
		// => DriverManager.registerDriver(Driver Driver) : Driver �ν��Ͻ��� JDBC Driver
		// Ŭ������ JDBC Driver�� ����ϴ� �޼��� 
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. DriverManager Ŭ������ ��ϵ� JDBC Driver�� �̿��Ͽ� DBMS ������ �����ϰ�
			// �������� (Connection �ν��Ͻ�)�� ��ȯ�޾� ���� 
			// DriverManager.getConnection(String url,String user,String password)
			// => DBMS ������ �����ϴ� �޼��� - ���� ������ Connection �ν��Ͻ� ��ȯ
			// => ���� ���н� SQLException �߻� 
			// SQLException : JDBC ���� �ν��Ͻ��� �޼��� ȣ�� �� �߻��Ǵ� ����
			// => DBMS ���� ���� ���� �Ǵ� SQL ��ɿ� ������ ������ �ִ� ��� ���� �߻� 
			// URL : ���ͳݿ� �����ϴ� �ڿ��� ǥ���ϱ� ���� �ּ�
			// => Protocol:ServerName:Port:Resource - ex) https://www.daum.net:80/index.html
			// Oracle DBMS ������ ���� JDBC URL 
			// ����) jdbc:oracle:thin:@ServerName:Port:SID
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String user = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url,user,pwd);
					
			// 3. ���ӵ� DBMS ������ SQL ����� �����ϱ� ���� Statement �ν��Ͻ��� ��ȯ�޾� ����
			stmt = con.createStatement(); // SQL ���� ������ ���� ��ü 
			
			// Connection �ν��Ͻ��� ���� SQL ����� ������ �� �ִ� Statement �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼���
			// 4. Statement �ν��Ͻ��� ���ӵ� DBMS ������ SQL ����� �����Ͽ� �����ϰ� ����� ������� 
			// ��ȯ�޾� ���� 
			// sStatement.executeUpdate(String sql) : INSERT , UPDATE , DELETE ����� ������ �����ϴ� �޼���
			// => �������� ����(int)�� ��ȯ = SQLException �߻� 
			String sql = "insert into student values (5000,'�̹���','010-5453-5678','���ֽ�','2011-01-13')";
			int rows = stmt.executeUpdate(sql); // ���ڵ��� �Ǽ� �ͽ�ťƮ
			
			// 5. SQL ����� ���� ����� ó�� - ���(���α׷�) �Ǵ� ��ȯ(�޼���)
			System.out.println("[�޼���]"+ rows + "���� �л������� �����Ͽ����ϴ�.");			
		} catch (ClassNotFoundException e) {
			System.out.println("[����]OracleDriver Ŭ������ ã�� �� �����ϴ�.");
		} catch (SQLException e ) {
			System.out.println("������ ���� ���� �Ͽ����ϴ�." + e.getMessage());
		} finally { // ���ܿ� ������� ����� ����� �ۼ��ϴ� ���� 
			// 6.JDBC ���� �ν��Ͻ��� ���� - close() �޼��� ȣ�� 
			try {
				// nullpointerexception �� �߻��� ���
				// if������ �̿��Ͽ� NullPointerException �߻� ����
				// NULL �� �ƴҋ��� close()�� ȣ�� 
				// ---����ߴ� ��� �ڿ� ����--- 
				if(stmt!=null) stmt.close(); // ���� ������ �ݾ��ش�. 
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
