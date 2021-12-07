package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection 
{
    public static Connection dbConn; // interface Connection
    
        public static Connection getConnection()
        {
            Connection conn = null; // 데이터베이스와 연결된 세션 역할을 함 
            						// 이 세션을 이용하여 데이터베이스에 SQL을 전송하고 
            						// 그결과인 ResultSet객체를 얻어 낸다. 
            try {
                String user = "scott"; 
                String pw = "tiger"; // 계정의 비밀번호 
                String url = "jdbc:oracle:thin:@localhost:1522:orcl"; // 접속할 DB 주소
                			// 1. jdbc:oracle:thin  오라클에 접속하겠다고 알려줌
                			// 2. @localhost 자신의 IP주소
                			// 3. 1522 포트번호
                			// 4. DB이름 
                Class.forName("oracle.jdbc.driver.OracleDriver"); 
                // JDBC 드라이버(ojdbc8.jar)를 로딩하는 부분이다. 로딩실패시 catch문 
                conn = DriverManager.getConnection(url, user, pw);
                // 입력된 오라클 계정,비밀번호,주소 바탕으로 오라클에 접속 
                // 접속 실패시 SQLEXception 발생 getConnection()메서드는 Connection을 반환
                System.out.println("Database에 연결되었습니다.\n");   
            } catch (ClassNotFoundException cnfe) {
                System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
            } catch (SQLException sqle) {
                System.out.println("DB 접속실패 : "+sqle.toString());
            } catch (Exception e) {
                System.out.println("Unkonwn error");
                e.printStackTrace();
            }
            return conn;     
        }
}

