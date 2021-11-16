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
		// 조회수가 10이상인 게시물로만 구하시오 
		String sql = "UPDATE NOTICE  " + 
				"SET" +
				"   TITLE=?, "
				+  "    CONTENT=?, "
				+  "    FILES=? "
				+  "   WHERE ID=?";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection(url,"scott","tiger");
		PreparedStatement st = con.prepareStatement(sql); // st.execute 쿼리실행하든 그때 sql전달했지만
								   // 미리 시쿼문을 준비해서 실행만 할수있게 준비
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

