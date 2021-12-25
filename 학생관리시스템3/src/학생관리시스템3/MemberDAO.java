package �л������ý���3;

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
	/*DB���� �޼ҵ�*/
	public Connection getConn() {
		Connection con = null;
		
		try {
		Class.forName(DRIVER); //����̹� �ε�
			con = DriverManager.getConnection(URL, USER, PASS); // 2. ����̹� ����
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return con;
	}
	/* �ѻ���� ȸ�� ������ ��� �޼ҵ�*/
	public MemberDTO getMemberDTO(String id) throws SQLException {
		MemberDTO dto = new MemberDTO();
		Connection con = null; // ����
		PreparedStatement ps = null; // ���
		ResultSet rs = null;   // ���
		rs = ps.executeQuery(); // select ���ǹ�	
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
	
	/*��� ����Ʈ ���*/
	public Vector getMemberList() {
		
		Vector data = new Vector(); // Jtable�� ���� ���� �ִ� ���
		Connection con = null; // ����
		PreparedStatement pstmt = null; // ���
		ResultSet rs = null; // ���
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
				
				data.add(row); // ���͹迭�� �� �߰� 
			} // while
		} catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/*ȸ�� ���*/
	public boolean insertMember(MemberDTO dto) {
		boolean ok = false;
		Connection con = null; // ����
		PreparedStatement pstmt = null; // ���
		
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
			
			int r = pstmt.executeUpdate(); // ���� -> ���� 
			
			if(r>0) {
				System.out.println("���� ����");
				ok = true;
			} else {
				System.out.println("���� ����");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} 
		/*ȸ������ ����*/
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
			int r = pstmt.executeUpdate(); // ���� -> ���� 
			// 1~n : ���� , 0 : ����
			if(r>0) ok = true; // ������ �����ϸ� ok���� true�� ����
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ok;	
	}
	/*ȸ������ ����*/
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
			if(r > 0) ok = true; // ������
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	/*DB������ �ٽ� �ҷ�����*/
	public void userSelectAll(DefaultTableModel model) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConn();
			String sql = "select * from tb_member order by name asc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// DefaultTableModel�� �ִ� ������ �����
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
