package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeService {

	private String url = "jdbc:oracle:thin:@localhost:1522:orcl";
	private String uid = "scott";
	private String pwd = "tiger";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	// �˻��ϱ� ���� ���� ���� ? �ۼ��� ���̵� ? ����Ʈ�� ? - �װ� field �� 
	// �˻�� query 
	public List<Notice> getList(int page , String field , String query) throws ClassNotFoundException, SQLException {
					
		int start = 1 + (page-1)*10;	// 1,11,21,31,..
		int end = 10*page; // 10, 20, 30, 40...
		
//		String sql = "SELECT  * FROM (SELECT ROWNUM NUM, N.* FROM ( "
//				+ "    SELECT * FROM NOTICE ORDER BY REGDATE DESC) N "
//				+ ") "
//				+ "WHERE NUM BETWEEN ? AND ?"; // ����¡�� ���� ����  
		
		// ��ó���� �ϸ� ���ٷ� ������ �ִ�.
		// �並 �̿��ؼ� ����� ����Ҽ��ִ�. 
		String sql = "SELECT * FROM NOTICE_VIEW WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
									// �˻��Ҽ��ִ� �ʵ��ǰ� ���� �˻�
									// '%A%' �� ������ ä��Ÿ� ? �� �� 
									
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		// Statement st = con.createStatement();
		
		// sql���� WHERE ���� ? �� �ָ� 
		PreparedStatement st = con.prepareStatement(sql); 
		// ResultSet rs = st.executeQuery(sql);
		
		
		// ? �� ���� 
		st.setString(1, "%"+query+"%");// ù��° ����ǥ  ����˻� 
		st.setInt(2, start); // ����
		st.setInt(3, end); // ��
		
		ResultSet rs = st.executeQuery();
		
		List<Notice> list = new ArrayList<Notice>();
		while(rs.next()) { // �����°� ������ true
			String id = rs.getString("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			String files = rs.getString("FILES");
			
			Notice notice = new Notice(
					id,
					title,
					writerId,
					regDate,
					content,
					hit,
					files
				);
				list.add(notice);
				// ��� ���ڵ尡 ��� 
			System.out.printf("id:%s,title:%s,writerId%s,regDate:%s,content:%s,hit%d \n",
				id,title,writerId,regDate,content,hit);
		}
			rs.close();
			st.close();
			con.close();
			return list;
		}

		// Scalar ���� ���� ���´�. 
	public int getCount() throws SQLException, ClassNotFoundException {
		int count = 0;
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE"; // COUNT ��Ī�� ��������Ѵ�.
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		Statement st = con.createStatement();  // ��ȸ�� �ϴϱ� 
		ResultSet rs = st.executeQuery(sql); // �ѱ�°� ������ �Ű����� sql �� 
		
		if(rs.next()) // �����°� ������ ī��Ʈ�� ���´�.  
			count = rs.getInt("COUNT");
			rs.close();
			st.close();
			con.close();
			return count;
	}
	
	// ���� 
	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
		
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		int number = 0;
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		// ��ȸ���� 10�̻��� �Խù��θ� ���Ͻÿ� 
		String sql = "INSERT INTO NOTICE ( "
				+ "    id, "
				+ "    title, "
				+ "    writer_id, "
				+ "    content, "
				+ "    hit, "
				+ "    files, "
				+ "    pub "
				+ ") VALUES(?,?,?,?,?,?,?)"; // �������� SQL ������ �� ���´� 
		
		Class.forName(driver);

		Connection con = DriverManager.getConnection(url,uid,pwd);
		PreparedStatement st = con.prepareStatement(sql); // st.execute ���������ϵ� �׶� sql����������
								   // �̸� �������� �غ��ؼ� ���ุ �Ҽ��ְ� �غ�
		st.setString(1,title);// �������� �����Ҽ��ִ� �ɷ� 
		st.setString(2,writerId);// �������� �����Ҽ��ִ� �ɷ� 
		st.setString(3,content);// �������� �����Ҽ��ִ� �ɷ� 
		st.setString(4,files);
		// ����  
		// ��� 1. execute����  2. execute������Ʈ
		// 1. execute����() - select 
		// ������  esecute������Ʈ(String sql) - insert , update , delete 
		
		int result = st.executeUpdate(); // row ī��Ʈ ������ �˷��� 
		
		st.close();
		con.close();
		
		return result;
	}
	
	// ���� 
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		String id = notice.getId();
		
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		// ��ȸ���� 10�̻��� �Խù��θ� ���Ͻÿ� 
		String sql = "UPDATE NOTICE  " + 
				"SET" +
				"   TITLE=?, "
				+  "    CONTENT=?, "
				+  "    FILES=? "
				+  "   WHERE ID=?";
		
		Class.forName(driver);

		Connection con = DriverManager.getConnection(url,uid,pwd);
		PreparedStatement st = con.prepareStatement(sql); // st.execute ���������ϵ� �׶� sql����������
								   // �̸� �������� �غ��ؼ� ���ุ �Ҽ��ְ� �غ�
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setString(4, id);
	
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	// ���� 
	public int delete(int id) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		String sql = "DELETE NOTICE WHERE ID=?";  // ����� �߿� 
		
		Class.forName(driver);

		Connection con = DriverManager.getConnection(url,uid,pwd);
		PreparedStatement st = con.prepareStatement(sql); // st.execute ���������ϵ� �׶� sql����������
								   // �̸� �������� �غ��ؼ� ���ุ �Ҽ��ְ� �غ�
		st.setInt(1, id);
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return  result;
		}

	}
