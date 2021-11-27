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
		
		System.out.println("사원 관리 프로그램에 오신걸 환영합니다.");
		
		endloop : while(true) {
			System.out.println("-----------------------------------------");
			System.out.println("\t1. 사원 조회");
			System.out.println("\t2. 사원 수정");
			System.out.println("\t3. 사원 추가");
			System.out.println("\t4. 사원 삭제");
			System.out.println("\t5. 종료");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				emp.selectEmp(); //  사원조회 
				break;
			case 2:
				emp.updateEmp(); // 사원수정 
				break;
			case 3:
				emp.adddataEmp(arremployee); // 사원추가 
				break;
			case 4:
				emp.deleteEmp(); // 사원삭제
				break;
			case 5:
				// 종료 
				break endloop; 
			default :
				System.out.println("다시 입력");
			}
		}
	}
	
	// 사원 조회 
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
			System.out.printf("\t[ 사원번호 : %d 이름 : %s 전화번호 : %s 직급 : %s 성별 : %s \n" 
					, empno , name ,  tel , job , gender);
		}	
	}
	
	// 사원 수정 
	public void updateEmp() throws ClassNotFoundException, SQLException {
		selectEmp();
		System.out.print("바꾸실 사원번호를 적어주세요 > ");
		int empno = sc.nextInt();
		sc.nextLine();
		String url = "jdbc:oracle:thin:@localhost:1522/orcl";
		String sql = "UPDATE EMPLOYEE SET NAME = ? , TEL = ? , JOB = ? , GENDER = ?   WHERE EMPNO = ?  ";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "scott", "tiger");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, setMessage("이름을 입력해 주세요"));
		st.setString(2, setMessage("전화번호을 입력해 주세요 \n"));
		st.setString(3, setMessage("직급을 입력해 주세요 \n"));
		st.setString(4, setMessage("성별을 입력해 주세요 \n"));
		st.setInt(5, empno);
		int result = st.executeUpdate();
		System.out.println("수정 완료 되었습니다.");
	}
	
	// 사원 추가
	public void adddataEmp(ArrayList<EmployDTO> arremployee) throws ClassNotFoundException, SQLException {
		selectEmp();
		int num = (int)(Math.random() * 9999) + 1000;
		System.out.println("사원 번호가 추가되었습니다." + num);
			
		arremployee.add(new EmployDTO(num , setMessage("이름 추가 ")
				, setMessage("전화번호 추가 ") , setMessage("직급 추가 ")
				, setMessage("성별 추가 ")));
		
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
			System.out.println("추가 완료 되었습니다.");
		}
	}
	
	public String setMessage(String msg) {
		System.out.print(msg  + " > ");
		String answer = sc.nextLine();
		return answer;
	}
	
	// 사원 삭제 
	public void deleteEmp() throws SQLException, ClassNotFoundException {
		selectEmp();
		System.out.println("삭제하실 사원번호를 적어주세요. ");
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
