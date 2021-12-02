package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SelectStudentApp {
	
	
	public void selectStudent() {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String url="jdbc:oracle:thin:@localhost:1522:orcl";
			String user="scott";
			String password="tiger";
			con = DriverManager.getConnection(url, user, password);
			
			stmt = con.createStatement();
			
			String sql="select * from student order by no";
			//Statement.executeQuery(String sql) : SQL 명령(SELECT)을 전달하는 메소드
			// => SELECT 명령을 실행하여 검색된 행을 ResultSet 인스턴스에 저장하여 반환
			//ResultSet : 검색결과를 테이블(2차원 배열) 형식으로 저장한 인스턴스
			rs = stmt.executeQuery(sql); 
			
			//ResultSet 인스턴스에 저장된 검색행을 행단위로 처리하기 위해 커서(Cursor) 제공
			// => ResultSet 커서는 최초 BOF(Before Of File) 영역에 위치
			//ResultSet.next() : ResultSet 커서를 다음행으로 이동하는 메소드 - boolean 반환
			// => false 반환 : ResultSet 커서 위치에 처리행이 없는 경우의 반환값 - EOF(End Of File)
			// => true 반환 : ResultSet 커서 위치에 처리행이 있는 경우의 반환값
		
			// if문을 통해서 
			if(rs.next()) { // ResultSet 커서을 다음행으로 이동하여 처리행이 존재하는 경우
				// System.out.println("[메세지]검색된 학생정보가 있습니다.");
				// 첫번째 행을 생략하지 않는 do-while문
				// 반복문을 이용하여 ResultSet 커서를 다음행으로 이동하여 행을 하나씩 반복 처리한다.
				// =>  ResultSet 커서 위치에 처리행이 없는 반복문 종료 
				// while(rs.next()) { if 문에서 이미 다음행으로 넘기고 while문으로 또 이동하면 첫번쨰 행은 생략됨
				// 그래서 do while문을 쓴다. 
				do {
					// ResultSet 커서 위치의 처리행에 컬럼값을 반환받아 저장 
					// ResultSet.getXXX(int columnIndex) 또는 ResultSet.getXXX(String columnLabel)
					// => ResultSet 커서 위치의 처리행에 컬럼값을 반환하는 메서드
					// => xxx는 컬럼값을 반환받기 위한 Java 자료형을 표현  
					// => columnIndex : 검색행의 컬럼 위치값 (OracleIndex : 1부터 1씩 증가되는 정수값)
					// => columnLabel : 검색행에 대한 컬럼명(별칭)
					// int no = rs.nextInt(1);
					int no = rs.getInt("no"); // 컬럼에 대한 저장된값 - 컬럼라벨이 쓰는게 좋다 유지보수
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					//Date birthday = rs.getDate("birthday"); // java.sql.date
					//ResultSet 커서 위치의 처리행에 컬럼값을 오라클 자료형에 상관없이 
					//getString() 메서드를 호출하여 Date를 문자열로 반환 가능
					// 반환받아서 처리하려면 하나하나씩 처리하는게 좋다 
					String birthday = rs.getString("birthday"); // 1995-02-23 00:00:00.0 
																// 시분초를 보기 싫으면 subString
					
					System.out.println("학번 = " + no);
					System.out.println("이름 = " + name);
					System.out.println("전화번호 = " + phone);
					System.out.println("주소 = " + address);
					System.out.println("생년월일 = " + birthday.substring(0,10)); // 0 ~ 10까지만 추출 
					System.out.println("==================================");
				} while(rs.next());
			} else {
				System.out.println("[메세지]검색된 학생정보가 없습니다.");
				}
			} catch (SQLException e) {
				System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
			} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(con!=null) con.close();
				} catch (Exception e) {}
			}
	}
	
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String url="jdbc:oracle:thin:@localhost:1522:orcl";
			String user="scott";
			String password="tiger";
			con = DriverManager.getConnection(url, user, password);
			
			stmt = con.createStatement();
			
			String sql="select * from student order by no";
			//Statement.executeQuery(String sql) : SQL 명령(SELECT)을 전달하는 메소드
			// => SELECT 명령을 실행하여 검색된 행을 ResultSet 인스턴스에 저장하여 반환
			//ResultSet : 검색결과를 테이블(2차원 배열) 형식으로 저장한 인스턴스
			rs = stmt.executeQuery(sql); 
			
			//ResultSet 인스턴스에 저장된 검색행을 행단위로 처리하기 위해 커서(Cursor) 제공
			// => ResultSet 커서는 최초 BOF(Before Of File) 영역에 위치
			//ResultSet.next() : ResultSet 커서를 다음행으로 이동하는 메소드 - boolean 반환
			// => false 반환 : ResultSet 커서 위치에 처리행이 없는 경우의 반환값 - EOF(End Of File)
			// => true 반환 : ResultSet 커서 위치에 처리행이 있는 경우의 반환값
		
			// if문을 통해서 
			if(rs.next()) { // ResultSet 커서을 다음행으로 이동하여 처리행이 존재하는 경우
				// System.out.println("[메세지]검색된 학생정보가 있습니다.");
				// 첫번째 행을 생략하지 않는 do-while문
				// 반복문을 이용하여 ResultSet 커서를 다음행으로 이동하여 행을 하나씩 반복 처리한다.
				// =>  ResultSet 커서 위치에 처리행이 없는 반복문 종료 
				// while(rs.next()) { if 문에서 이미 다음행으로 넘기고 while문으로 또 이동하면 첫번쨰 행은 생략됨
				// 그래서 do while문을 쓴다. 
				do {
					// ResultSet 커서 위치의 처리행에 컬럼값을 반환받아 저장 
					// ResultSet.getXXX(int columnIndex) 또는 ResultSet.getXXX(String columnLabel)
					// => ResultSet 커서 위치의 처리행에 컬럼값을 반환하는 메서드
					// => xxx는 컬럼값을 반환받기 위한 Java 자료형을 표현  
					// => columnIndex : 검색행의 컬럼 위치값 (OracleIndex : 1부터 1씩 증가되는 정수값)
					// => columnLabel : 검색행에 대한 컬럼명(별칭)
					// int no = rs.nextInt(1);
					int no = rs.getInt("no"); // 컬럼에 대한 저장된값 - 컬럼라벨이 쓰는게 좋다 유지보수
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					//Date birthday = rs.getDate("birthday"); // java.sql.date
					//ResultSet 커서 위치의 처리행에 컬럼값을 오라클 자료형에 상관없이 
					//getString() 메서드를 호출하여 Date를 문자열로 반환 가능
					// 반환받아서 처리하려면 하나하나씩 처리하는게 좋다 
					String birthday = rs.getString("birthday"); // 1995-02-23 00:00:00.0 
																// 시분초를 보기 싫으면 subString
					
					System.out.println("학번 = " + no);
					System.out.println("이름 = " + name);
					System.out.println("전화번호 = " + phone);
					System.out.println("주소 = " + address);
					System.out.println("생년월일 = " + birthday.substring(0,10)); // 0 ~ 10까지만 추출 
					System.out.println("==================================");
				} while(rs.next());
			} else {
				System.out.println("[메세지]검색된 학생정보가 없습니다.");
				}
			} catch (SQLException e) {
				System.out.println("[에러]JDBC 관련 오류 = "+e.getMessage());
			} finally {
				try {
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(con!=null) con.close();
				} catch (Exception e) {}
			}
		}
	}


