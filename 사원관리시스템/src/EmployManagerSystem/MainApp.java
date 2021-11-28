package EmployManagerSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Manager.Join;
import Manager.Login;
import dto.ManagerDTO;

public class MainApp {
	public MainApp() {}
	public void start() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		Join j = new Join();
		while(true) {
		System.out.println("----������� �ý��� �� ���Ű� ȯ���մϴ�.----");
		System.out.println("1. ������ ȸ������ 2. ������ �α��� �ϱ�");
		String num = sc.nextLine();
		int choice = Integer.parseInt(num);
		switch(choice) {
		case 1 :
			// ȸ������ 
			ArrayList<ManagerDTO> arr = j.joinapp();
			break;
		case 2 :
			// �α��� �ϱ� 
			Login.loginSystem(); 
			}
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new MainApp().start();
	}
}
