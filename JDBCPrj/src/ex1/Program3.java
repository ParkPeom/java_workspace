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

public class Program3 {
	public Program3() {}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String title = "newlec3";
		String content = "hahaha3";
		String files = "";
		String id = "8";
		
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		// ��ȸ���� 10�̻��� �Խù��θ� ���Ͻÿ� 
		String sql = "UPDATE NOTICE  " + 
				"SET" +
				"   TITLE=?, "
				+  "    CONTENT=?, "
				+  "    FILES=? "
				+  "   WHERE ID=?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection(url,"scott","tiger");
		PreparedStatement st = con.prepareStatement(sql); // st.execute ���������ϵ� �׶� sql����������
								   // �̸� �������� �غ��ؼ� ���ุ �Ҽ��ְ� �غ�
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setString(4, id);
	
		int rowresult = st.executeUpdate();
		System.out.println(rowresult);
		
		st.close();
		con.close();
	}
}

