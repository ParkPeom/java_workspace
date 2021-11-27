package Manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dto.ManagerDTO;

public class Join {

	public Join() {}
	
	public ArrayList<ManagerDTO> joinapp() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		ArrayList<ManagerDTO> manager = new ArrayList<ManagerDTO>();
		
		System.out.println("\t 관리자 로그인을 위한 회원가입 부탁드립니다 \t");
		
		System.out.print("\t아이디를 입력해 주세요 > ");
		String id = sc.nextLine();
		 
		System.out.print("\t비밀번호를 입력해 주세요 > ");
		String pwd = sc.nextLine();
		 
		System.out.print("\t이름을 입력해 주세요 > ");	
		String name = sc.nextLine();
		 
		System.out.print("\t전화번호를 입력해 주세요 > ");
		String tel = sc.nextLine();

		manager.add(new ManagerDTO(id , pwd, name, tel));
		dao.ManagerDAO.addManager(manager);
		
		return manager;
	}
}
