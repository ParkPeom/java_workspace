package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBConn.JdbcDAO;
import dto.JoinDTO;

public class JoinDAO extends JdbcDAO {

	List<JoinDTO> joinarr = new ArrayList<JoinDTO>();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int rows = 0;
	
	private static JoinDAO dao;
	private JoinDAO() {}
	static {
		dao = new JoinDAO();
	}
	public static JoinDAO getDAO() {
		return dao;
	}
	public int insertJoin(JoinDTO join) {
		int rows = 0;
		try {
			con = getConnection();
			String sql = "insert into join values(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, join.getId());
			pstmt.setString(2, join.getPassword());
			pstmt.setString(3, join.getJumin());
			pstmt.setString(4, join.getName());
			pstmt.setInt(5, join.getAge());
			pstmt.setString(6, join.getGender());
			pstmt.setString(7, join.getPhone());
			pstmt.setString(8, join.getEmail());
			rows = pstmt.executeUpdate();
		if(rows > 0) {
			// �߰��Ǹ� ��������̺� �߰��� 
			System.out.println("�߰� �Ǿ����ϴ�.");
			CustomerDAO dao = CustomerDAO.getDAO();
			dao.insertCustomer(join);		
		} else {
			System.out.println("������� ����");
		}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt);		
		}
		return rows;	
	}
	// ���������� �˻�
	public List<JoinDTO> selectAllJoin() {
		List<JoinDTO> joinList = new ArrayList<JoinDTO>();
		try {	
			con = getConnection();
			String sql = "select * from join";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				JoinDTO join = new JoinDTO();
					join.setId(rs.getString("id"));
					join.setPassword(rs.getString("password"));
					join.setJumin(rs.getString("jumin"));
					join.setName(rs.getString("name"));
					join.setAge(rs.getInt("age"));
					join.setGender(rs.getString("gender"));
					join.setPhone(rs.getString("phone"));
					join.setEmail(rs.getString("email"));
				joinList.add(join);
				}
			}catch(SQLException e) {
				System.out.println("����");
			}finally {
				close(con,pstmt,rs);
			}
		return joinList;
		}
	}