package xyz.itwill.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//�ټ��� ���� �����ϰų� ����,���� �ϰ��� �� ��� �ϰ�ó��(Batch) ������ SQL ����� �����Ͽ� �Ѳ����� 
//SQL ����� ���ʴ�� �����Ͽ� �Ѳ����� �����ϴ� ��� - SQL ����� �ϰ�ó�� 
public class AddBatchApp {
	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionFactory.getConnection();
		
		String sql ="insert into student values(?,?,?,?,?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, 9000);
		pstmt.setString(2, "ȫ�淡");
		pstmt.setString(3, "010-5746-2278");
		pstmt.setString(4, "����� ������");
		pstmt.setString(5, "1996-05-07");
		//PreparedStatement.addBatch() : PreparedStatement �ν��Ͻ��� ����� SQL�����
		//�ϰ�ó�� ������ �߰��ϴ� �޼��� 
		pstmt.addBatch(); // ���� �Ѳ����� �ϰ�ó�� �Ѵ�. 
		
		pstmt.setInt(1, 9500);
		pstmt.setString(2, "�κ���");
		pstmt.setString(3, "010-3729-9952");
		pstmt.setString(4, "����� ������");
		pstmt.setString(5, "1995-03-02");
		pstmt.addBatch();
		
		//PreparedStatement.executeBatch() : �ϰ�ó�� ������ �߰��� ��� SQL ���(��) 
		// DBMS ������ �����Ͽ� �����ϴ� �޼��� - �������� �������� int[] �������� ��ȯ  
		int[] rows = pstmt.executeBatch();
		System.out.println("[���]" + rows.length + "�� �� �л������� �����Ͽ����ϴ�.");
		ConnectionFactory.close(con,pstmt);
	}
}
