import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {

	
//	public static void main(String[] args) {
//		//getConnection();
//		//createTable();
//		// createCustomer2(1,"Danny","123456789","Male","23","Random Note....");	
//		ArrayList<String> list = getCustomer();
//		for(String item : list) {
//			System.out.println(item);
//		}
//	}
	
	public static void createCustomer2(int id , String name, String phone, String gender,String age,String note) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement("insert into customer2 "
					+ "(id,name,phone,gender,age,note)"
					+ "values ('"+id+"','"+name+"','"+phone+"','"+gender+"','"+age+"','"+note+"')");
				//('name','phone','gender','note')
			insert.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static ArrayList<String> getCustomer() {
		try { 
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement(""
					+ "select name, phone, gender from customer2");
			ResultSet rs = statement.executeQuery();
			
			ArrayList<String> list = new ArrayList<String>();
			
			while(rs.next()) {
				list.add("Name : " + rs.getString("name")
				+" phone = " + rs.getString("phone") 
				+" gender = " + rs.getString("gender")
				);
			}
			System.out.println("The data has benn fetched");	
			return list;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public static void createTable() { // 테이블 생성 
 		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement(
					"create table customer2 (id number(20) ,"
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
