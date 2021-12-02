package xyz.itwill.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

// Ű����� SQL ���(INSERT , UPDATE , DELETE , SELECT)�� �Է¹޾� ���� DBMS ������ �����Ͽ� �����ϰ� 
// ����� ����� ����ϴ� JDBC ���α׷�  
// => SQL ����� ��� �Է� �޾� DBMS ������ �����Ͽ� ����� ����� ��� 
// => SQL ��� ��� [EXIT]�� �Է��ϸ� ���α׷� ���� - ��ҹ��� �̱��� 
// => Ű����� �Էµ� SQL ����� �߸��� ��� ���� �޼��� ��� - SQLException �� ���� ����ó��
// => sqlplus ���α׷��� �����Ͽ� ó�� ��� ���  
public class SqlMinusApp {

	public SqlMinusApp() {
	}

	public static void main(String[] args) throws IOException , SQLException {
		// Ű����� SQL ����� �Է¹ޱ� ���� �Է� ��Ʈ��
		// ����� ��Ʈ�� 
		// ���� - �ӽ� �޸� 
		// ��Ʈ�� ������ ���� Ȯ���ų���ִ�. 
		// system.in = inputStream ���õ����� 1����Ʈ�� �о�帮�°��� 1����Ʈ �� ���ļ� 2����Ʈ�� inputStreamReader
		// �� Ȯ���ؼ� BufferedReader ��뷮 2����Ʈ ���ڸ� ������ �о�帱���ִ�.
		// Ű����� ���ڿ��� �Է¹����� 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Connection con = ConnectionFactory.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = null;
		
		while(true) {
			//Ű����� SQL ����� �Է¹޾� ����
			System.out.print("SQL> "); // �յڷ� �����ϴ� ������ �����Ѵ�. 
			String sql = br.readLine().trim();
		
			// �Է¹��� ���ڿ��� [exit]�� ��� �ݺ��� ���� - ���α׷� ���� 
			if(sql.equalsIgnoreCase("exit")) break; // equalsIgnoreCase ��ҹ��ڸ� ������ 
		
			// �Է¹��� ���ڿ��� ���� ��� �ݺ��� �����
			if(sql==null || sql.equals("")) continue;
			
			try {
				// Ű����� �Է¹��� SQL ����� �����Ͽ� ���� 
				if(stmt.execute(sql)) { // ���޵� ����� DQL ����� ���
					rs = stmt.getResultSet(); // ������� 			
					if(rs.next()) { // �˻����� �ִ� ���
						//�˻��࿡ ���� �ΰ����� ������ ��ȯ�޾� ����
						ResultSetMetaData rsmd = rs.getMetaData();
						
						// �˻����� �÷� ������ ��ȯ�޾� ����
						int columnCount = rsmd.getColumnCount();
						System.out.println("===============================================================");
						// �˻����� �÷����� ��ȯ�޾� ��� 
						for(int i=1; i<=columnCount;i++) {
							System.out.print(rsmd.getColumnLabel(i)+"\t\t");
							
						}
						System.out.println();
						System.out.println("===============================================================");
						do {
							for(int i = 1; i<=columnCount; i++) {
								String columnValue = rs.getString(i);
								if(rsmd.getColumnTypeName(i).equals("DATE")) {
									columnValue = columnValue.substring(0,10);
								}
								if(columnValue == null ) {
									columnValue = "    ";
								}
								System.out.print(columnValue+"\t\t");
							}
							System.out.println();				
						}while(rs.next());
					} else { // �˻����� ���� ���
						System.out.println("�˻��� ����� �����ϴ�.");						
					}
					
				} else { // ���޵� ����� DML ����� ���
					int rows = stmt.getUpdateCount();
					System.out.println(rows+ " ���� ���� " + sql.substring(0,6).toUpperCase() +" �Ͽ����ϴ�.");
				}
			} catch(SQLException e) {
				// Ű����� �Է� �޾� �����Ͽ� ����� SQL ����� �߸��� ��� SQLException �߻� 
				System.out.println(" SQL ���� " + e.getMessage());
			}
		}
		ConnectionFactory.close(con, stmt, rs);
		System.out.println("[�޼���] SQLMinus ���α׷��� ���� �մϴ�.");
	}

}
