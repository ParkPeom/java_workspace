package studentdao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dbconn.DBConn;
import studentdto.StudentDTO;

public class StudentDAO extends DBConn  {
	
	Scanner sc;
	
	public StudentDAO() {
		sc = new Scanner(System.in);
		
	}
	
	// 레코드 전체 선택 
	public List<StudentDTO> getAllSelect() {
		List<StudentDTO> list =  new ArrayList();
		getConn();
		String sql = "select * from score";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentDTO dto = new StudentDTO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6));
				list.add(dto);
			}
			for(int i = 0; i < list.size(); i++) {
				System.out.printf("학번 : %d  이름 : %s  국어 : %d  영어 : %d  수학 : %d  총점 : %d \n"
						, list.get(i).getHak() , list.get(i).getName() , list.get(i).getKor() , list.get(i).getEng()
						, list.get(i).getMat(),list.get(i).getTot());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			setDBClose();
		}
		return list;
	}
	// 학생 이름 %지% 검색
	public List<StudentDTO> getSearchRecord() {
		List<StudentDTO> list = new ArrayList<StudentDTO>();
				
		System.out.print("검색하실 이름을 입력해 주세요 > ");
		String name = sc.nextLine();
		getConn();
		String sql = "select * from score where name like '%"+name+"%'";
		try {
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);	
					
			while(rs.next()) {	
				int hak = rs.getInt("hak");
				String name2 = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				System.out.println("학번 : " + hak +" 이름 : " + name2 +" 국어 : " + kor + " 영어 : " + eng + " 수학 : " + mat + " 총점 : " + tot );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			setDBClose();
		}
		return list;
	}
	
	// 학생 추가
	public void addStudent() {
		getConn();
		String sql = "insert into score (HAK,name,kor,eng,mat) values(no_seq.NEXTVAL , ? , ? , ? , ?)";
		System.out.print("이름을 입력 하세요 > ");
		String name = sc.nextLine();
		System.out.print("국어 점수를 입력하세요 > ");
		int kor = Integer.parseInt(sc.nextLine().trim());
		System.out.print("영어 점수를 입력하세요 > ");
		int eng = Integer.parseInt(sc.nextLine().trim());
		System.out.print("수학 점수를 입력하세요 > ");
		int mat = Integer.parseInt(sc.nextLine().trim());
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, kor);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, mat);
			int rows = pstmt.executeUpdate();
			
			if(rows == 1) {
				System.out.println("추가 되었습니다.");
				getAllSelect();
			} else {
				System.out.println("추가 되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			setDBClose();
		}
	}
	
	// 학생 조회 
	public void selectStudent() {
		getConn();
		getAllSelect();
	}
	
	
	// 학생 수정
	public void updateStudent() {
		getConn();
		getAllSelect();
		System.out.print("수정하실 학번을 입력해 주세요 > ");
		int hak = sc.nextInt();
		
		System.out.print("국어 점수 > ");
		int kor = sc.nextInt();
		
		System.out.print("영어 점수 > ");
		int eng = sc.nextInt();
		
		System.out.print("수학 점수 > ");
		int mat = sc.nextInt();
	
		String sql = "update score set kor = ? , eng = ? , mat = ? where hak =  ? ";	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, kor);
			pstmt.setInt(2, eng);
			pstmt.setInt(3, mat);
			pstmt.setInt(4, hak);
			pstmt.executeUpdate();
			getAllSelect();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			setDBClose();
		}
	}
	
	// 학생 삭제
	public void deleteStudent() {
		getConn();	
		String sql = "delete from score where hak = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.print(" 삭제 하실 hak번을 입력해주세요 > ");
			int hak = sc.nextInt();
			pstmt.setInt(1, hak);
			int row = pstmt.executeUpdate();
			
			if(row == 1) {
				System.out.println("변경되었습니다.");
				getAllSelect();
			} else {
				System.out.println("변경되지 않았습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			setDBClose();
		}
	}
}
