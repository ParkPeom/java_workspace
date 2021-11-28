package Manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dto.ManagerDTO;

public class Join {
	
	String id , pwd , name , tel;

	public Join() {}
	
	public ArrayList<ManagerDTO> joinapp() throws ClassNotFoundException, SQLException {
				
		Scanner sc = new Scanner(System.in);
		ManagerDTO	managerdto = new ManagerDTO();
		ArrayList<ManagerDTO> managerarr = new ArrayList<ManagerDTO>();
		
			System.out.println("\t 관리자 로그인을 위한 회원가입 부탁드립니다 \t");
			System.out.print("\t아이디를 입력해 주세요 (5글자 이상 10글자 이하로 적어주세요) > ");
			id = sc.nextLine();
			managerdto.setId(id);
			
			System.out.print("\t비밀번호를 입력해 주세요 (10글자 이상 20글자 이하로 입력해 주세요)> ");
			pwd = sc.nextLine();
			managerdto.setPwd(pwd);
			 
			System.out.print("\t이름을 입력해 주세요 > ");	
			name = sc.nextLine();
			managerdto.setName(name); 
			
			System.out.print("\t전화번호를 입력해 주세요 (010-XXXX-XXXX) > ");
			tel = sc.nextLine();
			managerdto.setTel(tel);
			
			// 유효성 검사한후 넣는다.
			managerarr.add(new ManagerDTO(id,pwd,name,tel));
			dao.ManagerDAO.addManager(managerarr);

			return managerarr;
		}
	}
	
