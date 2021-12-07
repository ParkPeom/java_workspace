package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

// DBCP(DataBase Connection Pool) 관련 인스턴스를 생성하여 Connection 인스턴스를 제공받아
// 반환하거나 JDBC 관련 인스턴스를 전달받아 제거하는 기능을 제공하는 클래스
// => DBMS 관련 DAO 클래스에서 상속받아 사용하는 클래스 -> 유지보수가 쉬워짐
// => 추상클래스로 작성하는 것을 권장 - 상속을 목적으로 작성된 클래스 
public abstract class JdbcDAO {
	
	private static PoolDataSource _pds;
	
	static { // PoolDataSource 인스턴스를 생성하여 시스템 필드에 저장 - DBCP
		_pds = PoolDataSourceFactory.getPoolDataSource();
					// PoolDataSourceFactory 인스턴스를 만들어주는 공장같은 클래스
					// PoolDataSource 객체를 딱 하나만 만들어준다. 
					// 메모리에 하나만 만들어서 하나로만 쓴다. 
		try {
			_pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
			_pds.setURL("jdbc:oracle:thin:@localhost:1522:orcl");
			_pds.setUser("scott");
			_pds.setPassword("tiger");
			_pds.setInitialPoolSize(3); // 최소 사이즈
			_pds.setMaxPoolSize(5); // 최대 
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			con = _pds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void close(Connection con , PreparedStatement pstmt , ResultSet rs) {
		try {
			if(con!=null) con.close();
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}

	public void close(Connection con , PreparedStatement pstmt) {
		try {
			if(con!=null) con.close();
			if(pstmt!=null) pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
