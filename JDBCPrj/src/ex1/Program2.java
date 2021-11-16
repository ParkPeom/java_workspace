package ex1;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class Program2 {
	public Program2() {}
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
		
		String id = "ID";
		String title = "Test2";
		String writerId = "newlec";
		String content = "hahaha";
		int hit = 20;
		String files = "";
		int number = 0;
		
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		// ��ȸ���� 10�̻��� �Խù��θ� ���Ͻÿ� 
		String sql = "INSERT INTO NOTICE ( "
				+ "    id, "
				+ "    title, "
				+ "    writer_id, "
				+ "    content, "
				+ "    hit, "
				+ "    files, "
				+ "    pub "
				+ ") VALUES(?,?,?,?,?,?,?)"; // �������� SQL ������ �� ���´� 
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection(url,"scott","tiger");
		PreparedStatement st = con.prepareStatement(sql); // st.execute ���������ϵ� �׶� sql����������
								   // �̸� �������� �غ��ؼ� ���ุ �Ҽ��ְ� �غ�
		st.setString(1,id);// �������� �����Ҽ��ִ� �ɷ� ( �ε��� , 
		st.setString(2,title);// �������� �����Ҽ��ִ� �ɷ� 
		st.setString(3,writerId);// �������� �����Ҽ��ִ� �ɷ� 
		st.setString(4,content);// �������� �����Ҽ��ִ� �ɷ� 
		st.setInt(5, hit);
		st.setString(6,files);
		st.setInt(7, number);
		
		// ����  
		// ��� 1. execute����  2. execute������Ʈ
		// 1. execute����() - select 
		// ������  esecute������Ʈ(String sql) - insert , update , delete 
		
		int rowresult = st.executeUpdate(); // row ī��Ʈ ������ �˷��� 
		System.out.println("row ���� : " + rowresult);
		
		st.close();
		con.close();
	}
}

