package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

//키보드로 학번을 입력받아 STUDENT 테이블에 저장된 학생정보 중 입력 학번의 학생정보를 
//삭제하는 JDBC 프로그램 - 저장 프로시저(Stored Procedure) 호출
public class CallableStatementApp {
	public static void main(String[] args) throws IOException,SQLException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<학생정보 삭제>>");
		System.out.print("학번 입력 >> ");
		int no=Integer.parseInt(in.readLine());
		System.out.println("==============================================================");
		Connection con=ConnectionFactory.getConnection();
		
		/*
		//DELETE_STUDENT 저장 프로시저 생성 ( 자발개발자 보다 DB개발자들이 만듬) OCP,OCD
		CREATE OR REPLACE PROCEDURE DELETE_STUDENT(VNO IN NUMBER) IS
		BEGIN 
		    DELETE FROM STUDENT WHERE NO=VNO;
		    COMMIT;
		END;
		/
		*/
				
		//Connection.prepareCall(String sql) : SQL 명령이 저장된 CallableStatement 인스턴스를 반환하는 메소드
		// => CallableStatement 인스턴스에서 저장 프로시저를 호출하는 SQL 명령만을 저장
		//CallableStatement 인스턴스에 저장된 저장 프로시저를 호출하는 SQL 명령
		// => 형식){call 프로시저명({값|변수},{값|변수},...)}
		// => ? 기호(InParameter) 사용 가능
		String sql="{call delete_student(?)}"; // call 명령어로 프로시절 호출 필요한값 변수 전달
		CallableStatement cstmt=con.prepareCall(sql);
		cstmt.setInt(1, no);
		
		//CallableStatement.execute() : CallableStatement 인스턴스에 저장된 SQL 명령을 전달하여 실행하는 메소드
		cstmt.execute(); // ? 인파라미터 사용 해서 execute() 명령어 호출 
						 // 삭제됬으면 true 삭제가 안됐으면 false 
		
		System.out.println("[결과]저장 프로시저를 사용하여 학생정보를 삭제 하였습니다.");
		
		ConnectionFactory.close(con, cstmt);
	}
}











