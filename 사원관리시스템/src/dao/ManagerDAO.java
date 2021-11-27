package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dto.ManagerDTO;

public class ManagerDAO {
	
	
	public ManagerDAO() {}
	
	public static void addManager(ArrayList<ManagerDTO> arr) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "INSERT INTO MANAGER (ID,PWD,NAME,TEL) VALUES(?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		PreparedStatement st = con.prepareStatement(sql); // �̸� ������ ä���־ ���ุ �Ҽ��ְ� �غ�
		
		// �������� �����Ҽ� �ִ� �ɷ��� ���Ե�
		for(int i = 0; i < arr.size(); i++ ) {
			st.setString(1, arr.get(i).getId());
			st.setString(2, arr.get(i).getPwd());
			st.setString(3, arr.get(i).getName());
			st.setString(4, arr.get(i).getTel());
		}
		int result = st.executeUpdate(); // ���� �߰��Ǿ����� 1 
		System.out.println("\t�߰� �Ϸ� �Ǿ����ϴ�.");
		}
	}
