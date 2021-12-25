package 학생관리시스템3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MemberDAO {
	private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";	
	private static final String URL ="jdbc:oracle:thin:@1522:orcl";
	private static final String USER ="scott";
	private static final String PASS ="tiger";
	
	Member_List mList;
	public MemberDAO() {
	}
	public MemberDAO(Member_List mList) {
		this.mList = mList;
		System.out.println("DAO=>"+mList);
	}
	/*DB연결 메소드*/
	public Connection getConn() {
		Connection con = null;
		
		try {
		Class.forName(DRIVER); //드라이버 로딩
			con = DriverManager.getConnection(URL, USER, PASS); // 2. 드라이버 연결
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return con;
	}
	/* 한사람의 회원 정보를 얻는 메소드*/
	public MemberDTO getMemberDTO(String id) throws SQLException {
		MemberDTO dto = new MemberDTO();
		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null;   // 결과
		rs = ps.executeQuery(); // select 질의문	
		if(rs.next()) {
			dto.setId(rs.getString("id"));
			dto.setPwd(rs.getString("Pwd"));
			dto.setName(rs.getString("Name"));
			dto.setTel(rs.getString("tel"));
			dto.setAddr(rs.getString("addr"));
			dto.setBirth(rs.getString("birth"));
			dto.setJob(rs.getString("job"));
			dto.setGender(rs.getString("gender"));
			dto.setEmail(rs.getString("email"));
			dto.setIntro(rs.getString("intro"));
		  }
		try {
		}catch(Exception e) {
			e.printStackTrace();
		}
	return dto;
	}
	
	/*멤버 리스트 출력*/
	public Vector getMemberList() {
		
		Vector data = new Vector(); // Jtable에 값을 쉽게 넣는 방법
		Connection con = null; // 연결
		PreparedStatement pstmt = null; // 명령
		ResultSet rs = null; // 결과
		try {
			con = getConn();
			String sql = "select * from tb_member order by name asc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				String birth = rs.getString("birth");
				String gender = rs.getString("gender");
				String job = rs.getString("job");
				String email = rs.getString("email");
				String intro = rs.getString("intro");
				
				Vector row = new Vector();
				row.add(id);
				row.add(pwd);
				row.add(name);
				row.add(tel);
				row.add(addr);
				row.add(birth);
				row.add(job);
				row.add(gender);
				row.add(email);
				row.add(intro);
				
				data.add(row); // 백터배열에 행 추가 
			} // while
		} catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/*회원 등록*/
	public boolean insertMember(MemberDTO dto) {
		boolean ok = false;
		Connection con = null; // 연결
		PreparedStatement pstmt = null; // 명령
		
		try {
			con = getConn();
			String sql = "insert into tb_member (id,pwd,name,tel,addr,birth,job,gender,email,intro) values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getAddr());
			pstmt.setString(6, dto.getId());
			pstmt.setString(1, dto.getId());
			pstmt.setString(1, dto.getId());
			pstmt.setString(1, dto.getId());
			pstmt.setString(1, dto.getId());
			
			int r = pstmt.executeUpdate(); // 실행 -> 저장 
			
			if(r>0) {
				System.out.println("가입 성공");
				ok = true;
			} else {
				System.out.println("가입 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		/*회원정보 수정*/
		return ok;
	}
	public boolean updateMember(MemberDTO Mem) {
		System.out.println("dto="+Mem.toString());
		boolean ok = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConn();
			String sql = "update tb_member set name=?, tel=?, addr=?,birth=?,job=?,gender=?,email=? where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Mem.getName());
			pstmt.setString(2, Mem.getTel());
			pstmt.setString(3, Mem.getAddr());
			pstmt.setString(4, Mem.getBirth());
			pstmt.setString(5, Mem.getJob());
			pstmt.setString(6, Mem.getGender());
			pstmt.setString(7, Mem.getEmail());
			pstmt.setString(8, Mem.getIntro());
			pstmt.setString(9, Mem.getId());
			pstmt.setString(10, Mem.getPwd());
			int r = pstmt.executeUpdate(); // 실행 -> 수정 
			// 1~n : 성공 , 0 : 실패
			if(r>0) ok = true; // 수정이 성공하면 ok값을 true로 변경
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ok;	
	}
	/*회원정보 삭제*/
	public boolean deleteMember(String id,String pwd) {
		boolean ok = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConn();
			String sql = "delete from tb_member where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			int r = pstmt.executeUpdate();
			if(r > 0) ok = true; // 삭제됨
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	/*DB데이터 다시 불러오기*/
	public void userSelectAll(DefaultTableModel model) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			String sql = "select * from tb_member order by name asc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// DefaultTableModel에 있는 데이터 지우기
			for(int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}
			while(rs.next()) {
				Object data[] = {
						rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(3)
				};
				model.addRow(data);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
