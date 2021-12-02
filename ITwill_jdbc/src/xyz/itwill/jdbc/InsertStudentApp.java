package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC 프로그램을 작성하기 위해 JDBC Driver 관련 클래스가 포함된 라이브러리를 프로젝트에 빌드 처리
// => Oracle JDBC Driver : ojdbc6.jar , ojdbc8.jar , ojdbc11.jar - JDK 버전 주의

// STUDENT 테이블 : 학번(숫자형-PRIMARY KEY) , 이름(문자형) , 전화번호(문자형) , 주소(문자형) , 생년월일

/*
create table student (
	    no NUMBER(4) primary key ,
	    name varchar2(30) ,
	    phone varchar2(20) ,
	    address varchar2(100) ,
	    birthday date
	)
*/
//STUDENT 테이블에 학생정보(행)을 삽입하여 저장하는 JDBC 프로그램
public class InsertStudentApp {
	public static void main(String[] args) {
		//JDBC 관련 인스턴스를 저장하기 위한 참조변수는 try 영역 외부에서 선언
		// =>   
		Connection con = null;
		Statement stmt = null;
		//1. OracleDriver 클래스를 읽어 메모리에 저장
		// => OracleDriver 클래스의 정적영역에서 OracleDriver 인스턴스를 생성하여 DriverManager 생성
		// 클래스에 JDBC Driver  등록 처리 - 1번만 실행  
		// => DriverManager.registerDriver(new OracleDriver()) 명령이 1번만 실행
		// JDBC Driver : DriverManager 클래스에 등록된 다수의 Driver 인스턴스
		// => Driver 인스턴스 : URL 주소로 원하는 DBMS 서버에 접속할 수 있는 기능 제공
		// DriverManager 클래스 : JDBC Driver를 관리하기 위한 기능을 제공하는 클래스 
		// => DriverManager.registerDriver(Driver Driver) : Driver 인스턴스를 JDBC Driver
		// 클래스의 JDBC Driver로 등록하는 메서드 
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. DriverManager 클래스에 등록된 JDBC Driver를 이용하여 DBMS 서버에 접속하고
			// 접속정보 (Connection 인스턴스)를 반환받아 저장 
			// DriverManager.getConnection(String url,String user,String password)
			// => DBMS 서버에 접속하는 메서드 - 접속 성공시 Connection 인스턴스 반환
			// => 접속 실패시 SQLException 발생 
			// SQLException : JDBC 관련 인스턴스의 메서드 호출 시 발생되는 예외
			// => DBMS 서버 접속 오류 또는 SQL 명령에 문제에 문제가 있는 경우 예외 발생 
			// URL : 인터넷에 존재하는 자원을 표현하기 위한 주소
			// => Protocol:ServerName:Port:Resource - ex) https://www.daum.net:80/index.html
			// Oracle DBMS 서버에 대한 JDBC URL 
			// 형식) jdbc:oracle:thin:@ServerName:Port:SID
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String user = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url,user,pwd);
					
			// 3. 접속된 DBMS 서버에 SQL 명령을 전달하기 위한 Statement 인스턴스를 반환받아 저장
			stmt = con.createStatement(); // SQL 문을 보내기 위한 객체 
			
			// Connection 인스턴스로 부터 SQL 명령을 전달할 수 있는 Statement 인스턴스를 생성하여 반환하는 메서드
			// 4. Statement 인스턴스로 접속된 DBMS 서버에 SQL 명령을 전달하여 실행하고 실행된 결과값을 
			// 반환받아 저장 
			// sStatement.executeUpdate(String sql) : INSERT , UPDATE , DELETE 명령을 서버에 전달하는 메서드
			// => 조작행의 갯수(int)를 반환 = SQLException 발생 
			String sql = "insert into student values (5000,'이범수','010-5453-5678','제주시','2011-01-13')";
			int rows = stmt.executeUpdate(sql); // 레코드의 건수 익스큐트
			
			// 5. SQL 명령의 실행 결과를 처리 - 출력(프로그램) 또는 반환(메서드)
			System.out.println("[메세지]"+ rows + "명의 학생정보를 저장하였습니다.");			
		} catch (ClassNotFoundException e) {
			System.out.println("[에러]OracleDriver 클래스를 찾을 수 없습니다.");
		} catch (SQLException e ) {
			System.out.println("서버에 접속 실패 하였습니다." + e.getMessage());
		} finally { // 예외와 상관없이 실행될 명령을 작성하는 영역 
			// 6.JDBC 관련 인스턴스를 제거 - close() 메서드 호출 
			try {
				// nullpointerexception 이 발생할 경우
				// if구문을 이용하여 NullPointerException 발생 방지
				// NULL 이 아닐떄만 close()를 호출 
				// ---사용했던 모든 자원 해제--- 
				if(stmt!=null) stmt.close(); // 값이 있을떄 닫아준다. 
				if(con!=null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
