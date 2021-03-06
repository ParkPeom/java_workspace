package DBConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class JdbcDAO {
	private static PoolDataSource pds;
	
	static {
		pds = PoolDataSourceFactory.getPoolDataSource();
		
		try {
			pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
			pds.setURL("jdbc:oracle:thin:@localhost:1522:orcl");	
			pds.setUser("scott");
			pds.setPassword("tiger");
			pds.setInitialPoolSize(3); // 커넥션풀 3개시작 
			pds.setMaxPoolSize(5); // 커넥션풀 최대 
		} catch(SQLException e) {
			System.out.println("[에러] SQL 연결 할수 없습니다.");
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
