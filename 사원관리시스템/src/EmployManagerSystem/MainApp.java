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
		System.out.println("----사원관리 시스템 에 오신걸 환영합니다.----");
		System.out.println("1. 관리자 회원가입 2. 관리자 로그인 하기");
		String num = sc.nextLine();
		int choice = Integer.parseInt(num);
		switch(choice) {
		case 1 :
			// 회원가입 
			ArrayList<ManagerDTO> arr = j.joinapp();
			break;
		case 2 :
			// 로그인 하기 
			Login.loginSystem(); 
			}
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new MainApp().start();
	}
}
