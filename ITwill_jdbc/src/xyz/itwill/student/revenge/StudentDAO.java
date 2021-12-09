package xyz.itwill.student.revenge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends JdbcDAO {
	
	private static StudentDAO dao;
	
	Connection con;
	PreparedStatement pstmt;
	int rows = 0;
	
	private StudentDAO() {
		con = null;
		pstmt = null;
	}
	
	static {
		dao = new StudentDAO();
	}
	
	
	// 기본생성자를 생성하면서 부모 클래스인  JdbcDAO 메서드를 다 가져올수있다. 
	public static StudentDAO getDAO() {
		
		if(dao != null) {
			dao = new StudentDAO();
		}
		return dao;
	}
	
	
	
	/*
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
	*/
	public int insertStudent(StudentDTO student) { // GUI 에서 입력한 것을 추가 
			
		int rows = 0;
		try {
			con = getConnection();
			String sql2 = "insert into student values(?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql2);
			
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows = pstmt.executeUpdate(); // 삽입 완료 
			
		} catch(SQLException e) {
			System.out.println("[에러] insertStudent() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드
	
	public int updateStudent(StudentDTO student) {
		try {	
			con = getConnection();
			String sql2 = "update student set name=? , phone=? , address=? , birthday=? where no = ? ";
			pstmt = con.prepareStatement(sql2);
			
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());
			rows = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("[에러] updateStudent() 메소드의 SQL 오류 " + e.getMessage());
		}
		return rows;
	}
	
	// 학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 삭제 하고 삭제행의 갯수를 반환 
	
	public int deleteStudent(int no) {
		try {
			con = getConnection();
			String sql2 = "delete from student where no = ?";
			pstmt = con.prepareStatement(sql2);
			rows  = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("[에러] deleteStudent() 메소드의 SQL 오류 " + e.getMessage());
		}
		return rows;
	}
	
	//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는 메소드
	// => 단일행 검색 : 검색행이 하나인 경우 값(기본형 또는 String) 또는 DTO 인스턴스 반환

	public StudentDTO selectNoStudent(int no) {
		StudentDTO student = new StudentDTO();
		try {
			con = getConnection();
			String sql3 = "select * from student where no=?";
			pstmt = con.prepareStatement(sql3);
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
			}
		} catch(Exception e) {
			System.out.println("[에러] selectNoStrung() 메소드의 SQL 오류  = " + e.getMessage());
		}
		return student;
	}
	
	//이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 반환하는 메소드
	// => 다중행 검색 : 검색행이 여러개인 경우 List 인스턴스 반환
	
	public List<StudentDTO> selectNameStudent(String name) {
		ResultSet rs = null;
		
		List<StudentDTO> arr = new ArrayList<StudentDTO>();
		StudentDTO student = new StudentDTO();
		
			try {
				con = getConnection();
				String sql3 = "select * from student where name = ? order by no ";
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1, name);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					student.setNo(rs.getInt("no"));
					student.setName(rs.getString("name"));
					student.setPhone(rs.getString("phone"));
					student.setAddress(rs.getString("address"));
					student.setBirthday(rs.getString("birthday"));
					
					arr.add(student);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}	
			return arr;
		}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
		
	public List<StudentDTO> selectAllStudent() {
		ResultSet rs = null;
		List<StudentDTO> arr = new ArrayList<StudentDTO>();
		
		try {
			con = getConnection();
			String sql3 = "select * from student order by no";
			pstmt = con.prepareStatement(sql3);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO student = new StudentDTO();
				// 데이터 가져와서 -> DTO 에 저장 -> List 에 추가
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
				arr.add(student);
			}			
		}catch(Exception e) {
			System.out.println("[에러] selectAllStudent() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return arr;
	}
	
	
	
	
}
