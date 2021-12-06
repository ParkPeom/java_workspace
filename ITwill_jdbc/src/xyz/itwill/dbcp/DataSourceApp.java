package xyz.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

//javax.sql.DataSource : DBCP 클래스를 작성하기 위해 상속받은 인터페이스

//UCP(어디서나 쓸수있는 커넥션풀) 라이브러리의 DBCP 관련 클래스를 이용한 JDBC  프로그램 
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		// PoolDataSource : DBCP 기능을 제공하기 위한 인스턴스 
		// PoolDataSourceFactory.getPoolDataSource() : PoolDataSource 인스턴스를 생성하여 관할하는 메서드
		// DataSource pds = PoolDataSourceFactory.getPoolDataSource(); 
		PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();
		
		// Connection 인스턴스를 생성하기 위해 PoolDataSource 인스턴스의 필드값을 변경 - Set
		// PoolDataSource.pds.setConnectionFactoryClassName(String driver) "Driver 클래스를 변경하는 메서드
		pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
		
		// PoolDataSource.setURL(String url) : DBMS 서버의 URL 주소를 변경하는 메서드
		pds.setURL("jdbc:oracle:thin:@localhost:1522:orcl"); // url 주소를 변경시켜주는 메서드
		// PoolDataSource.setUser(String url) : 사용자를 변경하는 메서드
		pds.setUser("scott");
		// PoolDataSource.setPassword(String url) : 비밀번호를 변경하는 메서드
		pds.setPassword("tiger");
	
		// PoolDataSource 인스턴스에 미리 생성되어 저장될 Connection 인스턴스의 제한 갯수를
		// 변경하기 위한 메서드 호출 - 제한 갯수를 변경하지 않을 경우 기본값 사용 
		pds.setInitialPoolSize(2); // 최초 생성되는 Connection 인스턴스의 개수를 변경
		pds.setMaxPoolSize(3); // 최대 생성 가능한 Connection 인스턴스의 갯수 변경 
	
		//PoolDataSource.getSconnection() : PoolDataSouerce 인스턴스에 미리 생성되어 저장된
		// Connection 인스턴스를 중 하나를 한반환하는 메서드
		Connection con1 = pds.getConnection();
		
		System.out.println("con1 = " + con1);
		// PoolDataSource.getAvailableConnectionsCount() : PoolDataSource 인스턴스에 저장된
		// 사용가능한 Connection 인스턴스의 갯수를 반환하는 메서드 
		System.out.println("사용 가능한 Connection 인스턴스 갯수 = " + pds.getAvailableConnectionsCount());
		//Connection 인스턴스를 제거하면 자동으로  PoolDataSource 인스턴스에 새로운 Connection
		// 인스턴스를 생성하여 추가 - Connection 인스턴스의 갯수 유지 
		con1.close(); // 사용한 커넥션 제거
		System.out.println("사용 가능한 Connection 인스턴스 갯수 = " + pds.getAvailableConnectionsCount());
		System.out.println("================================================");
		
		Connection con2 = pds.getConnection();
		System.out.println("con2 = " + con2);
		con2.close(); // 사용한 커넥션 제거 
		
		Connection con3 = pds.getConnection();
		System.out.println("con3 = " + con3);
		con3.close(); // 사용한 커넥션 제거 

		Connection con4 = pds.getConnection();
		System.out.println("con4 = " + con4);
		con4.close(); // 사용한 커넥션 제거 

		System.out.println("사용 가능한 Connection 인스턴스 갯수 = " + pds.getAvailableConnectionsCount());
		System.out.println("================================================");
	}
}
