package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Connection 인스턴스를 생성하여 반환하거나 JDBC 관련 인스턴스를 제거하는 기능을 제공하는 클래스 
// => JDBC 프로그램 작성에 필요한 공통적인 명령들을 메서드로 제공
// => 프로그램 생산성이 향상되며 유지보수의 효율성도 증가된다.
public class ConnectionFactory {
	//Connection 인스턴스를 생성하여 반환하는 메서드
	public static Connection getConnection() {// static 객체 여부없이 클래스로 접근가능 (정적 메서드) 
										      // 좋은점 : 이 메서드만 고쳐주면 됨  , 공통적인 코드를 배제 시킴 
											  // 단점 : 유지보수성이 떨어짐. 왜? 상속 인터페이스로 한게 아니라서.
											  // 스프링프레임워크 : 객체지향에 맞게 프로그래밍 함 추상화 인터페이스
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String id = "scott";
			String pwd = "tiger";
			con = DriverManager.getConnection(url, id, pwd);
		} catch (Exception e) {
			System.out.println("[에러] Connection 인스턴스를 생성할 수 없습니다.");
		}
		return con; // 접속 정보 반환 
	}
	
	// JDBC 관련 인스턴스를 전달받아 제거하는 메서드 - 메소드 오버로드 선언 - 메소드 오버로드에 의한 다형성 
	// 2. 부모와 자식 부모를 숨겨주고 자식걸 참조 - 오버라이드에 의한 다형성 
	 
	public static void close(Connection con) {
		try {
			if(con!=null) con.close();
		}catch(SQLException e) {
			e.printStackTrace(); // 예외가 발생했을떄 statck 에 들어간 객체를 추적 
		}
	}
	
	public static void close(Connection con, Statement stmt) {
		try {
			if(con!=null) con.close();
			if(stmt!=null) stmt.close();
		}catch(SQLException e) {
			e.printStackTrace(); // 예외가 발생했을떄 statck 에 들어간 객체를 추적 
		}
	}
	
	public static void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}catch(SQLException e) {
			e.printStackTrace(); // 예외가 발생했을떄 statck 에 들어간 객체를 추적 
		}
	}
}
