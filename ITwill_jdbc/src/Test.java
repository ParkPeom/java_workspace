import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	
	public static void main(String[] args) {
		
		Connection con = null;
		Statement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String id = "scott";
			String pwd = "tiger";
			String sql = "select * from student";
			
			con = DriverManager.getConnection(url, id, pwd);
			pstmt= con.createStatement();
			rs = pstmt.executeQuery(sql);
			
			
			while(rs.next()) {
				
				String str = rs.getString("birthday");
				
				System.out.println("학번 : " + rs.getInt("no")
				+ "이름 : " + rs.getString("name") 
				+ "전화번호 : " + rs.getString("phone")
				+ "주소 : " + rs.getString("address")
				+ "생년월일 : " + str.substring(0,10));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		}
	}
}
