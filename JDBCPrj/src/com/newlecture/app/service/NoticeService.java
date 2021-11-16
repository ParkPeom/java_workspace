package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoticeService {

	public List<Notice> getList() throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		String sql = "SELECT * FROM NOTICE"; 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"scott","tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		List<Notice> list = new ArrayList<Notice>();
		
		while(rs.next()) { // 가져온게 있으면 true
			String id = rs.getString("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("hit");
			
			Notice notice = new Notice(
					id,
					title,
					writerId,
					regDate,
					content,
					hit
				);
				list.add(notice);
				// 모든 레코드가 출력 
			System.out.printf("id:%d,title:%s,writerId%s,regDate:%s,content:%s,hit%d \n",
				id,title,writerId,regDate,content,hit);
		}
		rs.close();
		st.close();
		con.close();
		return list;
	}

	
	// 삽입 
	public int insert(Notice notice) {
		return 0;
	}
	
	// 수정 
	public int update(Notice notice) {
		return 0;
	}

	// 삭제 
	public int delete(int id) {
		return  0;
		}
	}
