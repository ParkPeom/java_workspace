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
		PreparedStatement st = con.prepareStatement(sql); // 미리 시쿼문 채워넣어서 실행만 할수있게 준비
		
		// 쿼리문에 세팅할수 있는 능력이 포함됨
		for(int i = 0; i < arr.size(); i++ ) {
			st.setString(1, arr.get(i).getId());
			st.setString(2, arr.get(i).getPwd());
			st.setString(3, arr.get(i).getName());
			st.setString(4, arr.get(i).getTel());
		}
		int result = st.executeUpdate(); // 재대로 추가되었으면 1 
		System.out.println("\t추가 완료 되었습니다.");
		}
	}
