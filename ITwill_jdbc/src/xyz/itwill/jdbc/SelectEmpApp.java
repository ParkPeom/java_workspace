package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// EMP 테이블에 저장된 모든 사원의 사원번호 , 사원이름 , 업무 , 급여를 급여순으로 내림차순 정렬
// 되도록 검색하여 출력하는 JDBC 프로그램

public class SelectEmpApp {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String id = "scott";
			String pwd = "tiger";
			String sql = "select empno , ename , job , sal from emp order by sal desc";
			
			conn = DriverManager.getConnection(url,id,pwd);
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String sal = rs.getString("sal");
						
				System.out.println("사원번호  : " + empno + " 이름 : " + ename 
						+ " 업무 : " + job + " 급여 : " + sal);
			}
		
		} catch (ClassNotFoundException e) {
			System.out.println("클래스를 찾을수 없습니다.");
		} catch (SQLException e) {
			System.out.println("SQL 에러");
		} finally {
			
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("SQL 에러");
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					System.out.println("SQL 에러");
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("SQL 에러");
				}
		}
		
		
		
	}
}
