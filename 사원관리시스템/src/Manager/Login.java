package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import dao.EmployDAO;
import dto.EmployDTO;
import dto.ManagerDTO;

public class Login {

	public Login() { }

	public static void loginSystem() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		
	while(true) {
		System.out.println("\t=====�α��� �ý��� �Դϴ�.=====\t");
		System.out.print("\t �� ���̵� �Է��� �ּ��� > ");
	    String idcheck = sc.nextLine();
		System.out.print("\t �� ��й�ȣ�� �Է��� �ּ��� > ");
		String pwdcheck = sc.nextLine();
				
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		
		String sql = "SELECT * FROM MANAGER";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			if(idcheck.equals(rs.getString("id"))) {
				if(pwdcheck.equals(rs.getString("pwd"))) {
					System.out.println("\t-----�α����� �Ǽ̽��ϴ�.-----\t");
						EmployDAO.menu();
					}
				System.out.println("��й�ȣ�� Ʋ���ϴ�.");
				} 
			}
		System.out.println("�ٽ� �Է��� �ּ���.");
		}
	}
}

