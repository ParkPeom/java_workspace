import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Customer {
	public static void main(String[] args) {
		//getConnection();
		createTable();
	}
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(
					"create table if not exists customer(id int not null , auto_increment,"
					+ "name varchar2(255),"
					+ "phone varchar2(255),"
					+ "gender varchar2(255),"
					+ "age varchar2(255),"
					+ "note varchar2(255),"
					+ "primary key(id))");
			create.execute();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Table successfully created");
		}
	}
	public static Connection getConnection() {
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String user ="scott";
			String pwd = "tiger";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("The Connection Success");
			return con;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
