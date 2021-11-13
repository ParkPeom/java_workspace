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
			case '1': // 정보 입력
				program.loginVaild(); // 로그인 메소드
				if (LoginProgram.loginFlag) {
					break;
				}
				System.out.print("아이디 입력 : ");
				String myId= input.nextLine();
				program.setId(myId);
				
				System.out.print("비밀번호 입력 : ");
				String myPw = input.nextLine();
				program.setPassword(myPw);
				program.isMemberCheck(memberTable.get(myId), memberTable.get(myPw));
				break;
			case '2': // 회원 가입 
				program.Join();
				break;
			case '3':
				//program.logOut();
				break;
			case '4':
				System.exit(0);
			default :
				System.out.println("잘못된 값 입력");
				break;
			}
		}
	}
	// 보기 메뉴 
	public char display() {
		System.out.println("1.로그인 2.가 입 3. 로그아웃 4. 종 료");
		System.out.print(">>>");
		return input().charAt(0);  
	}
	// 입력 메소드
	public String input() {
		Scanner sc= new Scanner(System.in);
		return sc.nextLine();
	}
	
	//회원가입 메서드
	public void Join() {
		if(loginFlag) {
			System.out.println("자동로그아웃하고 새로운 회원가입을 시작합니다.");
			loginFlag = false;
		}
		while(true) {
			System.out.print("가입 id : ");
			String newId = input();
			if(memberTable.containsKey(newId)) {
				System.out.println("이미 존재하는 아이디 입니다.");
				continue;
			}
			System.out.print("가입 pw : ");
			String newPwd = input();
			memberTable.put(newId, newPwd);
			break;
		}
		System.out.println("저장완료 ");
	}
	
	// 로그인 메소드
	public void loginVaild() {
		if(loginFlag) {
			System.out.println("이미 로그인되어 있는 상태입니다.");
			return;
		}
	}
	
	// 체크 
	public void isMemberCheck(String id,String pw) {
		if(memberTable.containsKey(id)) {
			if(!memberTable.get(id).equals(pw)) {
				System.out.println("비밀번호가 맞지 않습니다.");
			} else {
				System.out.println("인증 성공");
				loginFlag = true;
			}
		} else {
			System.out.println("존재하지 않는 아이디 입니다.");
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
