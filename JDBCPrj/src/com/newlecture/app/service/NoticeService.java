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
	
	// 검색하기 위한 기준 제목 ? 작성자 아이디 ? 컨텍트로 ? - 그걸 field 로 
	// 검색어가 query 
	public List<Notice> getList(int page , String field , String query) throws ClassNotFoundException, SQLException {
					
		int start = 1 + (page-1)*10;	// 1,11,21,31,..
		int end = 10*page; // 10, 20, 30, 40...
		
//		String sql = "SELECT  * FROM (SELECT ROWNUM NUM, N.* FROM ( "
//				+ "    SELECT * FROM NOTICE ORDER BY REGDATE DESC) N "
//				+ ") "
//				+ "WHERE NUM BETWEEN ? AND ?"; // 페이징에 대한 쿼리  
		
		// 뷰처리를 하면 한줄로 끝낼수 있다.
		// 뷰를 이용해서 목록을 출력할수있다. 
		String sql = "SELECT * FROM NOTICE_VIEW WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
									// 검색할수있는 필드의값 으로 검색
									// '%A%' 는 값으로 채울거면 ? 로 함 
									
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		// Statement st = con.createStatement();
		
		// sql문에 WHERE 절에 ? 를 주면 
		PreparedStatement st = con.prepareStatement(sql); 
		// ResultSet rs = st.executeQuery(sql);
		
		
		// ? 값 들어갈것 
		st.setString(1, "%"+query+"%");// 첫번째 물음표  제목검색 
		st.setInt(2, start); // 시작
		st.setInt(3, end); // 끝
		
		ResultSet rs = st.executeQuery();
		
		List<Notice> list = new ArrayList<Notice>();
		while(rs.next()) { // 가져온게 있으면 true
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
				// 모든 레코드가 출력 
			System.out.printf("id:%s,title:%s,writerId%s,regDate:%s,content:%s,hit%d \n",
				id,title,writerId,regDate,content,hit);
		}
			rs.close();
			st.close();
			con.close();
			return list;
		}

		// Scalar 단일 값을 얻어온다. 
	public int getCount() throws SQLException, ClassNotFoundException {
		int count = 0;
		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE"; // COUNT 별칭을 지어줘야한다.
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,uid,pwd);
		
		Statement st = con.createStatement();  // 조회만 하니까 
		ResultSet rs = st.executeQuery(sql); // 넘기는게 없으니 매개변수 sql 줌 
		
		if(rs.next()) // 가져온게 있으면 카운트를 얻어온다.  
			count = rs.getInt("COUNT");
			rs.close();
			st.close();
			con.close();
			return count;
	}
	
	// 삽입 
	public int insert(Notice notice) throws SQLException, ClassNotFoundException {
		
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		
		int number = 0;
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		// 조회수가 10이상인 게시물로만 구하시오 
		String sql = "INSERT INTO NOTICE ( "
				+ "    id, "
				+ "    title, "
				+ "    writer_id, "
				+ "    content, "
				+ "    hit, "
				+ "    files, "
				+ "    pub "
				+ ") VALUES(?,?,?,?,?,?,?)"; // 조건절은 SQL 쿼리문 에 적는다 
		
		Class.forName(driver);

		Connection con = DriverManager.getConnection(url,uid,pwd);
		PreparedStatement st = con.prepareStatement(sql); // st.execute 쿼리실행하든 그때 sql전달했지만
								   // 미리 시쿼문을 준비해서 실행만 할수있게 준비
		st.setString(1,title);// 쿼리문에 세팅할수있는 능력 
		st.setString(2,writerId);// 쿼리문에 세팅할수있는 능력 
		st.setString(3,content);// 쿼리문에 세팅할수있는 능력 
		st.setString(4,files);
		// 실행  
		// 경우 1. execute쿼리  2. execute업데이트
		// 1. execute쿼리() - select 
		// 조작은  esecute업데이트(String sql) - insert , update , delete 
		
		int result = st.executeUpdate(); // row 카운트 정수로 알려줌 
		
		st.close();
		con.close();
		
		return result;
	}
	
	// 수정 
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		String id = notice.getId();
		
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		// 조회수가 10이상인 게시물로만 구하시오 
		String sql = "UPDATE NOTICE  " + 
				"SET" +
				"   TITLE=?, "
				+  "    CONTENT=?, "
				+  "    FILES=? "
				+  "   WHERE ID=?";
		
		Class.forName(driver);

		Connection con = DriverManager.getConnection(url,uid,pwd);
		PreparedStatement st = con.prepareStatement(sql); // st.execute 쿼리실행하든 그때 sql전달했지만
								   // 미리 시쿼문을 준비해서 실행만 할수있게 준비
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setString(4, id);
	
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	// 삭제 
	public int delete(int id) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		String sql = "DELETE NOTICE WHERE ID=?";  // 빈공간 중요 
		
		Class.forName(driver);

		Connection con = DriverManager.getConnection(url,uid,pwd);
		PreparedStatement st = con.prepareStatement(sql); // st.execute 쿼리실행하든 그때 sql전달했지만
								   // 미리 시쿼문을 준비해서 실행만 할수있게 준비
		st.setInt(1, id);
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		return  result;
		}

	}
