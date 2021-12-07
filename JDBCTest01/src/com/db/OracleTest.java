package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleTest 
{
    public static void main(String args[])
    {
        Connection conn = null; // DB연결된 상태(세션)을 담은 객체
        PreparedStatement pstm = null;  // SQL 문을 나타내는 객체
        ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
        
        try {
            // SQL 문장을 만들고 만약 문장이 질의어(SELECT문)라면
            // 그 결과를 담을 ResulSet 객체를 준비한 후 실행시킨다.
        	String quary = "SELECT * FROM EMP"; 
            conn = DBConnection.getConnection(); 
            // DB에 연결된 상태를 con에 담는다
            pstm = conn.prepareStatement(quary); // 1번 캐시에 담아 재사용 
            
            // statement 매번쿼리 수행 
            // 연결된상태(conn)를 가지고 prepareStatement(query)메서드를 통해서 DB에 쿼리문을 보낸다.
            rs = pstm.executeQuery();
            // PreparedStatement 클래스에 있는 executeQuery() 메서드는 쿼리문을 실행하는 것을 의미함
            // cmd 창에 쿼리문을 적어놓고 엔터를 치면 결과과 나오듯이 executeQuery()는 쿼리문이 입력된 
            // 상태에서 엔터키를 누르는 역할을 한다. 
            // 쿼리문을 입력하고 엔터를 누르면 결과가 나올것인데 그 결과를
            // rs(ResultSet)에 담는다
            // executeQuery() 메서드의 반환값은 ResultSet 이다.
            
            /*  EMP 테이블의 데이터 타입
             * 
                EMPNO NOT NULL NUMBER(4) -- int
                ENAME VARCHAR2(10) -- String
                JOB VARCHAR2(9) -- String
                MGR NUMBER(4) -- int
                HIREDATE DATE -- Date
                SAL NUMBER(7,2) -- float/double
                COMM NUMBER(7,2) -- float/double
                DEPTNO NUMBER(2) -- int
            */           
            System.out.println("EMPNO ENAME JOB MGR HIREDATE SAL COMM DEPTNO");
            System.out.println("============================================");
            
            // 쿼리문이 입력되면 결과가 나온다. 그 결과를 담고 있는 rs를 가지고 next()를 이용
            // while문을 이용 데이터가 없을 때 까지 반복해서 데이터를 가지고 나온다.          
            while(rs.next()){
                int empno = rs.getInt(1);
                //int empno = rs.getInt("empno"); 숫자 대신 컬럼 이름을 적어도 된다.
                String ename = rs.getString(2);
                String job = rs.getString(3);
                int mgr = rs.getInt(4);
                java.sql.Date hiredate = rs.getDate(5); // Date 타입 처리
                int sal = rs.getInt(6);
                int comm = rs.getInt(7);
                int deptno = rs.getInt(8);
                
                String result = empno+" "+ename+" "+job+" "+mgr+" "+hiredate+" "+sal+" "+comm+" "+deptno;
                System.out.println(result);
            }
        } catch (SQLException sqle) {
            System.out.println("SELECT문에서 예외 발생");
            sqle.printStackTrace();
        }finally{
            // DB 연결을 종료한다.
            try{
                if ( rs != null ){rs.close();}   
                if ( pstm != null ){pstm.close();}   
                if ( conn != null ){conn.close(); }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
            
        }
    }
}


