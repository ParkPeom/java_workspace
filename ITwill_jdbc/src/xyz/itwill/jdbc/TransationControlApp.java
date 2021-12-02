package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//JDBC 프로그램은 기본적으로 AutoCommit 기능이 활성화되어 있어 SQL 명령(DML)이 전달되어 
//실행될 경우 자동으로 커밋 처리 - stmt.executeUpdate(sql); 커밋도 같이 처리되어 롤백을 할수 없다
// => 프로그램 실행시 예외가 발생된 경우 예외 발생전 실행된 SQL 명령에 대한 롤백 처리 불가능 
//AutoCommit 기능을 비활성화 처리하여 프로그램이 정상적으로 실행된 경우 커밋 처리하고 예외가 
//발생된 경우 롤백처리하는 것을 권장

//STUDENT 테이블에서 학번이 [2000]인 학생의 이름을 [임꺽정]으로 변경하는 JDBC 프로그램
public class TransationControlApp {
	public TransationControlApp() {}

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement  stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
	
		System.out.print("바꾸실 no > ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("이름을 무엇으로 ?  > ");
		String name = sc.nextLine();
		
		ConnectionFactory.getConnection();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String id = "scott";
			String pwd = "tiger";
			String sql = "update student set name = ? where no = ?";
			con = DriverManager.getConnection(url, id, pwd);
			// Connection.setAutoCommit(boolean autocommit : AutoCommit 기능의 사용여부를 변경하는 메서드 
			// => false : AutoCommit 기능의 비활성화 , true : AutoCommit 기능의 활성화(기본)
			// 커밋보다 중요한건 롤백 이다. 
			//con.setAutoCommit(false);	
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, num);
		
			int row = pstmt.executeUpdate();		
			// Exception 메서드로  인위적인 예외 발생- > catch(Exception e) 
			// if(con != null) throw new Exception(); 
			if(row > 0) {
				System.out.println("값이 변경되었습니다.");
				SelectStudentApp ssd = new SelectStudentApp();
				ssd.selectStudent();
			} else {
				System.out.println("값이 변경되지 않았습니다.");	
			}
			// 정상적이면 커밋 
			//Connection.commit() : COMMIT 명령을 전달하는 메서드 
			con.commit(); 				
		} catch (ClassNotFoundException e1) {
			System.out.println("Oracle드라이버를 찾을수 없습니다.");
		} catch (SQLException e) { 
			System.out.println("[에러] JDBC 관련 오류 = " + e.getMessage());
		} catch (Exception e) { // 모든 예외 처리
			System.out.println("[에러]프로그램에 예기치 못한 오류가 발생 되었습니다.");
		} finally {
			try {
				// 어떤 예외가 발생되면 롤백 처리 시킴 (비정상적이면)
				// Connection.rollback() : ROLLBACK 명령을 전달하여 실행하는 메서드
				con.rollback();
			if(con != null) con.close();
			if(stmt != null) stmt.close();
		} catch(Exception e) {
			
			}
		}
	}
}
