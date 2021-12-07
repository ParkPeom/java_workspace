package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection 
{
    public static Connection dbConn; // interface Connection
    
        public static Connection getConnection()
        {
            Connection conn = null; // �����ͺ��̽��� ����� ���� ������ �� 
            						// �� ������ �̿��Ͽ� �����ͺ��̽��� SQL�� �����ϰ� 
            						// �װ���� ResultSet��ü�� ��� ����. 
            try {
                String user = "scott"; 
                String pw = "tiger"; // ������ ��й�ȣ 
                String url = "jdbc:oracle:thin:@localhost:1522:orcl"; // ������ DB �ּ�
                			// 1. jdbc:oracle:thin  ����Ŭ�� �����ϰڴٰ� �˷���
                			// 2. @localhost �ڽ��� IP�ּ�
                			// 3. 1522 ��Ʈ��ȣ
                			// 4. DB�̸� 
                Class.forName("oracle.jdbc.driver.OracleDriver"); 
                // JDBC ����̹�(ojdbc8.jar)�� �ε��ϴ� �κ��̴�. �ε����н� catch�� 
                conn = DriverManager.getConnection(url, user, pw);
                // �Էµ� ����Ŭ ����,��й�ȣ,�ּ� �������� ����Ŭ�� ���� 
                // ���� ���н� SQLEXception �߻� getConnection()�޼���� Connection�� ��ȯ
                System.out.println("Database�� ����Ǿ����ϴ�.\n");   
            } catch (ClassNotFoundException cnfe) {
                System.out.println("DB ����̹� �ε� ���� :"+cnfe.toString());
            } catch (SQLException sqle) {
                System.out.println("DB ���ӽ��� : "+sqle.toString());
            } catch (Exception e) {
                System.out.println("Unkonwn error");
                e.printStackTrace();
            }
            return conn;     
        }
}

