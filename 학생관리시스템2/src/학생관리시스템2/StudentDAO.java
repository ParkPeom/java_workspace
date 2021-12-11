package �л������ý���2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO : �����ü�� ���� �������� ����,����,����,�˻�(CRUD) ��� ����
// �޼ҵ�� �����ϴ� Ŭ����
// => �����ü : �����͸� ��(���ڵ�)���� ���� - File , DBMS 
// �������̽��� ��ӹ޾� �ۼ��ϴ� ���� �����Ѵ�. 


public class StudentDAO extends JdbcDAO implements StudentDAOAble{

	List<StudentDTO> studentList = new ArrayList<StudentDTO>();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int rows = 0;
	
	private static StudentDAO dao;
	
	// ������ ���� �Ұ� 
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
			System.out.println("[����] updateStudent() �޼ҵ��� sql ���� ");
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
			System.out.println("[����] deleteStudent() �޼ҵ��� SQL ���� ");
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
			System.out.println("[����] selectNoStudent() �޼ҵ��� SQL ���� = " + e.getMessage());
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
				// ���̺��� -> DTO ���� �ִ´�. -> ����Ʈ�� ��´�.
				StudentDTO student = new StudentDTO();
				
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
				
				studentList.add(student);
			}
		} catch(SQLException e ) {
			System.out.println("[����] selectAllStudent() �޼ҵ��� SQL ������ �߻��Ѵ�. ");
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
			System.out.println("[����]selectAllStudent() �޼ҵ��� sql");
		} finally {
			close(con, pstmt , rs);
		}
		return studentList;
	}
}
