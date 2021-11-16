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

public class Program4 {
	public Program4() {}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String id = "8";
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		// ��ȸ���� 10�̻��� �Խù��θ� ���Ͻÿ� 
		String sql = "DELETE NOTICE WHERE ID=?";  // ����� �߿� 
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection(url,"scott","tiger");
		PreparedStatement st = con.prepareStatement(sql); // st.execute ���������ϵ� �׶� sql����������
								   // �̸� �������� �غ��ؼ� ���ุ �Ҽ��ְ� �غ�
		st.setString(1, id);
		
		int rowresult = st.executeUpdate();
		System.out.println(rowresult);
		
		st.close();
		con.close();
	}
}

