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
		
		System.out.println("\t ������ �α����� ���� ȸ������ ��Ź�帳�ϴ� \t");
		
		System.out.print("\t���̵� �Է��� �ּ��� > ");
		String id = sc.nextLine();
		 
		System.out.print("\t��й�ȣ�� �Է��� �ּ��� > ");
		String pwd = sc.nextLine();
		 
		System.out.print("\t�̸��� �Է��� �ּ��� > ");	
		String name = sc.nextLine();
		 
		System.out.print("\t��ȭ��ȣ�� �Է��� �ּ��� > ");
		String tel = sc.nextLine();

		manager.add(new ManagerDTO(id , pwd, name, tel));
		dao.ManagerDAO.addManager(manager);
		
		return manager;
	}
}
