package �̱�������2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class JdbcDAO {
	private static PoolDataSource pds; // jdbc8 
	static {
		try { 
			pds = PoolDataSourceFactory.getPoolDataSource();	
			pds.setConnectionFactoryClassName("oracle.jdbc.driver.Oracle.Driver");
			pds.setURL("jdbc:oracle:thin:@localhost:1522:orcl");
			pds.setURL("scott");
			pds.setPassword("tiger");
			pds.setInitialPoolSize(3);
			pds.setMaxPoolSize(5);
		}catch(SQLException e) {
			System.out.println("[����] SQL ���� �Ҽ� �����ϴ�.");
		}
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			con = pds.getConnection();
		} catch(SQLException e) {
			System.out.println("[����] SQL�� �����Ҽ� �����ϴ�.");
		}
		return con;
	}
	public void close(Connection con , PreparedStatement pstmt , ResultSet rs) {
	 try {	
		if(con != null) con.close();
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
	 	} catch (SQLException e) {
	 		System.out.println("[����] SQL ���� �Դϴ�.");
	 	}
	}
}
