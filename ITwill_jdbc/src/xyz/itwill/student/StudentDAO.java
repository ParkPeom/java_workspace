package xyz.itwill.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO 클래스 
// 보통 DAO클래스들은 DAO인터페이스로부터 규칙을 정하는게 좋은데..
// 특별한 경우 아니면 인터페이스 안만듬 
// 회사에서 인터페이스 만들고 DAO 만들고 하는게 DAO 디자인 패턴인데

// 정석은 DAO 패키지 DTO 패키지 따로 만들어서 관리하는게 

// DAO : 데이터에 접근하기 위한 객체 저장매체에 대한 행정보의 저장,변경,삭제,검색(CRUD) 기능을 제공하는 클래스
// 메서드로 제공하는 클래스 
// => 저장매체 : 데이터를 행(레코드) 단위로 저장하기 위한 하드웨어 또는 소프트웨어 - ex File , DBMS 
// => 인터페이스를 상속받아 작성하는 것을 권장 - DAO 클래스의 메서드 작성 규칙 제공 : 유지보수의 효율성 증가
// => 싱글돈 클래스(프로그램에 인스턴스를 하나만 제공하는 클래스)로 작성하는 것을 권장  

interface DAO {
	
}
// STUDENT 테이블에 학생정보를 삽입(저장),변경,삭제,검색하는 기능을 제공하는 클래스
// => DAO 클래스의 메서드는 하나의 SQL 명령을 전달하여 실행된 결과를 반환하도록 작성 
// DAO는 테이블의 개수만큼 있어야 한다. 
// => DBCP로부터 Connection 인스턴스를 DBCP로부터 제공받거나 JDBC 관련 인스턴스를 제거하기 위한 메서드가 
// 선언된 클래스를 상속받아 작성
public class StudentDAO extends JdbcDAO{
	// 싱글톤 디자인 패턴이 적용된 클래스 작성 방법
	// 1. 클래스의 인스턴스의 저장하기 위한 정적필드 선언 - 시스템 필드 
	private static StudentDAO _dao;
	
	// 2. 생성자를 은닉화 선언한다
	private StudentDAO() {
		_dao = new StudentDAO();
	}
	
	// 3. 정적영역에서 클래스의 인스턴스를 생성하여 시스템 필드에 저장한다.
	static {
		_dao = new StudentDAO();
	}
	
	// 4. 시스템 필드에 저장된 인스턴스를 반환하는 정적 메서드 선언 
	public static StudentDAO getDAO() {
		// 정적영역에 명령을 작성하지 않을 경우 
		/*
		if(_dao != null) {
			_dao = new StudentDAO();
		}
		*/
		return _dao;
	}
	
	// 학생정보를 전달받아 STUDENT 테이블에 새로운 행으로 삽입되어 학생정보를 저장하고 삽입행의
	// 갯수를 반환하는 메서드
	public int insertStudent(StudentDTO student) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// SQL 명령(INSERT,UPDATE,DELETE)의 실행 결과를 저장하기 위한 변수 - 조작행의 갯수 저장하여 반환
		// => 조작행의 갯수를 저장하여 반환 
		int rows = 0;
		try {
			con = getConnection(); // 부모꺼 
			String sql = "insert into student values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			// 전달받은 매개변수의 값을 이용하여 SQL 명령의 값으로 변환 
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday().substring(0, 10));
			
			rows = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("[에러]insertStudent() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con,pstmt);
		}
		return rows; // sql실행값을 반환해주면 된다.
	}
	
	// 학생정보를 전달받아 STUDENT 테이블에 저장된 학생정보를 변경하고 변경행의 갯수를 반환하는 메서드
	public int updateStudent(StudentDTO student) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// SQL 명령(INSERT,UPDATE,DELETE)의 실행 결과를 저장하기 위한 변수 - 조작행의 갯수 저장하여 반환
		// => 조작행의 갯수를 저장하여 반환 
		int rows = 0;
		try {
			con = getConnection(); // 부모꺼 
			String sql = "update student set name=?,phone=?,address=?,birthday=? where no=? ";
			pstmt = con.prepareStatement(sql);
			// 전달받은 매개변수의 값을 이용하여 SQL 명령의 값으로 변환 
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());
			rows = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("[에러]insertStudent() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con,pstmt);
		}
		return rows; // sql실행값을 반환해주면 된다.
	}
	
	// 학번(기본키)를 전달받아 STUDENT 테이블에 저장된 해당 학번의 학생정보를 삭제하고 삭제행의 갯수를 반환하는 메서드
	public int deleteStudent(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// SQL 명령(INSERT,UPDATE,DELETE)의 실행 결과를 저장하기 위한 변수 - 조작행의 갯수 저장하여 반환
		// => 조작행의 갯수를 저장하여 반환 
		int rows = 0;
		try {
			con = getConnection(); // 부모꺼 
			String sql = "delete from student where no=? ";
			pstmt = con.prepareStatement(sql);
			// 전달받은 매개변수의 값을 이용하여 SQL 명령의 값으로 변환 
			pstmt.setInt(1, no);
			rows = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("[에러]insertStudent() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con,pstmt);
		}
		return rows; // sql실행값을 반환해주면 된다.
	}
	
	// => 단일행 검색 : 검색행이 하나인 경우 값 또는 DTO 인스턴스 반환 
	public StudentDTO selectNoStudent(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDTO student = null; // NULL 대신 
		try {
			
			con = getConnection();		
			String sql = "select * from student where no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			// 검색행이 있는 경우 DTO 인스턴스를 생성하여 검색결과를 DTO 인스턴스의 필드값으로 변경 
			if(rs.next()) { 
				// DTO인스턴스를 생성하여 참조변수에 저장 
				student = new StudentDTO();  
				// 검색행의 컬럼값으로 DTO 인스턴스의 필드값 변경 - 필드매핑 처리(Oracl >> Java)
				student.setNo(rs.getInt("no"));  
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
			}
		} catch(SQLException e) {
			System.out.println("[에러]insertStudent() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con,pstmt,rs);
		}
		return student;
	}
	
	
	// 이름을 전달받아 STUDENT 테이블에 저장된 해당 이름의 학생 정보를 검색하여 반환하는 메서드
	// => 다중행 검색 : 검색행이 여러개인 경우 List 인스턴스 반환 
	public List<StudentDTO> selectNameStudent(String name) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<StudentDTO> studentList = new ArrayList<StudentDTO>();
		// List로는 인스턴스를 만들수없으니 ArrayList로 만듬
		try {
			con = getConnection();
			
			String sql = "select * from student where name=? order by no";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			StudentDTO student = null;
			
			// 학생들이 있으면 
			while(rs.next()) {
				student = new StudentDTO();  
				// 검색행의 컬럼값으로 DTO 인스턴스의 필드값 변경 - 필드매핑 처리(Oracl >> Java)
				student.setNo(rs.getInt("no"));  
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
				// List 인스턴스에 요소(Element >> 학생정보) 추가하여 학생 정보 저장
				studentList.add(student);
				
			}
		}catch(SQLException e) {
			System.out.println("[에러] selectNameStudent() 메서드의 SQL오류 " + e.getMessage());
		} finally {
			close(con,pstmt,rs);
		}
		return studentList;
	}
	
	// STUDENT 테이블에 저장된 모든 학생정보를 검색하여 반환하는 메서드 
	public List<StudentDTO> selectAllStudent() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDTO student = null; // NULL 대신 
		List<StudentDTO> studentList=new ArrayList<StudentDTO>();
		try {
			
			con = getConnection();		
			String sql = "select * from student";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			// 검색행이 있는 경우 DTO 인스턴스를 생성하여 검색결과를 DTO 인스턴스의 필드값으로 변경 
			while(rs.next()) { 
				// DTO인스턴스를 생성하여 참조변수에 저장 
				student = new StudentDTO();  
				// 검색행의 컬럼값으로 DTO 인스턴스의 필드값 변경 - 필드매핑 처리(Oracl >> Java)
				
				
				// DB에 데이터를 가져와서 DTO에 추가함 
				student.setNo(rs.getInt("no"));  
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday").substring(0, 10));
				
				// DTO에 추가된걸 컬렉션에 추가함 
				studentList.add(student);
			}
		} catch(SQLException e) {
			System.out.println("[에러]insertStudent() 메서드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con,pstmt,rs);
		}
		return studentList;
	}
}		

