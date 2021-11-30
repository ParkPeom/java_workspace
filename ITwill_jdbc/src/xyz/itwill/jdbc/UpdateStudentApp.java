package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.Statement;

// SUTDNET 테이블에 저장된 학생 정보 중 학번이 [2000] 인 학생의 이름을 임꺽정으로 변경하고
// 주소를 [부천시 원미구]로 변경하는 JDBC 프로그램 
public class UpdateStudentApp {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		

}
