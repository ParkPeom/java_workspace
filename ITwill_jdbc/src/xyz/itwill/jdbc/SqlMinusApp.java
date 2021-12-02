package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

// 키보드로 SQL 명령(INSERT , UPDATE , DELETE , SELECT)을 입력받아 접속 DBMS 서버에 전달하여 실행하고 
// 실행된 결과를 출력하는 JDBC 프로그램  
// => SQL 명령을 계속 입력 받아 DBMS 서버에 전달하여 실행된 결과를 출력 
// => SQL 명령 대신 [EXIT]을 입력하면 프로그램 종료 - 대소문자 미구분 
// => 키보드로 입력된 SQL 명령이 잘못된 경우 에러 메세지 출력 - SQLException 에 대한 예외처리
// => sqlplus 프로그램을 참고하여 처리 결과 출력  
public class SqlMinusApp {

	public SqlMinusApp() {
	}

	public static void main(String[] args) throws IOException , SQLException {
		// 키보드로 SQL 명령을 입력받기 위한 입력 스트림
		// 입출력 스트림 
		// 버퍼 - 임시 메모리 
		// 스트림 연결을 통해 확장시킬수있다. 
		// system.in = inputStream 원시데이터 1바이트씩 읽어드리는것을 1바이트 더 합쳐서 2바이트로 inputStreamReader
		// 더 확장해서 BufferedReader 대용량 2바이트 문자를 여러개 읽어드릴수있다.
		// 키보드로 문자열을 입력받을때 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = null;
		
		while(true) {
			//키보드로 SQL 명령을 입력받아 저장
			System.out.print("SQL> "); // 앞뒤로 존재하는 공백을 제거한다. 
			String sql = br.readLine().trim();
		
			// 입력받은 문자열이 [exit]인 경우 반복문 종료 - 프로그램 종료 
			if(sql.equalsIgnoreCase("exit")) break; // equalsIgnoreCase 대소문자를 무시함 
		
			// 입력받은 문자열이 없는 경우 반복문 재실행
			if(sql==null || sql.equals("")) continue;
			
			try {
				// 키보드로 입력받은 SQL 명령을 전달하여 실행 
				if(stmt.execute(sql)) { // 전달된 명령이 DQL 명령인 경우
					rs = stmt.getResultSet(); // 결과집합 			
					if(rs.next()) { // 검색행이 있는 경우
						//검색행에 대한 부가적인 정보를 반환받아 저장
						ResultSetMetaData rsmd = rs.getMetaData();
						
						// 검색행의 컬럼 갯수를 반환받아 저장
						int columnCount = rsmd.getColumnCount();
						System.out.println("===============================================================");
						// 검색행의 컬럼명을 반환받아 출력 
						for(int i=1; i<=columnCount;i++) {
							System.out.print(rsmd.getColumnLabel(i)+"\t\t");
							
						}
						System.out.println();
						System.out.println("===============================================================");
						do {
							for(int i = 1; i<=columnCount; i++) {
								String columnValue = rs.getString(i);
								if(rsmd.getColumnTypeName(i).equals("DATE")) {
									columnValue = columnValue.substring(0,10);
								}
								if(columnValue == null ) {
									columnValue = "    ";
								}
								System.out.print(columnValue+"\t\t");
							}
							System.out.println();				
						}while(rs.next());
					} else { // 검색행이 없는 경우
						System.out.println("검색된 결과가 없습니다.");						
					}
					
				} else { // 전달된 명령이 DML 명령인 경우
					int rows = stmt.getUpdateCount();
					System.out.println(rows+ " 개의 행을 " + sql.substring(0,6).toUpperCase() +" 하였습니다.");
				}
			} catch(SQLException e) {
				// 키보드로 입력 받아 전달하여 실행된 SQL 명령이 잘못된 경우 SQLException 발생 
				System.out.println(" SQL 오류 " + e.getMessage());
			}
		}
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("[메세지] SQLMinus 프로그램을 종료 합니다.");
	}

}
