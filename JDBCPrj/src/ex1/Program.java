package ex1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.sql.DATE;

public class Program {

	public Program() {}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 // JDBC ����̹� ���� -> 
		// 1. �޸𸮻� ����̹� �ε� 
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		//Ŭ������ ��üȭ ��Ű�°� �ε� �޸𸮻� ������.
		// 2. ����̹��Ŵ����� ���� ��ü�� ��ȯ 
		// Connection con = DriverManager.getConnection(...);
		// 3. ���൵�� ��ü ���� ��ȯ  , Statement ����ڷκ��� �䱸���� ���� ����  
		// Statement st = con.createStatement();
		// 4. ����� �� ��ġ�ؿ�
		// ResultSet rs = st.executeQuery(sql);
		// ��������� ����ڷ� �� �����ִ°� �ƴϴ�.
		// ResultSet ��������� �̿��Ҽ� �ִ�. 
		// 5. rs.next(); ���ڵ��� �ոӸ��� ����Ű�� �ִ� Before of File �� �ö��
		// ���ڵ尡 �°� ��°� rs.next(); // �̰� ȣ���ؾ� Ŭ���̾�Ʈ�� ���ڵ忡 ����
		// 6. String title = rs.getString("title"); // title�÷��� �ش��ϴ°� ���ڿ��� �޶�
		// ��� �޶��ϴٰ� Enf of File ���� ��������� �� Ȯ���غ��� �ִ�.
		// ������ ���̽��� ���� �����غ��� �ִ�.
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		
		// ��ȸ���� 10�̻��� �Խù��θ� ���Ͻÿ� 
		String sql = "SELECT * FROM NOTICE WHERE HIT >= 10 "; // �������� SQL ������ �� ���´� 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"scott","tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) { // �����°� ������ true
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			String regDate = rs.getString("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			// ��� ���ڵ尡 ��� 
			
			System.out.printf("id:%d,title:%s,writerId%s,regDate:%s,content:%s,hit%d \n",
			id,title,writerId,regDate,content,hit);
		}
		rs.close();
		st.close();
		con.close();
	}
}
