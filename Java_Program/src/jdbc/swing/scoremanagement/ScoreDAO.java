package jdbc.swing.scoremanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ScoreDAO {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1522:orcl";
	private static final String USER = "scott";
	private static final String PASS = "tiger";
	
	public Connection getConn() {
		Connection con = null;
		
		try {
			Class.forName(DRIVER);
			try {
				con = DriverManager.getConnection(URL,USER,PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	return con;	
	}
	
	
	
	public int insertScore(ScoreDTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		con = getConn();
		String sql = "insert into score values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setInt(2, dto.getKor());
			ps.setInt(3, dto.getEng());
			ps.setInt(4, dto.getMat());
			ps.setInt(5, dto.getTot());
			ps.setInt(6, dto.getAve());
		   // while
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
        if (ps != null) { try { ps.close(); } catch (SQLException e2) { e2.printStackTrace(); } // ps try - catch
        } 
        if (con != null) { try { con.close(); } catch (SQLException e2) { e2.printStackTrace(); } // con try - catch
        } 
      } 
      return result;
    }
	
	
	
	public Vector getScore() {
		Vector data = new Vector();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
	try {	
		con = getConn();
		String sql = "select * from scroe order by name asc";
	
		while(rs.next()) {
			String name = rs.getString("name");
			int kor = rs.getInt("kor");
			int eng = rs.getInt("eng");
			int mat = rs.getInt("mat");
			int tot = rs.getInt("tot");
			int ave = rs.getInt("ave");
			Vector row = new Vector();
			row.add(name);
			row.add(kor);
			row.add(eng);
			row.add(mat);
			row.add(tot);
			row.add(ave);
			row.add(row);
			data.add(row);
		 } // while
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (rs != null) { try { rs.close(); } catch (SQLException e2) { e2.printStackTrace(); } // rs try - catch
      } // rs if
      if (stmt != null) { try { stmt.close(); } catch (SQLException e2) { e2.printStackTrace(); } // ps try - catch
      } // stmt if
      if (con != null) { try { con.close(); } catch (SQLException e2) { e2.printStackTrace(); } // con try - catch
      } // con if
    } // try - catch - finally
    return data;
  }
	
	public int updateScroe(ScoreDTO dto) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
		con = getConn();
		String sql = "update scroe set kor = ? , eng = ? , mat = ? , tot = ? , ave = ? where name = ?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, dto.getKor());
		ps.setInt(2, dto.getEng());
		ps.setInt(3, dto.getMat());
		ps.setInt(4, dto.getTot());
		ps.setInt(5, dto.getAve());
		ps.setString(6, dto.getName());
		
	} catch (Exception e) {
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
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
		con = getConn();
		String slq = "delete scroe where name=?";
		ps.setString(1, dto.getName());
		result = ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
      } finally {
        if (ps != null) { try { ps.close(); } catch (SQLException e2) { e2.printStackTrace(); } // ps try - catch
        } // ps if
        if (con != null) { try { con.close(); } catch (SQLException e2) { e2.printStackTrace(); } // con try - catch
        } // con if
      } // try - catch - finally
      return result;
    } // deleteScore : 한 레코드를 삭제하는 메서드, 성공 여부를 int형 result 를 반환한다.
    

  }



	
		
