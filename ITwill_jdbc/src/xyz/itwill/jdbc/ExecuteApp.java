package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteApp {

	public ExecuteApp() {
	}
	public static void main(String[] args) throws SQLException {
		Connection  con = ConnectionFactory.getConnection();

		/*
		Statement stmt = con.createStatement();	
		String sql1 = "update student set name = '임걱정' where no = 2000";
		int rows = stmt.executeUpdate(sql1);
		
		System.out.println("[결과] " + rows +"명의 학생정보를 변경 하였습니다.");

		System.out.println("==========================================");
		String sql2 = "select * from student order by no";
		ResultSet rs = stmt.executeQuery(sql2);
		
		while(rs.next()) {
			System.out.println("학번 = " + rs.getInt("no") + ", 이름 = " + rs.getString("name"));
		}
		ConnectionFactory.close(con,stmt,rs);
		*/
		
		// 위에는 입력해준 명령어가 명확하지가 않으면 
		// 실제 전달해야되는 명령어가 명확하다면 
		//웹 명확 - 회원가입 insert 회원탈퇴 - update 
		// erp 에서는 문제가 생겨서 삭제는 안함
		// 회원정보 내 정보 - select , 로그인 - select 
		// 회원정보 변경 update 
		
		
		
		// ------------------------------------전달되는 명령어가 정확하지 않다면 -----------------------------------
		Statement stmt = con.createStatement();	
		//int choice = 1;
		int choice = 2;
		
		String sql = "";
		if(choice==1) {
			sql = "update student set name='임꺽정' where no = 2000";
		} else {
			sql = "select * from student order by no";
		}
		//Statement.exectue(String sql) - dml , dcl 할때 : SQL명령을 전달하여 실행하는 메서드 - boolean 반환
		// => false 반환 : DML 명령(INSERT , UPDATE , DELETE)을 전달하여 실행한 경우의 반환값 
		// => true 반환 : DQL 명령(SELECT)을 전달하여 실행한 경우의 반환값 
		boolean result = stmt.execute(sql);
		
		ResultSet rs = null;
		if(result) { // DQL 명령이 전달되어 실행된 경우
			// Statement.getResultSet() : SELECT 명령의 실행결과(검색행)를 ResultSet 인스턴스로
			// 반환하는 메서드 , 전달되서 select 한 결과를 달라
			rs = stmt.getResultSet();
			
			while(rs.next()) {
				System.out.println("학번 = " + rs.getInt("no") + ", 이름 = " + rs.getString("name"));
			}
		} else { // DML 명령이 전달되어 실행된경우
			// Statement.getResultSet() : INSERT,UPDATE,DELETE 명령의 실행결과(조작행)의 갯수를
			// 정수값으로 반환하는 메서드 
			int rows = stmt.getUpdateCount();
			System.out.println("[결과] " + rows +"명의 학생정보를 변경 하였습니다.");
		}
		
		ConnectionFactory.close(con, stmt, rs);
	}
}
