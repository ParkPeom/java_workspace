import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import xyz.itwill.jdbc.ConnectionFactory;

// 접속된 DBMS 서버에 SQL 명령을 전달하여 실행된 결과를 반환하는 기능을 제공
// => PreparedStatement 인스턴스에 SQL 명령을 미리 저장하여 접속된 DBMS 서버에 전달하여 실행 
// 장점 :InParameter를 이용하여 값을 전달받아 SQL명령을 작성 
// => InParameter를 사용하여 가독성과 유지보수의 효율성 증가 
// => InSQL 해킹 기술 무효화 처리 - 사용자 입력값을 무조건 SQL 명령의 값으로 처리 
// 단점 :PreparedStatement 인스턴스는 하나의 SQL 명령만을 저장하여 전달 가능 
public class PreparedStatementApp {
	
	public static void main(String[] args) throws IOException , SQLException {
		
		//키보드로 학생정보를 입력받기 위한 입력스트림 생성 			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
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
		
		// SQL문을 미리 만들어야 함
		// Connection.prepareStatement(String sql) : 접속된 DBMS 서버에 전달할 SQL명령을
		// 저장한 PreparedStatement 인스턴스를 반환하는 메서드 
		// => PreparedStatement 인스턴스에 저장된 SQL 명령에서는 ? 기호를 사용 
		// 물음표라고 하지않고 (InParameter) 입력매개변수 or 입력 인자 라고 부른다.
		// InParameter(?) : Java 변수값을 제공받아 SQL 명령의 값으로 표현하기 위한 기호 
		// => PreparedStatement 인스턴스에 저장된 SQL 명령의 모든 InParameter 에는 반드시
		//	Java 변수값이 전달 되어야만 SQL명령이 완성되어 접속 DBMS 서버에 전달 가능 
		//PreparedStatement.setXXX(int parameterIndex, XXX value)
		// => 원하는 위치(OracleIndex)의  InParameter 에 Java변수값을 전달하는 메서드 
		// => xxx는 Java 자료형을 표현하며 메서드는 InParameter 의 갯수만큼 호출 
		String sql = "insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);		
		pstmt.setInt(1, num);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		pstmt.setString(4, address);
		pstmt.setString(5, birthday);
		
		// PreparedStatement.executeUpdate : PreparedStatement 인스턴스에 저장된 완성된 SQL
		// 명령(INSERT,UPDATE,DELETE)을 전달하는 메서드 - 조작행의 갯수(int) 반환 
		int rows = pstmt.executeUpdate();
		
		System.out.println("[결과]"+rows+"명의 학생 정보를 저장하였습니다.");

		// STUDENT테이브에 저장된 모든 학생정보를 검색하여 출력
		String sql2 =  "select * from student order by no ";
		
		pstmt = con.prepareStatement(sql2);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt("no"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("phone"));
			System.out.println(rs.getString("address"));
			System.out.println(rs.getString("birthday"));
		}
		
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		//키보드로 학생정보를 입력받아 변수에 저장
		System.out.println("<<학생정보 입력>>\n");
		System.err.print(" 이름 입력 >>");
		name = br.readLine();
		System.out.println("===========================================");
		con = ConnectionFactory.getConnection();
		
		// InParameter는 Java 변수값을 무조건 SQL명령의 값으로만 처리
		String sql3 = "select * from student where name = ? order by no";
		pstmt = con.prepareStatement(sql3);
		pstmt.setString(1, name);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("no"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getString("phone"));
			System.out.println(rs.getString("address"));
			System.out.println(rs.getString("birthday"));
		}
	}
}
