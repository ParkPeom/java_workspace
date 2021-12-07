package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

// DBCP(DataBase Connection Pool) ���� �ν��Ͻ��� �����Ͽ� Connection �ν��Ͻ��� �����޾�
// ��ȯ�ϰų� JDBC ���� �ν��Ͻ��� ���޹޾� �����ϴ� ����� �����ϴ� Ŭ����
// => DBMS ���� DAO Ŭ�������� ��ӹ޾� ����ϴ� Ŭ���� -> ���������� ������
// => �߻�Ŭ������ �ۼ��ϴ� ���� ���� - ����� �������� �ۼ��� Ŭ���� 
public abstract class JdbcDAO {
	
	private static PoolDataSource _pds;
	
	static { // PoolDataSource �ν��Ͻ��� �����Ͽ� �ý��� �ʵ忡 ���� - DBCP
		_pds = PoolDataSourceFactory.getPoolDataSource();
					// PoolDataSourceFactory �ν��Ͻ��� ������ִ� ���尰�� Ŭ����
					// PoolDataSource ��ü�� �� �ϳ��� ������ش�. 
					// �޸𸮿� �ϳ��� ���� �ϳ��θ� ����. 
		try {
			_pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
			_pds.setURL("jdbc:oracle:thin:@localhost:1522:orcl");
			_pds.setUser("scott");
			_pds.setPassword("tiger");
			_pds.setInitialPoolSize(3); // �ּ� ������
			_pds.setMaxPoolSize(5); // �ִ� 
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
