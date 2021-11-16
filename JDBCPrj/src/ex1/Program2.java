package ex1;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class Program2 {
	public Program2() {}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 // JDBC 드라이버 설정 -> 
		// 1. 메모리상에 드라이버 로드 
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		//클래스를 객체화 시키는게 로드 메모리상에 잡힌다.
		// 2. 드라이버매니저로 연결 객체를 반환 
		// Connection con = DriverManager.getConnection(...);
		// 3. 실행도구 객체 생성 반환  , Statement 사용자로부터 요구받은 쿼리 실행  
		// Statement st = con.createStatement();
		// 4. 결과를 얻어서 패치해옴
		// ResultSet rs = st.executeQuery(sql);
		// 결과집합을 사용자로 다 돌려주는게 아니다.
		// ResultSet 결과집합을 이용할수 있다. 
		// 5. rs.next(); 레코드의 앞머리를 가리키고 있는 Before of File 이 올라옴
		// 레코드가 온걸 담는걸 rs.next(); // 이걸 호출해야 클라이언트에 레코드에 전달
		// 6. String title = rs.getString("title"); // title컬럼에 해당하는걸 문자열로 달라
		// 계속 달라하다가 Enf of File 까지 결과집합을 다 확인해볼수 있다.
		// 데이터 베이스에 대해 쿼리해볼수 있다.
		
		String id = "ID";
		String title = "Test2";
		String writerId = "newlec";
		String content = "hahaha";
		int hit = 20;
		String files = "";
		int number = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		// 조회수가 10이상인 게시물로만 구하시오 
		String sql = "INSERT INTO NOTICE ( "
				+ "    id, "
				+ "    title, "
				+ "    writer_id, "
				+ "    content, "
				+ "    hit, "
				+ "    files, "
				+ "    pub "
				+ ") VALUES(?,?,?,?,?,?,?)"; // 조건절은 SQL 쿼리문 에 적는다 
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection(url,"scott","tiger");
		PreparedStatement st = con.prepareStatement(sql); // st.execute 쿼리실행하든 그때 sql전달했지만
								   // 미리 시쿼문을 준비해서 실행만 할수있게 준비
		st.setString(1,id);// 쿼리문에 세팅할수있는 능력 ( 인덱스 , 
		st.setString(2,title);// 쿼리문에 세팅할수있는 능력 
		st.setString(3,writerId);// 쿼리문에 세팅할수있는 능력 
		st.setString(4,content);// 쿼리문에 세팅할수있는 능력 
		st.setInt(5, hit);
		st.setString(6,files);
		st.setInt(7, number);
		
		// 실행  
		// 경우 1. execute쿼리  2. execute업데이트
		// 1. execute쿼리() - select 
		// 조작은  esecute업데이트(String sql) - insert , update , delete 
		
		int rowresult = st.executeUpdate(); // row 카운트 정수로 알려줌 
		System.out.println("row 개수 : " + rowresult);
		
		st.close();
		con.close();
	}
}

