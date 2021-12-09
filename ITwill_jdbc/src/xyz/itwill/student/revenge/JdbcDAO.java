package xyz.itwill.student.revenge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

// DBCP(DataBase Connection Pool) Connection �ν��Ͻ��� �����޾� 


public abstract class JdbcDAO {
	
	private static PoolDataSource pds; // PoolDataSource �������̽�
	
	static {
		pds = PoolDataSourceFactory.getPoolDataSource(); // PoolDataSourceFactory ��ü�� �ϳ��� ����� �ش�. - �޸𸮿� �ϳ��� ���� �ϳ��θ� ����.
	
		try {
			pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
			pds.setURL("jdbc:oracle:thin:@localhost:1522:orcl");		
			pds.setUser("scott");
			pds.setPassword("tiger");
			pds.setInitialPoolSize(3); // �ּ� ����
			pds.setMaxPoolSize(5); // �ִ� ���� 
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = pds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con , PreparedStatement pstmt , ResultSet rs ) {
		try {
			if(con!=null) con.close();
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection con , PreparedStatement pstmt) {
		try {
			if(con!=null) con.close();
			if(pstmt!=null) pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
