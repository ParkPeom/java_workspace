package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//DEPT 테이블에 저장된 모든 부서정보를 출력하는 JDBC 프로그램
public class ConnectionFactoryApp {

	public ConnectionFactoryApp() {
	
	}
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 드라이버 로딩 , 커넥션은 static 메서드로 불러옴 return Connection 
			con = ConnectionFactory.getConnection();
			
			stmt =  con.createStatement();
			
			String sql = "select * from dept order by deptno";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { // 다음 행으로 이동한다. 
				System.out.println("부서번호 = " + rs.getString("deptno")
				+ ", 부서이름 = " + rs.getString("dname")
				+ " ,부서위치 = "+ rs.getString("loc"));
			}
		} catch(SQLException e) {
			System.out.println("[에러]SQL 오류 = " + e.getMessage());
		} finally {
			ConnectionFactory.close(con,stmt,rs);
		}
	}
}
