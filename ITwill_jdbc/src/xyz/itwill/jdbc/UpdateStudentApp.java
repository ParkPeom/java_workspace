package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

// SUTDNET ���̺� ����� �л� ���� �� �й��� [2000] �� �л��� �̸��� �Ӳ������� �����ϰ�
// �ּҸ� [��õ�� ���̱�]�� �����ϴ� JDBC ���α׷� 
public class UpdateStudentApp {

	public static void main(String[] args) throws SQLException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		ArrayList<StudentDTO> student = new ArrayList<StudentDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			System.out.print("���� �ϰ� �� �ϴ� �й� > ");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.print("�̸��� �������� ? > ");
			String name = sc.nextLine();
			System.out.print("�ּ� �� ��������  ? ");
			String address = sc.nextLine();
			
					
			// url = jdbc : ����Ŭ�� : ����(�����ϰ�����: @ �����̸� : ��Ʈ��ȣ : SID 
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String id = "scott";
			String pwd ="tiger";
			String sql = "UPDATE STUDENT SET NAME = ? , ADDRESS = ?  WHERE NO = ? ";
			
			
			// 1.Ŭ������ �޸𸮿� �ε��Ѵ�. ����̹� �ε� - jdbc ��� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2 . DriverManager ��  ���� ������ �����ϴ�.
			con = DriverManager.getConnection(url,id,pwd);
		
			// 3 preparedStatement �غ�� ���� ? �� ���� ���־��� ���� - �ݺ� ���忡 ���� 
			// 3. ���� ���������� ���� statement ����
			pstmt= con.prepareStatement(sql);
			
			// 4. set ? ������ 
			pstmt.setString(1, name);
			pstmt.setString(2, address);
			pstmt.setInt(3, num);
			
			// 5 ���� �� ����� ���ڵ��  
			// ��ȯ��� ������ ��ȯ�Ѵ�.
			int rs = pstmt.executeUpdate(); 
			if(rs == 1) {
				System.out.println("����Ǿ����ϴ�.");
			} else {
				System.out.println("������� �ʾҽ��ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(Exception e) {}
			
		}
	}
}
