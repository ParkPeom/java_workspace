package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Student 테이블에 저장된 학생정보 중 학번이 [] 
public class DeleteStudentApp {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1522:orcl";
			String user="scott";
			String password="tiger";
			con=DriverManager.getConnection(url, user, password);
			
			stmt=con.createStatement();
			
			String sql="delete from student where no=4000";
			int rows=stmt.executeUpdate(sql);
			
			if(rows>0) {//삭제행이 존재할 경우
				System.out.println("[메세지]"+rows+"명의 학생정보를 삭제 하였습니다.");
			} else {//삭제행이 존재하지 않을 경우
				System.out.println("[메세지]삭제하고자 하는 학번의 학생정보가 존재하지 않습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			} catch (Exception e) {}
		}
	}
}
