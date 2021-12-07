package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Statement : 접속된 DBMS 서버에 SQL 명령을 전달하여 실행된 결과를 반환하는 기능을 제공하는 인스턴스
// 장점 : 하나의 Statement 인스턴스로 다수의 SQL 명령을 전달하여 실행 가능
// 단점 : SQL 명령에 Java 변수값을 포함하고자 할 경우 문자열 결합 기능 이용
// => 문자열 결합을 이용할 경우 가독성 및 유지보수의 효율성이 감소 
// => InSQL 해킹 기술(값 대신 부분적인 SQL 명령을 포함하는 기술)에 보안성이 취약하다 

public class StatementApp {
	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		//키보드로 학생정보를 입력받아 STUDENT 테이블에 삽입하여 저장하고 저장된 모든
		//학생정보를 검색하여 출력하는 JDBC 프로그램 
		
		//키보드로 학생정보를 입력받기 위한 입력스트림 생성 
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.in - 1바이트씩
		InputStreamReader 2바이트 한글자만
		BufferedReader 2바이트씩 
		
		//키보드로 학생정보를 입력받아 변수에 저장
		System.out.println("<<학생정보 입력>>\n");
		System.err.print(" 학번 입력 >>");
		// Integer.parseInt(String s) : 문자열을 전달받아 정수값으로 변환하여 반환하는 메서드
		//=>NumberFormatException 발생 - 전달받은 문자열이 정수값 형식이 아닌 경우 발생) 발생 가능
		// '가나 x "123" -> 123 
		int num = Integer.parseInt(br.readLine());
		System.out.print("이름 입력 >> ");
		String name = br.readLine();
		System.out.print("전화번호 입력 >> ");
		String phone = br.readLine();
		System.out.print("주소 입력 >> ");
		String address = br.readLine();
		System.out.print("생년월일 입력 >> ");
		String birthday = br.readLine();
		System.out.println("============================================");
		//키보드로 입력된 학생정보를 STUDENT 테이블의 행으로 삽입하여 저장
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		
		String sql1 = "insert into student values('"+num+"','"+name+"',"
				+ phone + ",'"+address+"','"+birthday+"')";
		int rows = stmt.executeUpdate(sql1);
		
		System.out.println("[결과]" + rows +"명의 학생정보를 저장 하였습니다.");
		System.out.println("========================================");
		// STUDENT 테이블에 저장된 모든 학생정보를 검색하여 출력
		String sql2 = "select * from student order by no";
		ResultSet rs = stmt.executeQuery(sql2);
		
		System.out.println("<<학생목록 출력>>");
		while(rs.next()) {
			System.out.println("학번 = " + rs.getInt("no") 
			+ "이름 = " + rs.getString("name"));
		}
		
		ConnectionFactory.close(con,stmt,rs);
		System.out.println("=========================================");
		*/
		//키보드로 이름을 입력받아 STUDENT 테이블에 저장된 학생정보 중 입력 이름과 같은 
		//이름의 학생정보를 검색하여 출력하는 JDBC 프로그램 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//키보드로 이름을 입력받아 저장
		System.out.println("<<학생정보 검색>>");
		System.out.print("이름 입력 >> ");
		String name = br.readLine();
		System.out.println("=================================================================");
		//STUDENT 테이블에 저장된 학생 정보 중 입력 이름과 같은 이름의 학생정보를 검색하여 출력
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		
		String sql = "select * from student where name = '" + name + "' order by no";
		ResultSet rs = stmt.executeQuery(sql);
		
		System.out.println("<<검색 결과 출력>>");
		if(rs.next()) {
			do {
				System.out.println("학번 = " + rs.getInt("no") + " , 이름 = " + rs.getString("name"));
			}while(rs.next());
		} else {
			System.out.println("검색된 학생정보가 없습니다.");
		}
	
		// ' or '1'='1 를 입력하면 전체 출력 
		// ' or '1'='1 
		// name = '' + or '1'='1' 이름이없거나 1 = 1 무조건 적인 참 이기 떄문에 모든 학생들이 검색됨 
		// 조건식의 일부분을 직접 삽입하면 무조건 적인 참을 나타냄 
		// 이 작업은 값이 아니라 키보드로 입력한게 아니라 sql명령으로 삽입됨 
		// 조건식의 일부가 되면서 무조건적인 참이 되서 검색이 된다. 
		// 보안 인증을 통한 흭득에 보안적으로 위험할수있다. 
		
		// 이걸쓰는건 다수의 sql 명령을 전달하여 실행 가능하지만 명령을 하나씩 전달할떄 오히려 단점
		//
	}
}
