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
		
			System.out.println("\t ������ �α����� ���� ȸ������ ��Ź�帳�ϴ� \t");
			System.out.print("\t���̵� �Է��� �ּ��� (5���� �̻� 10���� ���Ϸ� �����ּ���) > ");
			id = sc.nextLine();
			managerdto.setId(id);
			
			System.out.print("\t��й�ȣ�� �Է��� �ּ��� (10���� �̻� 20���� ���Ϸ� �Է��� �ּ���)> ");
			pwd = sc.nextLine();
			managerdto.setPwd(pwd);
			 
			System.out.print("\t�̸��� �Է��� �ּ��� > ");	
			name = sc.nextLine();
			managerdto.setName(name); 
			
			System.out.print("\t��ȭ��ȣ�� �Է��� �ּ��� (010-XXXX-XXXX) > ");
			tel = sc.nextLine();
			managerdto.setTel(tel);
			
			// ��ȿ�� �˻����� �ִ´�.
			managerarr.add(new ManagerDTO(id,pwd,name,tel));
			dao.ManagerDAO.addManager(managerarr);

			return managerarr;
		}
	}
	
