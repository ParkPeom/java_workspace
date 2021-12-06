package xyz.itwill.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

//javax.sql.DataSource : DBCP Ŭ������ �ۼ��ϱ� ���� ��ӹ��� �������̽�

//UCP(��𼭳� �����ִ� Ŀ�ؼ�Ǯ) ���̺귯���� DBCP ���� Ŭ������ �̿��� JDBC  ���α׷� 
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		// PoolDataSource : DBCP ����� �����ϱ� ���� �ν��Ͻ� 
		// PoolDataSourceFactory.getPoolDataSource() : PoolDataSource �ν��Ͻ��� �����Ͽ� �����ϴ� �޼���
		// DataSource pds = PoolDataSourceFactory.getPoolDataSource(); 
		PoolDataSource pds = PoolDataSourceFactory.getPoolDataSource();
		
		// Connection �ν��Ͻ��� �����ϱ� ���� PoolDataSource �ν��Ͻ��� �ʵ尪�� ���� - Set
		// PoolDataSource.pds.setConnectionFactoryClassName(String driver) "Driver Ŭ������ �����ϴ� �޼���
		pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
		
		// PoolDataSource.setURL(String url) : DBMS ������ URL �ּҸ� �����ϴ� �޼���
		pds.setURL("jdbc:oracle:thin:@localhost:1522:orcl"); // url �ּҸ� ��������ִ� �޼���
		// PoolDataSource.setUser(String url) : ����ڸ� �����ϴ� �޼���
		pds.setUser("scott");
		// PoolDataSource.setPassword(String url) : ��й�ȣ�� �����ϴ� �޼���
		pds.setPassword("tiger");
	
		// PoolDataSource �ν��Ͻ��� �̸� �����Ǿ� ����� Connection �ν��Ͻ��� ���� ������
		// �����ϱ� ���� �޼��� ȣ�� - ���� ������ �������� ���� ��� �⺻�� ��� 
		pds.setInitialPoolSize(2); // ���� �����Ǵ� Connection �ν��Ͻ��� ������ ����
		pds.setMaxPoolSize(3); // �ִ� ���� ������ Connection �ν��Ͻ��� ���� ���� 
	
		//PoolDataSource.getSconnection() : PoolDataSouerce �ν��Ͻ��� �̸� �����Ǿ� �����
		// Connection �ν��Ͻ��� �� �ϳ��� �ѹ�ȯ�ϴ� �޼���
		Connection con1 = pds.getConnection();
		
		System.out.println("con1 = " + con1);
		// PoolDataSource.getAvailableConnectionsCount() : PoolDataSource �ν��Ͻ��� �����
		// ��밡���� Connection �ν��Ͻ��� ������ ��ȯ�ϴ� �޼��� 
		System.out.println("��� ������ Connection �ν��Ͻ� ���� = " + pds.getAvailableConnectionsCount());
		//Connection �ν��Ͻ��� �����ϸ� �ڵ�����  PoolDataSource �ν��Ͻ��� ���ο� Connection
		// �ν��Ͻ��� �����Ͽ� �߰� - Connection �ν��Ͻ��� ���� ���� 
		con1.close(); // ����� Ŀ�ؼ� ����
		System.out.println("��� ������ Connection �ν��Ͻ� ���� = " + pds.getAvailableConnectionsCount());
		System.out.println("================================================");
		
		Connection con2 = pds.getConnection();
		System.out.println("con2 = " + con2);
		con2.close(); // ����� Ŀ�ؼ� ���� 
		
		Connection con3 = pds.getConnection();
		System.out.println("con3 = " + con3);
		con3.close(); // ����� Ŀ�ؼ� ���� 

		Connection con4 = pds.getConnection();
		System.out.println("con4 = " + con4);
		con4.close(); // ����� Ŀ�ؼ� ���� 

		System.out.println("��� ������ Connection �ν��Ͻ� ���� = " + pds.getAvailableConnectionsCount());
		System.out.println("================================================");
	}
}
