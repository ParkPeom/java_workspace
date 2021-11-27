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
		System.out.println("\t=====로그인 시스템 입니다.=====\t");
		System.out.print("\t ★ 아이디를 입력해 주세요 > ");
	    String idcheck = sc.nextLine();
		System.out.print("\t ★ 비밀번호를 입력해 주세요 > ");
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
					System.out.println("\t-----로그인이 되셨습니다.-----\t");
						EmployDAO.menu();
					}
				System.out.println("비밀번호가 틀립니다.");
				} 
			}
		System.out.println("다시 입력해 주세요.");
		}
	}
}

