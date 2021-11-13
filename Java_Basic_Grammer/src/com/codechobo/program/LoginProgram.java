package com.codechobo.program;

import java.util.HashMap;
import java.util.Scanner;

public class LoginProgram {
	Scanner input = new Scanner(System.in);
	private String id;
	private String password;
	static boolean loginFlag = false;
	
	HashMap<String,String> memberTable = new HashMap<String,String>();
	LoginProgram program;
	
	public LoginProgram() {
		program = new LoginProgram();
		choiceMenu();
	}
	public void choiceMenu() {
		while(true) {
			char select = program.display();
			
			switch(select) {
			case '1': // ���� �Է�
				program.loginVaild(); // �α��� �޼ҵ�
				if (LoginProgram.loginFlag) {
					break;
				}
				System.out.print("���̵� �Է� : ");
				String myId= input.nextLine();
				program.setId(myId);
				
				System.out.print("��й�ȣ �Է� : ");
				String myPw = input.nextLine();
				program.setPassword(myPw);
				program.isMemberCheck(memberTable.get(myId), memberTable.get(myPw));
				break;
			case '2': // ȸ�� ���� 
				program.Join();
				break;
			case '3':
				//program.logOut();
				break;
			case '4':
				System.exit(0);
			default :
				System.out.println("�߸��� �� �Է�");
				break;
			}
		}
	}
	// ���� �޴� 
	public char display() {
		System.out.println("1.�α��� 2.�� �� 3. �α׾ƿ� 4. �� ��");
		System.out.print(">>>");
		return input().charAt(0);  
	}
	// �Է� �޼ҵ�
	public String input() {
		Scanner sc= new Scanner(System.in);
		return sc.nextLine();
	}
	
	//ȸ������ �޼���
	public void Join() {
		if(loginFlag) {
			System.out.println("�ڵ��α׾ƿ��ϰ� ���ο� ȸ�������� �����մϴ�.");
			loginFlag = false;
		}
		while(true) {
			System.out.print("���� id : ");
			String newId = input();
			if(memberTable.containsKey(newId)) {
				System.out.println("�̹� �����ϴ� ���̵� �Դϴ�.");
				continue;
			}
			System.out.print("���� pw : ");
			String newPwd = input();
			memberTable.put(newId, newPwd);
			break;
		}
		System.out.println("����Ϸ� ");
	}
	
	// �α��� �޼ҵ�
	public void loginVaild() {
		if(loginFlag) {
			System.out.println("�̹� �α��εǾ� �ִ� �����Դϴ�.");
			return;
		}
	}
	
	// üũ 
	public void isMemberCheck(String id,String pw) {
		if(memberTable.containsKey(id)) {
			if(!memberTable.get(id).equals(pw)) {
				System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
			} else {
				System.out.println("���� ����");
				loginFlag = true;
			}
		} else {
			System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
		}
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) {
		new LoginProgram();
	}
}
