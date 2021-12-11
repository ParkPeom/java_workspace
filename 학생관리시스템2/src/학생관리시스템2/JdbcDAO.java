package �л������ý���2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

// DBCP : Connection �ν��Ͻ��� �����޾� ��ȯ �ϰų�
// JDBC ���� �ν��Ͻ��� ���޹޾� ���� �ϴ� ����� �����ϴ� Ŭ���� 
// DBMS ���� DAO Ŭ������ ��ӹ޾� ����ϴ� Ŭ���� 
// �߻�Ŭ������ �ۼ��ϴ� ���� ���� �Ѵ�. 
public abstract class JdbcDAO {
	
	private static PoolDataSource pds; // jdbc8 ����Ʈ 
	
	static {
		pds = PoolDataSourceFactory.getPoolDataSource();
		
		try {
			pds.setConnectionFactoryClassName("oracle.jdbc.driver.oracleDriver");
			pds.setURL("jdbc:oracle:thin:@localhost:1522:orcl");	
			pds.setUser("scott");
			pds.setPassword("tiger");
			pds.setInitialPoolSize(3); // Ŀ�ؼ�Ǯ 3������ 
			pds.setMaxPoolSize(5); // Ŀ�ؼ�Ǯ �ִ� 
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			con = pds.getConnection();
		} catch (SQLException e) {
			System.out.println("[����] SQL ���� �Ҽ� �����ϴ�.");
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
