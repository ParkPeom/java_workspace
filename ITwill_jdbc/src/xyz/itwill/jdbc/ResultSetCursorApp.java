package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Statement 인스턴스를 반환하는 메서드에 전달되는 값에 따라 ResultSet 인스턴스의 사용 방법 변경
// => ResultSet 커서의 위치 변경 또는 ResultSet 커서 위치에 행삽입 , 컬럼값 변경 , 행 변경 ,  행 삭제 등의 조작이 가능
public class ResultSetCursorApp {

	public static void main(String[] args) throws SQLException {
	Connection con=ConnectionFactory.getConnection();
		
		//Connection.createStatement() : Statement 인스턴스를 반환하는 메소드
		//Statement : SQL 명령을 접속된 DBMS 서버에 전달하기 위한 인스턴스
		// => executeQuery() 메소드 또는 executeUpdate() 메소드를 호출하여 SQL 명령 전달
		//Statement.executeQuery(String sql) : SELECT 명령을 전달하여 실행하고 검색결과를
		//ResultSet 인스턴스로 반환하는 메소드
		// => ResultSet 인스턴스는 커서를 이용하여 행단위로 처리
		// => ResultSet 커서는 다음행으로 이동만 가능하며 커서 위치의 행에 대한 조작 불가능
		Statement stmt=con.createStatement();
		
		String sql="select * from student order by no";
		ResultSet rs=stmt.executeQuery(sql);
		
		//ResultSet.next() : ResultSet 커서를 다음행으로 이동하는 메소드
		// => 커서 위치에 처리행이 없는 경우 false 반환하며 처리행이 있는 경우 true 반환
		while(rs.next()) {
			//ResultSet.getRow() : ResultSet 커서가 위치한 처리행의 행번호(RowIndex)를 반환하는 메소드
			//ResultSet.getXXX(String columnLabel) : ResultSet 커서가 위치한 처리행의 컬럼값을 반환하는 메소드
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("==============================================================");
		con=ConnectionFactory.getConnection();
		
		//Connection.createStatement(int resultSetType, int resultSetConcurrency)
		// => Statement 인스턴스를 반환하는 메소드
		// => 매개변수에 전달되는 값에 따라 SELECT 명령의 실행결과를 저장한 ResultSet 인스턴스의 속성 변경
		//resultSetType : ResultSet 커서의 이동 관련 속성 - 정수값 대신 상수 사용
		// => ResultSet.TYPE_FORWARD_ONLY : ResultSet 커서를 다음행으로만 이동(기본)
		// => ResultSet.TYPE_SCROLL_INSENSITIVE : ResultSet 커서를 원하는 행으로 이동 - 조작행 미반영 
		// => ResultSet.TYPE_SCROLL_SENSITIVE : ResultSet 커서를 원하는 행으로 이동 - 조작행 반영
		//resultSetConcurrency : ResultSet 커서 위치의 행에 대한 조작 관련 속성 - 정수값 대신 상수 사용
		// => ResultSet.CONCUR_READ_ONLY : ResultSet 커서 위치의 행에 대한 조작 불가능
		// => ResultSet.CONCUR_UPDATABLE : ResultSet 커서 위치의 행에 대한 조작 가능
		stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		sql="select * from student order by no";
		rs=stmt.executeQuery(sql);
		
		//ResultSet.first() : ResultSet 커서를 첫번째 검색행으로 이동하는 메소드 
		rs.first();
		System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));

		//ResultSet.last() : ResultSet 커서를 마지막 검색행으로 이동하는 메소드 
		rs.last();
		System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		
		//ResultSet.absolute(int rowIndex) : ResultSet 커서를 원하는 위치의 검색행으로 이동하는 메소드 
		rs.absolute(2);
		System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		System.out.println("==============================================================");
		//ResultSet.beforeFirst() : ResultSet 커서를 BOF 영역으로 이동하는 메소드 
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		System.out.println("==============================================================");
		//ResultSet.afterLast() : ResultSet 커서를 EOF 영역으로 이동하는 메소드 
		rs.afterLast();
		//ResultSet.previous() : ResultSet 커서를 이전행으로 이동하는 메소드
		while(rs.previous()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("==============================================================");
		con=ConnectionFactory.getConnection();

		stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		//ResultSet 커서 위치의 행을 조작하고자 할 경우 SELECT 명령에서 검색대상으로 * 사용 불가능
		sql="select no,name,phone,address,birthday from student order by no";
		rs=stmt.executeQuery(sql);
		
		/*
		//3번째 행에 새로운 행을 테이블에 삽입하여 저장하는 명령 - INSERT 
		rs.absolute(2);
		
		//ResultSet.moveToInsertRow() : ResultSet 커서 위치 아래에 새로운 행을 삽입하는 메소드
		// => 기존행은 다음행으로 자동 이동
		rs.moveToInsertRow();
		
		//삽입된 행에 컬럼값 변경
		//ResultSet.updateXXX(String columnLabel, XXX value) :  ResultSet 커서 위치의 행에
		//컬럼값을 변경하는 메소드 - XXX : Java 자료형
		rs.updateInt("no", 5000);
		rs.updateString("name", "장길산");
		rs.updateString("phone", "010-7894-3241");
		rs.updateString("address", "부산시 사하구");
		//rs.updateDate("birthday", new Date(100, 11, 20));//2000-12-20
		rs.updateString("birthday", "2000-12-20");
		
		//ResultSet.insertRow() : ResultSet 위치에 처리행을 테이블에 삽입하는 메소드
		rs.insertRow();
		*/
		
		/*
		//마지막 행을 테이블에 삭제하는 명령 - DELETE
		rs.last();

		//ResultSet.deleteRow() : ResultSet 위치에 처리행을 테이블에서 삭제하는 메소드
		rs.deleteRow();
		*/
		
		//2번째 행의 name 컬럼값을 변경하고 테이블을 변경하는 명령 - UPDATE 
		rs.absolute(2);
		
		rs.updateString("name", "임꺽정");
		
		//ResultSet.updateRow() : ResultSet 위치에 처리행을 테이블에서 변경하는 메소드
		rs.updateRow();
		
		rs.beforeFirst();
		while(rs.next()) {
			System.out.println(rs.getRow()+"행 : 학번 = "+rs.getInt("no")+", 이름 = "+rs.getString("name"));
		}
		
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("==============================================================");
	}
}


