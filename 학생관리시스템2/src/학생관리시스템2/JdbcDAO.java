package 학생관리시스템2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

// DBCP : Connection 인스턴스를 제공받아 반환 하거나
// JDBC 관련 인스턴스를 전달받아 제거 하는 기능을 제공하는 클래스 
// DBMS 관련 DAO 클래스를 상속받아 사용하는 클래스 
// 추상클래스로 작성하는 것을 권장 한다. 
public abstract class JdbcDAO {
	
	private static PoolDataSource pds; // jdbc8 임포트 
	
	static {
		pds = PoolDataSourceFactory.getPoolDataSource();
		
		try {
			pds.setConnectionFactoryClassName("oracle.jdbc.driver.oracleDriver");
			pds.setURL("jdbc:oracle:thin:@localhost:1522:orcl");	
			pds.setUser("scott");
			pds.setPassword("tiger");
			pds.setInitialPoolSize(3); // 커넥션풀 3개시작 
			pds.setMaxPoolSize(5); // 커넥션풀 최대 
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			con = pds.getConnection();
		} catch (SQLException e) {
			System.out.println("[에러] SQL 연결 할수 없습니다.");
		}
		return con;
	}
	public void close(Connection con , PreparedStatement pstmt , ResultSet rs) {
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		} 
	public void close(Connection con , PreparedStatement pstmt) {

	if(con != null)
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	if(pstmt != null)
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
