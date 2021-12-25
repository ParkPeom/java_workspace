package print;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import choice.Choice;
import dao.CustomerDAO;
import dao.JoinDAO;
import dto.CustomerDTO;
import dto.JoinDTO;

public class Print {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int number;
	String answer;
	public Print() {}
	
	public static void firstprintmenu() {
		System.out.println("\t\t��-----ȯ���մϴ�. -----��\t\t");		
		System.out.println("\t\t��-----1.ȸ �� �� �� -----��\t\t");
		System.out.println("\t\t��-----2.�� �� �� -----��\t\t");
	}
	public static void showprintmenu(String id) {
		System.out.println(id +"�� �������.");
		System.out.println("\t\t-----1. ����������-----\t\t");
		System.out.println("\t\t-----2. ���� �ϱ�-----\t\t");
		System.out.println("\t\t-----3. ���� ���-----\t\t");
		Choice.showchoicemenu(id);
	}
	// ���� 
	public static int setIntMessage(String msg) {
		int number = 0;
	try {	
		System.out.print(msg + " >> ");
		number = Integer.parseInt(br.readLine());
		} catch(IOException e) {
			System.out.println("[����] ���ڸ� �Է��� �ּ���.");
		}
		return number;
	}
	// ���� 
	public static String setStringMessage(String msg) {
			String answer = "";
		try {	
			System.out.print(msg + " >> ");
			answer = br.readLine();
			
			} catch(IOException e) {
				System.out.println("[����] ���ڸ� �Է��� �ּ���.");
			}
		return answer;
	}
	// ȸ������ ������ 
	public static void join() {
		JoinDTO joindto = new JoinDTO();	
		JoinDAO joindao = JoinDAO.getDAO();	
		// ���� ���̺�---------------------------------
		joindto.setId(setStringMessage("���̵�"));
		joindto.setPassword(setStringMessage("�н�����"));
		joindto.setJumin(setStringMessage("�ֹι�ȣ"));
		joindto.setName(setStringMessage("�̸�"));
		joindto.setAge(setIntMessage("����"));
		joindto.setGender(setStringMessage("����"));
		joindto.setPhone(setStringMessage("��ȭ��ȣ"));
		joindto.setEmail(setStringMessage("�̸���"));
		// DB�� �� ����
		joindao.insertJoin(joindto);			
	}
	// �α��� 
	public static void login() {
		JoinDAO joindao = JoinDAO.getDAO();
		System.out.println("�α��� ������ �Դϴ�.");
		String id = setStringMessage("���̵�");
		String password = setStringMessage("��й�ȣ");
		List<JoinDTO> joinList = joindao.selectAllJoin();
		
		for(int i = 0; i < joinList.size(); i++) {
			if(id.equals(joinList.get(i).getId())
					&& password.equals(joinList.get(i).getPassword())) {
				System.out.println("�α����� �Ǽ̽��ϴ�.");
				Print.showprintmenu(id);
			} else {
				
			}
		}	
	}
	// ����������
	public static void myPage(String id) { // ������ ���̵� bum4856
		CustomerDAO dao = CustomerDAO.getDAO();
		CustomerDTO dto = new CustomerDTO();			
		List<CustomerDTO> customer = dao.selectIDCustomer(id);
		for(int i = 0; i < customer.size(); i++) {
			System.out.println("���̵� : " + customer.get(i).getId()
					+" �� : " + customer.get(i).getMoney()
					+" ����Ʈ : " + customer.get(i).getBonuspoint());
		}
	}
}
