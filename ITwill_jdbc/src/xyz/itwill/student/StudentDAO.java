package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO(Data Access Object) 클래스 : 저장매체에 대한 행정보의 저장,변경,삭제,검색(CRUD) 기능을 
//메소드로 제공하는 클래스
// => 저장매체 : 데이타를 행(레코드) 단위로 저장하여 처리하기 위한 하드웨어 또는 소프트웨어 - ex)File, DBMS 등
// => 인터페이스를 상속받아 작성하는 것을 권장 - DAO 클래스의 메소드 작성 규칙 제공 : 유지보수의 효율성 증가
// => 싱글톤 클래스(프로그램에 인스턴스를 하나만 제공하는 클래스)로 작성하는 것을 권장

//STUDENT 테이블에 학생정보(행)를 삽입(저장),변경,삭제,검색하는 기능을 제공하는 클래스
// => DAO 클래스의 메소드는 하나의 SQL 명령을 전달하여 실행된 결과를 반환하도록 작성
// => DBCP로부터 Connection 인스턴스를 제공받거나 JDBC 관련 인스턴스를 제거하기 위한 메소드가
//    선언된 클래스를 상속받아 작성
public class StudentDAO extends JdbcDAO {
	//싱글톤 디자인 패턴이 적용된 클래스 작성 방법
	//1.클래스의 인스턴스를 저장하기 위한 정적필드 선언 - 시스템 필드
	private static StudentDAO _dao;
	
	//2.생성자를 은닉화 선언 - 클래스 외부에서 인스턴스 생성 불가능
	private StudentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	//3.정적영역에서 클래스의 인스턴스를 생성하여 시스템 필드에 저장
	static {
		_dao=new StudentDAO();
	}
	
	//4.시스템 필드에 저장된 인스턴스를 반환하는 정적 메소드 선언
	public static StudentDAO getDAO() {
		/*
		//정적영역에 명령을 작성하지 않을 경우
		if(_dao!=null) {
			_dao=new StudentDAO();
		}
		*/
		
		return _dao;
	}
	
	//학생정보를 전달받아 STUDENT 테이블에 새로운 행으로 삽입하여 저장하고 삽입행의 갯수를 반환하는 메소드
	public int insertStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		//SQL 명령(INSERT,UPDATE,DELETE)의 실행 결과를 저장하기 위한 지역변수 
		// => 조작행의 갯수를 저장하여 반환
		int rows=0;
		try {
			con=getConnection();
			
			String sql="insert into student values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			//전달받은 매개변수의 값을 이용하여 SQL 명령의 값으로 변환
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertStudnet() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;		
	}
		
	//학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateStudent(StudentDTO student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="update student set name=?,phone=?,address=?,birthday=? where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int deleteStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql="delete from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]deleteStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//학번을 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 검색하여 반환하는 메소드
	// => 단일행 검색 : 검색행이 하나인 경우 값(기본형 또는 String) 또는 DTO 인스턴스 반환
	public StudentDTO selectNoStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StudentDTO student=null;
		try {
			con=getConnection();
			
			String sql="select * from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs=pstmt.executeQuery();
			
			//검색행이 있는 경우 DTO 인스턴스를 생성하여 검색결과를 DTO 인스턴스의 필드값으로 변경
			if(rs.next()) {
				//DTO 인스턴스를 생성하여 참조변수에 저장
				student=new StudentDTO();
				//검색행의 컬럼값으로 DTO 인스턴스의 필드값 변경
				// => 필드 매핑 처리 : Oracle(행 - 컬럼값) >> Java(인스턴스 - 필드값)
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectNoStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return student;
	}
	
	
	//이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생정보를 검색하여 반환하는 메소드
	// => 다중행 검색 : 검색행이 여러개인 경우 List 인스턴스 반환
	public List<StudentDTO> selectNameStudent(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<StudentDTO>();
		try {
			con=getConnection();
			
			String sql="select * from student where name=? order by no";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO student=new StudentDTO();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
				//List 인스턴스에 요소(Element >> 학생정보) 추가하여 저장
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectNameStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return studentList;
	}
	
	//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메소드
	public List<StudentDTO> selectAllStudent() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentDTO> studentList=new ArrayList<StudentDTO>();
		try {
			con=getConnection();
			
			String sql="select * from student order by no";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				StudentDTO student=new StudentDTO();
				// 데이터 가져와서 -> DTO -> List 에 추가 	
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0,10));
				studentList.add(student);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return studentList;
	}
}

	

