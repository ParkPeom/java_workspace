package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBConn.JdbcDAO;
import dto.CustomerDTO;
import dto.JoinDTO;

public class CustomerDAO extends JdbcDAO {
	
	private static CustomerDAO dao;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private CustomerDAO() {}
	
	static {
		dao = new CustomerDAO();
	}
	public static CustomerDAO getDAO() {
		return dao;
	}
	public int insertCustomer(JoinDTO join) {
		CustomerDAO dao = new CustomerDAO();
		int money = 0;
		int bonuspoint = 0;
		int rows = 0;
		try {
			con = getConnection();
			String sql = "insert into customer values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, join.getId());
			pstmt.setInt(2, money);
			pstmt.setInt(3, bonuspoint);
			rows = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt);
		}
		return rows;
	}
	public List<CustomerDTO> selectIDCustomer(String id) {
		int rows = 0;
		con = getConnection();
		String sql = "select * from customer where id = ? ";
		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				CustomerDTO customer = new CustomerDTO();
				customer.setId(rs.getString("id"));
				customer.setMoney(rs.getInt("money"));
				customer.setBonuspoint(rs.getInt("bonuspoint"));
				customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt,rs);
		}
		return customerList;	
	}

	public List<CustomerDTO> selectAllCustomer() {
		List<CustomerDTO> customerList = new ArrayList<CustomerDTO>();
		try {	
			con = getConnection();
			String sql = "select * from customer";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CustomerDTO customer = new CustomerDTO();
					customer.setId(rs.getString("id"));
					customer.setMoney(rs.getInt("money"));
					customer.setBonuspoint(rs.getInt("bonuspoint"));
					customerList.add(customer);
				}
			} catch(SQLException e) {
				System.out.println("¿¡·¯");
			} finally {
				close(con,pstmt,rs);
			}
		return customerList;
	}
}

