package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.Statement;

// SUTDNET ���̺� ����� �л� ���� �� �й��� [2000] �� �л��� �̸��� �Ӳ������� �����ϰ�
// �ּҸ� [��õ�� ���̱�]�� �����ϴ� JDBC ���α׷� 
public class UpdateStudentApp {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		

}
