package scoremanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracl:this:@localhost:1522:orlc";
	private static final String USER = "scott";
	private static final String PASS = "tiger";
	
	Connection con = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Connection getConn() {
		Connection con = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USER,PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return con;
	}
		
	public int insertScore(ScoreDTO dto) {
		PreparedStatement ps = null;
		int result = 0;
		con = getConn();
		String sql = "insert into score values(?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(2, dto.getKor());
			ps.setInt(3, dto.getEng());
			ps.setInt(4, dto.getMat());
			ps.setInt(5, dto.getTot());
			ps.setInt(6, dto.getAve());
			
		} catch(Exception e) {
			if(ps != null)
				try {
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if(con != null)
				try {
					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return result;
	}
	
	
	public List getScore() {
		List data = new ArrayList();
	try {
		con = getConn();
		String sql = "select * from score order by name asc";
		
		while(rs.next()) {
			String name = rs.getString("name");
			int kor = rs.getInt("kor");
			int eng = rs.getInt("eng");
			int mat = rs.getInt("mat");
			int tot = rs.getInt("tot");
			int ave = rs.getInt("ave");
			
			List row = new ArrayList();
			row.add(name);
			row.add(kor);
			row.add(eng);
			row.add(mat);
			row.add(tot);
			row.add(ave);
			row.add(row);
			
			// 리스트에 리스트를 넣음 ? 
			data.add(row); 
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	return data;
	}
	
	public int updateScore(ScoreDTO dto) {
		
		int result = 0;
		
		try {
			con = getConn();
			String sql = "update score set kor = ? , eng = ? , mat = ? , tot = ? , ave = ? where name = ? ";
			ps = con.prepareStatement(sql);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			  if (ps != null) { try { ps.close(); } catch (SQLException e2) { e2.printStackTrace(); } // ps try - catch
		      }
		      if (con != null) { try { con.close(); } catch (SQLException e2) { e2.printStackTrace(); } // con try - catch
		   } 
		}
		return result;
	}
	
	public int deleteScore(ScoreDTO dto) {
		int result = 0;
		
		try {
			con = getConn();
			String sql = "delete score where name = ?";
			ps.setString(1, dto.getName());
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
