package 손님데이터저장프로그램;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {
	public static void main(String[] args) {
//		createTable();
//		createCustomer("Danny","123456789","Male","23","Random Note...");
//
//		ArrayList<String> list = getCustomers();
//
//		for(String item : list) {
//			System.out.println(item);
//		}
//
//		// 정보를 읽고 쓰고 불러올수 있다. 
//		
//		createCustomer("David","4441122211","FeMale","25","Important Customer...");
//		
//		list = getCustomers();
//		for(String item : list) {
//			System.out.println(item);
//		}
	}
	
	public static String[][] getCustomers() {
		try {
			Connection con = getConnection();
			String sql = "select name , phone , gender , age , note from customer";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			
			while(rs.next()) {
				list.add(new String[] { rs.getString("name"),
						rs.getString("phone"),
						rs.getString("gender"),
						rs.getString("age"),
						rs.getString("note")});		
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5]; // 5칸 name , phone , gender , age , note
		
			return list.toArray(arr);
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static void createCustomer(String name,String phone, String gender, String age , String note) {
		
		try {
			Connection con = getConnection();
			String sql = "insert into customer values(ID.NEXTVAL,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, gender);
			pstmt.setString(4, age);
			pstmt.setString(5, note);
			int rows = pstmt.executeUpdate();
			System.out.println( rows + " 행이 업데이트 하였습니다.");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void createTable() {
		try {
			Connection con = getConnection();
			PreparedStatement createTable = con.prepareStatement(
					"create table customer(id number primary key"
					+ ", name varchar2(255)"
					+ ", phone varchar2(255)"
					+ ", gender varchar2(255)"
					+ ", age varchar2(255)"
					+ ",note varchar2(255))"
				);
			createTable.execute();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Table Successfully created");
		}
	}
	public static Connection getConnection() {
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1522:orcl";
			String user = "scott";
			String pass = "tiger";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("The Connection Successful");
			return con;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return null; // 연결 실패시 
		}
	}
}
