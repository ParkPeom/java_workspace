package main.webapp;

import java.sql.DriverManager; 
import java.sql.SQLException;
public class OracleEx01 {
	public static void main(String[] args) {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1522:orcl";
    String user = "scott"; 
    String password = "tiger";
   
    try { 
    	Class.forName(driver);
    	System.out.println("jdbc driver �ε� ����");
    	DriverManager.getConnection(url, user, password);
    	System.out.println("����Ŭ ���� ����"); 
    } catch (ClassNotFoundException e) {
      	System.out.println("jdbc driver �ε� ����"); 
    } catch (SQLException e) {
    	System.out.println("����Ŭ ���� ����");
    	}
	} 
}