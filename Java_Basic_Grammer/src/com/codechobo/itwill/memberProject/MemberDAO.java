package com.codechobo.itwill.memberProject;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends DBConn {

	public MemberDAO() {		
	}
	//레코드 전체선택
	public List<MemberVO> getAllSelect() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			getConn();
			String sql = "select num, username, tel, email, addr, writedate from member2 order by num desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				list.add(vo);
			}			
		}catch(Exception e) {}
		finally {setDBClose();}
		return list;
	}
	//레코드 추가
	public void setInsert(MemberVO vo) {
		
		try {
			getConn();
			String sql = "insert into member2 values(a_sq.nextval,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			System.out.println(vo.getEmail());
			pstmt.setString(1,  vo.getUsername());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getAddr());
			
			//java.sql.Date now = new java.sql.Date(2018,5,10);
			//pstmt.setString(5, "2019-10-23" );
			vo.setCount(pstmt.executeUpdate());
			
		}catch(Exception e) {e.printStackTrace();}	
		finally {setDBClose();}
	}
	//레코드 수정
	public void setUpdate(MemberVO vo) {
		try {
			getConn();
			String sql = "update member2     "
					+ " set username=?, tel=?, email=?, addr=? "
					+ " where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUsername());
			pstmt.setString(2,  vo.getTel());
			pstmt.setString(3,  vo.getEmail());	
			pstmt.setString(4,  vo.getAddr());
		
			pstmt.setInt(5, vo.getNum());
			
			vo.setCount(pstmt.executeUpdate());
		}catch(Exception e) {e.printStackTrace();}
		finally {setDBClose();}
	}
	//레코드 삭제
	public int setDelete(int num) {
		int count=0;
		try {
			getConn();
			String sql = "delete from member2 where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num); 
			count = pstmt.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {setDBClose();}
		return count;
	}
	public List<MemberVO> getSearchRecord(String searchWord) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			getConn();
			String sql = "select num, username,  tel, email, addr, writedate "
					+ "from member "
					+ "where username like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt(1));
				vo.setUsername(rs.getString(2));				
				vo.setTel(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setAddr(rs.getString(5));
				vo.setWritedate(rs.getString(6));
				list.add(vo);
			}			
		}catch(Exception e) {e.printStackTrace();}
		finally {setDBClose();}
		return list;
	}
}








