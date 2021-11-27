package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import dto.EmployDTO;

public class EmployDAO {
	Scanner sc = new Scanner(System.in);

	public EmployDAO() {
	}
	public static void menu() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		EmployDAO emp = new EmployDAO();
		EmployDTO employ = new EmployDTO();
		ArrayList<EmployDTO> arremployee = new ArrayList<EmployDTO>();
		
		System.out.println("��� ���� ���α׷��� ���Ű� ȯ���մϴ�.");
		
		endloop : while(true) {
			System.out.println("-----------------------------------------");
			System.out.println("\t1. ��� ��ȸ");
			System.out.println("\t2. ��� ����");
			System.out.println("\t3. ��� �߰�");
			System.out.println("\t4. ��� ����");
			System.out.println("\t5. ����");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				emp.selectEmp(); //  �����ȸ 
				break;
			case 2:
				emp.updateEmp(); // ������� 
				break;
			case 3:
				emp.adddataEmp(arremployee); // ����߰� 
				break;
			case 4:
				emp.deleteEmp(); // �������
				break;
			case 5:
				// ���� 
				break endloop; 
			default :
				System.out.println("�ٽ� �Է�");
			}
		}
	}
	
	// ��� ��ȸ 
	public void selectEmp() throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "SELECT * FROM EMPLOYEE";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			int empno = rs.getInt("EMPNO"); 
			String name = rs.getString("NAME");
			String tel = rs.getString("TEL");
			String job = rs.getString("JOB");
			String gender = rs.getString("GENDER");
			System.out.printf("\t[ �����ȣ : %d �̸� : %s ��ȭ��ȣ : %s ���� : %s ���� : %s \n" 
					, empno , name ,  tel , job , gender);
		}	
	}
	
	// ��� ���� 
	public void updateEmp() throws ClassNotFoundException, SQLException {
		selectEmp();
		System.out.print("�ٲٽ� �����ȣ�� �����ּ��� > ");
		int empno = sc.nextInt();
		sc.nextLine();
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "UPDATE EMPLOYEE SET NAME = ? , TEL = ? , JOB = ? , GENDER = ?   WHERE EMPNO = ?  ";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, setMessage("�̸��� �Է��� �ּ���"));
		st.setString(2, setMessage("��ȭ��ȣ�� �Է��� �ּ��� \n"));
		st.setString(3, setMessage("������ �Է��� �ּ��� \n"));
		st.setString(4, setMessage("������ �Է��� �ּ��� \n"));
		st.setInt(5, empno);
		int result = st.executeUpdate();
		System.out.println("���� �Ϸ� �Ǿ����ϴ�.");
	}
	
	// ��� �߰�
	public void adddataEmp(ArrayList<EmployDTO> arremployee) throws ClassNotFoundException, SQLException {
		selectEmp();
		int num = (int)(Math.random() * 9999) + 1000;
		System.out.println("��� ��ȣ�� �߰��Ǿ����ϴ�." + num);
			
		arremployee.add(new EmployDTO(num , setMessage("�̸� �߰� ")
				, setMessage("��ȭ��ȣ �߰� ") , setMessage("���� �߰� ")
				, setMessage("���� �߰� ")));
		
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "INSERT INTO EMPLOYEE (EMPNO,NAME,TEL,JOB,GENDER)"
				+ " VALUES(?,?,?,?,?)";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		PreparedStatement st = con.prepareStatement(sql);
		
		for(int i = 0; i < arremployee.size(); i++) {
			st.setInt(1,arremployee.get(i).getEmpno());
			st.setString(2,arremployee.get(i).getName());
			st.setString(3,arremployee.get(i).getTel());
			st.setString(4,arremployee.get(i).getJob());		
			st.setString(5,arremployee.get(i).getGender());
			int result = st.executeUpdate();
			System.out.println("�߰� �Ϸ� �Ǿ����ϴ�.");
		}
	}
	
	public String setMessage(String msg) {
		System.out.print(msg  + " > ");
		String answer = sc.nextLine();
		return answer;
	}
	
	// ��� ���� 
	public void deleteEmp() throws SQLException, ClassNotFoundException {
		selectEmp();
		System.out.println("�����Ͻ� �����ȣ�� �����ּ���. ");
		String empno = sc.nextLine();
		int empnoNo = Integer.parseInt(empno);
		
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "DELETE EMPLOYEE WHERE EMPNO = ? ";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,empnoNo);		
		pstmt.executeUpdate();
		
	}
}
