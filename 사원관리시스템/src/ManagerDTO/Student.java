package ManagerDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
	Scanner sc = new Scanner(System.in);
	
	public Student() {
		
	}
	

	public void menu() throws ClassNotFoundException, SQLException {
		
	endloop : while(true) {
			System.out.println("-----------------------------------------");
			System.out.println("\t1. ȸ������");
			System.out.println("\t2. ��ȸ");
			System.out.println("\t3. ����");
			System.out.println("\t4. ����");
			System.out.println("\t5. ����");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 0:
			
			case 1:
				addData();
				break;
			case 2:
				selectData();
				break;
			case 3:
				updateData();
				break;
			case 4:
				deleteData();
				break;
			case 5:
				break endloop;
			default :
				System.out.println("�ٽ� �Է�");
			}
		}
	}
	// ȸ������ 
	public void addData() throws ClassNotFoundException, SQLException {
		// ȸ������
		System.out.print("�߰� �Ͻ� �й��� �Է����ּ��� : ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("�߰� �Ͻ� �̸��� �Է����ּ��� : ");
		String name = sc.nextLine();
		
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "INSERT INTO STUDENT (NUM,NAME) VALUES(?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		
		PreparedStatement st = con.prepareStatement(sql); // �̸� ������ ä���־ ���ุ �Ҽ��ְ� �غ�
		// �������� �����Ҽ� �ִ� �ɷ��� ���Ե�
		st.setInt(1, num);
		st.setString(2, name);
		int result = st.executeUpdate(); // ���� �߰��Ǿ����� 1 
		System.out.println("�߰� �Ϸ� �Ǿ����ϴ�.");
	}
	// ��ȸ 
	public void selectData() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "SELECT * FROM STUDENT ORDER BY NUM ASC";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int num = rs.getInt("NUM"); 
			String name = rs.getString("NAME");
			System.out.printf("���̵� : %d ��� : %d �̸� : %s  ��ȭ��ȣ : %d \n" , num , name);
		}
	}
	
	// ����
	public void updateData() throws ClassNotFoundException, SQLException {

		System.out.print("�й��� �Է��� �ּ��� > ");
		int num = sc.nextInt();
		sc.nextLine();
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "UPDATE STUDENT SET NAME=? WHERE NUM=? ";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		PreparedStatement st = con.prepareStatement(sql); // �̸� ������ ä���־ ���ุ �Ҽ��ְ� �غ�
		// �������� �����Ҽ� �ִ� �ɷ��� ���Ե�
		System.out.println("�ٲ� �̸��� �Է����ּ��� ");
		String name = sc.nextLine();
		st.setString(1, name);
		st.setInt(2, num);
		
		
		int result = st.executeUpdate(); // ���� �߰��Ǿ����� 1 
		System.out.println("�߰� �Ϸ� �Ǿ����ϴ�.");
	}
	
	// ����
	public void deleteData() throws ClassNotFoundException, SQLException {
		System.out.print("�����Ͻ� �й��� �����Դϱ� ? ");
		int num = sc.nextInt();
		sc.nextLine();
		
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "DELETE STUDENT WHERE NUM = ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		
		PreparedStatement st = con.prepareStatement(sql); // �̸� ������ ä���־ ���ุ �Ҽ��ְ� �غ�
		// �������� �����Ҽ� �ִ� �ɷ��� ���Ե�
		st.setInt(1, num);
		st.executeUpdate(); 
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new Student().menu();
	}
}
