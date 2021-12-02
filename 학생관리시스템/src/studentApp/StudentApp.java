package studentApp;

import java.util.Scanner;

import studentdao.StudentDAO;

public class StudentApp {
	public StudentApp() {
	}
	public void start() {
		menu();
	}
	public void menu() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("1. �߰� 2. ��ȸ 3. ���� 4. ���� 5. �̸���ȸ 6. ���� > ");
			String str = sc.nextLine();
			int choice = Integer.parseInt(str);
			StudentDAO studentdao = new StudentDAO();
			
			switch(choice) {
				case 1:
					// �߰�
					studentdao.addStudent();
					break;
				case 2:
					// ��ȸ
					studentdao.selectStudent();
					break;
				case 3:
					// ����
					studentdao.updateStudent();
					break;
				case 4:
					// ����
					studentdao.deleteStudent();
					break;
				case 5:
					studentdao.getSearchRecord();
					// �л� ��ȸ
					break;
				case 6:
					System.out.println("�����");
					System.exit(0);
			}
		}
	}	
	public static void main(String[] args) {
		new StudentApp().start();
		
	}
}
