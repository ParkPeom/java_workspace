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
			System.out.println("\t1. 회원가입");
			System.out.println("\t2. 조회");
			System.out.println("\t3. 수정");
			System.out.println("\t4. 삭제");
			System.out.println("\t5. 종료");
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
				System.out.println("다시 입력");
			}
		}
	}
	// 회원가입 
	public void addData() throws ClassNotFoundException, SQLException {
		// 회원가입
		System.out.print("추가 하실 학번을 입력해주세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("추가 하실 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "INSERT INTO STUDENT (NUM,NAME) VALUES(?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		
		PreparedStatement st = con.prepareStatement(sql); // 미리 시쿼문 채워넣어서 실행만 할수있게 준비
		// 쿼리문에 세팅할수 있는 능력이 포함됨
		st.setInt(1, num);
		st.setString(2, name);
		int result = st.executeUpdate(); // 재대로 추가되었으면 1 
		System.out.println("추가 완료 되었습니다.");
	}
	// 조회 
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
			System.out.printf("아이디 : %d 비번 : %d 이름 : %s  전화번호 : %d \n" , num , name);
		}
	}
	
	// 수정
	public void updateData() throws ClassNotFoundException, SQLException {

		System.out.print("학번을 입력해 주세요 > ");
		int num = sc.nextInt();
		sc.nextLine();
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "UPDATE STUDENT SET NAME=? WHERE NUM=? ";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		PreparedStatement st = con.prepareStatement(sql); // 미리 시쿼문 채워넣어서 실행만 할수있게 준비
		// 쿼리문에 세팅할수 있는 능력이 포함됨
		System.out.println("바꿀 이름을 입력해주세요 ");
		String name = sc.nextLine();
		st.setString(1, name);
		st.setInt(2, num);
		
		
		int result = st.executeUpdate(); // 재대로 추가되었으면 1 
		System.out.println("추가 완료 되었습니다.");
	}
	
	// 삭제
	public void deleteData() throws ClassNotFoundException, SQLException {
		System.out.print("삭제하실 학번이 무엇입니까 ? ");
		int num = sc.nextInt();
		sc.nextLine();
		
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "DELETE STUDENT WHERE NUM = ?";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		
		PreparedStatement st = con.prepareStatement(sql); // 미리 시쿼문 채워넣어서 실행만 할수있게 준비
		// 쿼리문에 세팅할수 있는 능력이 포함됨
		st.setInt(1, num);
		st.executeUpdate(); 
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new Student().menu();
	}
}
