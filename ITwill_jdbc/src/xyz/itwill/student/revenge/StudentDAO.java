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
	
	
	// �⺻�����ڸ� �����ϸ鼭 �θ� Ŭ������  JdbcDAO �޼��带 �� �����ü��ִ�. 
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
	public int insertStudent(StudentDTO student) { // GUI ���� �Է��� ���� �߰� 
			
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
			
			rows = pstmt.executeUpdate(); // ���� �Ϸ� 
			
		} catch(SQLException e) {
			System.out.println("[����] insertStudent() �޼ҵ��� SQL ���� = " + e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//�л������� ���޹޾� STUDENT ���̺� ����� �л������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼ҵ�
	
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
			System.out.println("[����] updateStudent() �޼ҵ��� SQL ���� " + e.getMessage());
		}
		return rows;
	}
	
	// �й��� ���޹޾� STUDENT ���̺� ����� �ش� �й��� �л������� ���� �ϰ� �������� ������ ��ȯ 
	
	public int deleteStudent(int no) {
		try {
			con = getConnection();
			String sql2 = "delete from student where no = ?";
			pstmt = con.prepareStatement(sql2);
			rows  = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("[����] deleteStudent() �޼ҵ��� SQL ���� " + e.getMessage());
		}
		return rows;
	}
	
	//�й��� ���޹޾� STUDENT ���̺� ����� �ش� �й��� �л������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => ������ �˻� : �˻����� �ϳ��� ��� ��(�⺻�� �Ǵ� String) �Ǵ� DTO �ν��Ͻ� ��ȯ

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
			System.out.println("[����] selectNoStrung() �޼ҵ��� SQL ����  = " + e.getMessage());
		}
		return student;
	}
	
	//�̸��� ���޹޾� STUDENT ���̺� ����� �ش� �̸��� �л������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => ������ �˻� : �˻����� �������� ��� List �ν��Ͻ� ��ȯ
	
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
	
	//STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
		
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
				// ������ �����ͼ� -> DTO �� ���� -> List �� �߰�
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
				arr.add(student);
			}			
		}catch(Exception e) {
			System.out.println("[����] selectAllStudent() �޼ҵ��� SQL ���� = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return arr;
	}
	
	
	
	
}
