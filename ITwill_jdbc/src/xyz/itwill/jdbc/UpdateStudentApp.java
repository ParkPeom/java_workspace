package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

// SUTDNET 테이블에 저장된 학생 정보 중 학번이 [2000] 인 학생의 이름을 임꺽정으로 변경하고
// 주소를 [부천시 원미구]로 변경하는 JDBC 프로그램 
public class UpdateStudentApp {

	public static void main(String[] args) throws SQLException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		ArrayList<StudentDTO> student = new ArrayList<StudentDTO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			System.out.print("변경 하고 자 하는 학번 > ");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.print("이름을 무엇으로 ? > ");
			String name = sc.nextLine();
			System.out.print("주소 는 무엇으로  ? ");
			String address = sc.nextLine();
			
					
			// url = jdbc : 오라클씀 : 얇은(간단하게접속: @ 서버이름 : 포트번호 : SID 
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String id = "scott";
			String pwd ="tiger";
			String sql = "UPDATE STUDENT SET NAME = ? , ADDRESS = ?  WHERE NO = ? ";
			
			
			// 1.클래스를 메모리에 로딩한다. 드라이버 로딩 - jdbc 등록 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2 . DriverManager 로  서버 접속이 가능하다.
			con = DriverManager.getConnection(url,id,pwd);
		
			// 3 preparedStatement 준비된 쿼리 ? 에 대입 자주쓰는 문장 - 반복 문장에 쓰임 
			// 3. 서버 접속정보에 따라 statement 만듬
			pstmt= con.prepareStatement(sql);
			
			// 4. set ? 설정함 
			pstmt.setString(1, name);
			pstmt.setString(2, address);
			pstmt.setInt(3, num);
			
			// 5 실행 한 결과를 레코드로  
			// 반환결과 개수를 반환한다.
			int rs = pstmt.executeUpdate(); 
			if(rs == 1) {
				System.out.println("변경되었습니다.");
			} else {
				System.out.println("변경되지 않았습니다.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
	
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch(Exception e) {}
			
		}
	}
}
