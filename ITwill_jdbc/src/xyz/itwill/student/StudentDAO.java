package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO Ŭ���� 
// ���� DAOŬ�������� DAO�������̽��κ��� ��Ģ�� ���ϴ°� ������..
// Ư���� ��� �ƴϸ� �������̽� �ȸ��� 
// ȸ�翡�� �������̽� ����� DAO ����� �ϴ°� DAO ������ �����ε�

// ������ DAO ��Ű�� DTO ��Ű�� ���� ���� �����ϴ°� 

// DAO : �����Ϳ� �����ϱ� ���� ��ü �����ü�� ���� �������� ����,����,����,�˻�(CRUD) ����� �����ϴ� Ŭ����
// �޼���� �����ϴ� Ŭ���� 
// => �����ü : �����͸� ��(���ڵ�) ������ �����ϱ� ���� �ϵ���� �Ǵ� ����Ʈ���� - ex File , DBMS 
// => �������̽��� ��ӹ޾� �ۼ��ϴ� ���� ���� - DAO Ŭ������ �޼��� �ۼ� ��Ģ ���� : ���������� ȿ���� ����
// => �̱۵� Ŭ����(���α׷��� �ν��Ͻ��� �ϳ��� �����ϴ� Ŭ����)�� �ۼ��ϴ� ���� ����  

interface DAO {
	
}
// STUDENT ���̺� �л������� ����(����),����,����,�˻��ϴ� ����� �����ϴ� Ŭ����
// => DAO Ŭ������ �޼���� �ϳ��� SQL ����� �����Ͽ� ����� ����� ��ȯ�ϵ��� �ۼ� 
// DAO�� ���̺��� ������ŭ �־�� �Ѵ�. 
// => DBCP�κ��� Connection �ν��Ͻ��� DBCP�κ��� �����ްų� JDBC ���� �ν��Ͻ��� �����ϱ� ���� �޼��尡 
// ����� Ŭ������ ��ӹ޾� �ۼ�
public class StudentDAO extends JdbcDAO{
	// �̱��� ������ ������ ����� Ŭ���� �ۼ� ���
	// 1. Ŭ������ �ν��Ͻ��� �����ϱ� ���� �����ʵ� ���� - �ý��� �ʵ� 
	private static StudentDAO _dao;
	
	// 2. �����ڸ� ����ȭ �����Ѵ�
	private StudentDAO() {
		_dao = new StudentDAO();
	}
	
	// 3. ������������ Ŭ������ �ν��Ͻ��� �����Ͽ� �ý��� �ʵ忡 �����Ѵ�.
	static {
		_dao = new StudentDAO();
	}
	
	// 4. �ý��� �ʵ忡 ����� �ν��Ͻ��� ��ȯ�ϴ� ���� �޼��� ���� 
	public static StudentDAO getDAO() {
		// ���������� ����� �ۼ����� ���� ��� 
		/*
		if(_dao != null) {
			_dao = new StudentDAO();
		}
		*/
		return _dao;
	}
	
	// �л������� ���޹޾� STUDENT ���̺� ���ο� ������ ���ԵǾ� �л������� �����ϰ� ��������
	// ������ ��ȯ�ϴ� �޼���
	public int insertStudent(StudentDTO student) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// SQL ���(INSERT,UPDATE,DELETE)�� ���� ����� �����ϱ� ���� ���� - �������� ���� �����Ͽ� ��ȯ
		// => �������� ������ �����Ͽ� ��ȯ 
		int rows = 0;
		try {
			con = getConnection(); // �θ� 
			String sql = "insert into student values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			// ���޹��� �Ű������� ���� �̿��Ͽ� SQL ����� ������ ��ȯ 
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday().substring(0, 10));
			
			rows = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("[����]insertStudent() �޼����� SQL ���� = " + e.getMessage());
		} finally {
			close(con,pstmt);
		}
		return rows; // sql���ప�� ��ȯ���ָ� �ȴ�.
	}
	
	// �л������� ���޹޾� STUDENT ���̺� ����� �л������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼���
	public int updateStudent(StudentDTO student) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// SQL ���(INSERT,UPDATE,DELETE)�� ���� ����� �����ϱ� ���� ���� - �������� ���� �����Ͽ� ��ȯ
		// => �������� ������ �����Ͽ� ��ȯ 
		int rows = 0;
		try {
			con = getConnection(); // �θ� 
			String sql = "update student set name=?,phone=?,address=?,birthday=? where no=? ";
			pstmt = con.prepareStatement(sql);
			// ���޹��� �Ű������� ���� �̿��Ͽ� SQL ����� ������ ��ȯ 
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());
			rows = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("[����]insertStudent() �޼����� SQL ���� = " + e.getMessage());
		} finally {
			close(con,pstmt);
		}
		return rows; // sql���ప�� ��ȯ���ָ� �ȴ�.
	}
	
	// �й�(�⺻Ű)�� ���޹޾� STUDENT ���̺� ����� �ش� �й��� �л������� �����ϰ� �������� ������ ��ȯ�ϴ� �޼���
	public int deleteStudent(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// SQL ���(INSERT,UPDATE,DELETE)�� ���� ����� �����ϱ� ���� ���� - �������� ���� �����Ͽ� ��ȯ
		// => �������� ������ �����Ͽ� ��ȯ 
		int rows = 0;
		try {
			con = getConnection(); // �θ� 
			String sql = "delete from student where no=? ";
			pstmt = con.prepareStatement(sql);
			// ���޹��� �Ű������� ���� �̿��Ͽ� SQL ����� ������ ��ȯ 
			pstmt.setInt(1, no);
			rows = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("[����]insertStudent() �޼����� SQL ���� = " + e.getMessage());
		} finally {
			close(con,pstmt);
		}
		return rows; // sql���ప�� ��ȯ���ָ� �ȴ�.
	}
	
	// => ������ �˻� : �˻����� �ϳ��� ��� �� �Ǵ� DTO �ν��Ͻ� ��ȯ 
	public StudentDTO selectNoStudent(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDTO student = null; // NULL ��� 
		try {
			
			con = getConnection();		
			String sql = "select * from student where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			// �˻����� �ִ� ��� DTO �ν��Ͻ��� �����Ͽ� �˻������ DTO �ν��Ͻ��� �ʵ尪���� ���� 
			if(rs.next()) { 
				// DTO�ν��Ͻ��� �����Ͽ� ���������� ���� 
				student = new StudentDTO();  
				// �˻����� �÷������� DTO �ν��Ͻ��� �ʵ尪 ���� - �ʵ���� ó��(Oracl >> Java)
				student.setNo(rs.getInt("no"));  
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
			}
		} catch(SQLException e) {
			System.out.println("[����]insertStudent() �޼����� SQL ���� = " + e.getMessage());
		} finally {
			close(con,pstmt,rs);
		}
		return student;
	}
	
	
	// �̸��� ���޹޾� STUDENT ���̺� ����� �ش� �̸��� �л� ������ �˻��Ͽ� ��ȯ�ϴ� �޼���
	// => ������ �˻� : �˻����� �������� ��� List �ν��Ͻ� ��ȯ 
	public List<StudentDTO> selectNameStudent(String name) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StudentDTO> studentList = new ArrayList<StudentDTO>();
		// List�δ� �ν��Ͻ��� ����������� ArrayList�� ����
		try {
			con = getConnection();
			
			String sql = "select * from student where name=? order by no";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			StudentDTO student = null;
			
			// �л����� ������ 
			while(rs.next()) {
				student = new StudentDTO();  
				// �˻����� �÷������� DTO �ν��Ͻ��� �ʵ尪 ���� - �ʵ���� ó��(Oracl >> Java)
				student.setNo(rs.getInt("no"));  
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
				// List �ν��Ͻ��� ���(Element >> �л�����) �߰��Ͽ� �л� ���� ����
				studentList.add(student);
				
			}
		}catch(SQLException e) {
			System.out.println("[����] selectNameStudent() �޼����� SQL���� " + e.getMessage());
		} finally {
			close(con,pstmt,rs);
		}
		return studentList;
	}
	
	// STUDENT ���̺� ����� ��� �л������� �˻��Ͽ� ��ȯ�ϴ� �޼��� 
	public List<StudentDTO> selectAllStudent() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDTO student = null; // NULL ��� 
		List<StudentDTO> studentList=new ArrayList<StudentDTO>();
		try {
			
			con = getConnection();		
			String sql = "select * from student";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			// �˻����� �ִ� ��� DTO �ν��Ͻ��� �����Ͽ� �˻������ DTO �ν��Ͻ��� �ʵ尪���� ���� 
			while(rs.next()) { 
				// DTO�ν��Ͻ��� �����Ͽ� ���������� ���� 
				student = new StudentDTO();  
				// �˻����� �÷������� DTO �ν��Ͻ��� �ʵ尪 ���� - �ʵ���� ó��(Oracl >> Java)
				
				
				// DB�� �����͸� �����ͼ� DTO�� �߰��� 
				student.setNo(rs.getInt("no"));  
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
				
				// DTO�� �߰��Ȱ� �÷��ǿ� �߰��� 
				studentList.add(student);
			}
		} catch(SQLException e) {
			System.out.println("[����]insertStudent() �޼����� SQL ���� = " + e.getMessage());
		} finally {
			close(con,pstmt,rs);
		}
		return studentList;
	}
}		

