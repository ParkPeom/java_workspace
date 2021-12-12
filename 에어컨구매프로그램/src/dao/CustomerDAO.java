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
	
	CustomerDTO customer = new CustomerDTO();
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
				
				}
			}catch(SQLException e) {
				System.out.println("¿¡·¯");
			}finally {
				close(con,pstmt,rs);
			}
		return joinList;
	}
}

