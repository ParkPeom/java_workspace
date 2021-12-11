package 학생관리시스템2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO : 저장매체에 대한 행정보의 저장,변경,삭제,검색(CRUD) 기능 제공
// 메소드로 제공하는 클래스
// => 저장매체 : 데이터를 행(레코드)단위 저장 - File , DBMS 
// 인터페이스를 상속받아 작성하는 것을 권장한다. 


public class StudentDAO extends JdbcDAO implements StudentDAOAble{

	List<StudentDTO> studentList = new ArrayList<StudentDTO>();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int rows = 0;
	
	private static StudentDAO dao;
	
	// 생성자 생성 불가 
	private StudentDAO() {
		
	}
	
	static {
		dao = new StudentDAO();
	}
	
	public static StudentDAO getDAO() {
		return dao;
	}
	
	@Override
	public int insertStudent(StudentDTO student) {
		
		int rows = 0;
		try {
			con = getConnection();
			String sql = "insert into student values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt);
		}
		return rows;
	}

	@Override
	public int updateStudent(StudentDTO student) {
		
		int rows = 0;
		try {
			con = getConnection();
			String sql = "update student set name = ? , phone = ? , address = ? , birthday = ? where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러] updateStudent() 메소드의 sql 오류 ");
		} finally {
			close(con,pstmt);
		}		
		return rows;
	}
	@Override
	public int deleteStudent(int no) {
		int rows = 0;
		try {
			con = getConnection();
			String sql = "delete from student where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rows = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("[에러] deleteStudent() 메소드의 SQL 오류 ");
		} finally {
			close(con,pstmt);
		}
		return rows;
	}

	@Override
	public StudentDTO selectNoStudent(int no) {
		
		con = getConnection();
		String sql = "select * from student where no = ? ";
		StudentDTO student = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				student = new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
			}
		} catch (SQLException e) {
			System.out.println("[에러] selectNoStudent() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return student;
	}

	@Override
	public List<StudentDTO> selectNameStudent(String name) {
		
		try { 
			con = getConnection();
			String sql = "select * from student order by no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 테이블값을 -> DTO 값에 넣는다. -> 리스트에 담는다.
				StudentDTO student = new StudentDTO();
				
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
				
				studentList.add(student);
			}
		} catch(SQLException e ) {
			System.out.println("[에러] selectAllStudent() 메소드의 SQL 오류가 발생한다. ");
		} finally {
			close(con,pstmt,rs);
		}
		return studentList;
	}
	
	public List<StudentDTO> selectAllStudent() {
		List<StudentDTO> studentList = new ArrayList<StudentDTO>();
		
		try {
			con = getConnection();
			String sql = "select * from student order by no";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); // 
			
			while(rs.next()) {
				StudentDTO student = new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
				
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllStudent() 메소드의 sql");
		} finally {
			close(con, pstmt , rs);
		}
		return studentList;
	}
}
