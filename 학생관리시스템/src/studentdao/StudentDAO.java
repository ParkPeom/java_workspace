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
	
	// ���ڵ� ��ü ���� 
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
				System.out.printf("�й� : %d  �̸� : %s  ���� : %d  ���� : %d  ���� : %d  ���� : %d \n"
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
	// �л� �̸� %��% �˻�
	public List<StudentDTO> getSearchRecord() {
		List<StudentDTO> list = new ArrayList<StudentDTO>();
				
		System.out.print("�˻��Ͻ� �̸��� �Է��� �ּ��� > ");
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
				System.out.println("�й� : " + hak +" �̸� : " + name2 +" ���� : " + kor + " ���� : " + eng + " ���� : " + mat + " ���� : " + tot );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			setDBClose();
		}
		return list;
	}
	
	// �л� �߰�
	public void addStudent() {
		getConn();
		String sql = "insert into score (HAK,name,kor,eng,mat) values(no_seq.NEXTVAL , ? , ? , ? , ?)";
		System.out.print("�̸��� �Է� �ϼ��� > ");
		String name = sc.nextLine();
		System.out.print("���� ������ �Է��ϼ��� > ");
		int kor = Integer.parseInt(sc.nextLine().trim());
		System.out.print("���� ������ �Է��ϼ��� > ");
		int eng = Integer.parseInt(sc.nextLine().trim());
		System.out.print("���� ������ �Է��ϼ��� > ");
		int mat = Integer.parseInt(sc.nextLine().trim());
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, kor);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, mat);
			int rows = pstmt.executeUpdate();
			
			if(rows == 1) {
				System.out.println("�߰� �Ǿ����ϴ�.");
				getAllSelect();
			} else {
				System.out.println("�߰� ���� �ʾҽ��ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			setDBClose();
		}
	}
	
	// �л� ��ȸ 
	public void selectStudent() {
		getConn();
		getAllSelect();
	}
	
	
	// �л� ����
	public void updateStudent() {
		getConn();
		getAllSelect();
		System.out.print("�����Ͻ� �й��� �Է��� �ּ��� > ");
		int hak = sc.nextInt();
		
		System.out.print("���� ���� > ");
		int kor = sc.nextInt();
		
		System.out.print("���� ���� > ");
		int eng = sc.nextInt();
		
		System.out.print("���� ���� > ");
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
	
	// �л� ����
	public void deleteStudent() {
		getConn();	
		String sql = "delete from score where hak = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.print(" ���� �Ͻ� hak���� �Է����ּ��� > ");
			int hak = sc.nextInt();
			pstmt.setInt(1, hak);
			int row = pstmt.executeUpdate();
			
			if(row == 1) {
				System.out.println("����Ǿ����ϴ�.");
				getAllSelect();
			} else {
				System.out.println("������� �ʾҽ��ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			setDBClose();
		}
	}
}
