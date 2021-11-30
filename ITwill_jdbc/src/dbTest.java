import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class dbTest {
	public dbTest() {}

	public static void main(String[] args) throws SQLException {	
		ArrayList<StudentDTO> arr = new ArrayList<>();
		
		Connection conn = null;
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1522:orcl";
		String id = "scott";
		String pwd = "tiger";
		// 1. 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbcUrl, id, pwd);
			String sql1 = "select * from studentdto";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql1);
			System.out.println("학생 리스트");

			while(rs.next()) {
				System.out.println("-----------------");
				System.out.println("학생 이름 : " + rs.getString("name"));
				System.out.println("학생 아이디 : " + rs.getInt("id"));
			}
			System.out.println("---------------------");			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}

