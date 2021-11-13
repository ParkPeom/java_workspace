package com.codechobo.program;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	
	영화관 사이트 회원가입
	<< cinema Join >>
	1. 로그인
	2. 회원 가입
	3. 종료하기  
	
	========회원가입========
	Z. 돌아가기
	아이디입력
	비밀번호 입력
	이름 입력
	나이 입력
	가입완료!
*/
public class Join {
	// 나중 컬렉션프레임워크 배우면 불변 배열 -> 가변 배열
	
	Scanner sc;
	int choice;
	String[] id; 	// 아이디
	String[] pwd; 	// 비밀번호
	String[] name;	// 이름
	int[] age;   	// 나이
	String[] jumin; // 주민번호
	String[] gender;   // 성별 
	ArrayList arr;  // 컬렉션 프레임 사용 
	UserVO user; // User
	
	// 생성자 초기화
	public Join() {
		
		sc = new Scanner(System.in);
		id = new String[10];
		pwd = new String[10];
		name = new String[10];
		age = new int[10];
		jumin = new String[10];
		gender = new String[10];
		user = new UserVO();
		
		showMenu();
	}
	// 라인 
	public void line() {
		System.out.println("=================");
	}
	
	// 로그인 정보
	public void loginInfo() {
		for(int i = 0; i < id.length; i++) {
			if(id[i] != null) {
				System.out.println("아이디 : " + id[i]
					    + " 비밀번호 : " + pwd[i] 
						+ " 이름 : "+ name[i] 
						+ " 나이 : "+ age[i]
						+ " 주민번호 :"+ jumin[i]
						+ " 성별 :" + gender[i]);
				break;
			}
		}
	}
	
	// 로그인 페이지
	public void login() {
		line();
		for(int i = 0; i < id.length; i++) {
			sc.nextLine();
			System.out.print("아이디 > ");
			String idCheck = sc.nextLine();
			if(idCheck.equals(id[i])) {
				System.out.print("비밀번호 입력 > ");
					String pwdCheck = sc.nextLine();
				if(pwdCheck.equals(pwd[i])) {
					System.out.println("접속되셨습니다.");
					// 아이디 넘겨줌 
					choiceloginMenu();
					break;
				} else {
					System.out.println("비밀번호가 틀립니다.");
					break;
				}
			} else {
				System.out.println("아이디가 존재하지 않습니다.");
				break;
			}
		}
	}
	
	// 가입 페이지
	public void join() {
		line();
		for(int i = 0; i < id.length; i++) {
			line();
			sc.nextLine();
			System.out.print("<회원 가입 페이지 입니다.>\n");
			
			line();
			do {
			System.out.println("아이디 다섯글자 ~ 열글자 적어주세요.");	
			System.out.print("사용하실 아이디를 입력하시오 > ");
			id[i] = sc.nextLine();
				if(user.setId(id[i])) {
					user.setId(id[i]); // 재대로 들어옴
					break;
				} else {
					System.out.println("다시 입력해주시오 ");
					continue;
				// 재대로 들어오지 않음
			}
		} while(true);
			line();
			do {
				System.out.println("패스워드 10글자 이상 입력해주세요.");
				System.out.print("사용하실 비밀번호를 입력하시오 > ");
				pwd[i] = sc.nextLine();
				if(user.setPwd(pwd[i])) {
					user.setPwd(pwd[i]);
					break;
				} else {
					System.out.println("다시 입력해주오");
					continue;
				}
			} while(true);
			
			do {
				System.out.println("이름 두글자 이상 ");
				System.out.print("이름을 입력해주세요. > ");
				name[i] = sc.nextLine();
				if(user.setName(name[i])) {
					user.setName(name[i]);
					break;
				} else {
					System.out.println("다시 입력해 주시오");
					continue;
				}
			} while(true);
			
			do {
				System.out.println("나이 1살 ~ 120살 사이 입력해 주시오 ");
				System.out.print("나이를 입력해주십시오 > ");
				age[i] = sc.nextInt();
					sc.nextLine();
				if(user.setAge(age[i])) {
					user.setAge(age[i]);
					break;
				} else {
					System.out.println("다시 입력해 주세요");
					continue;
				}
			} while(true);
			
			do {
				System.out.println(" 주민번호를 입력해주세요 ex) 940114-1xxxxxx");
				// 주민번호 조건 true 이면 대입 
				jumin[i] = sc.next();
				if(user.setJumin(jumin[i])) {
					user.setJumin(jumin[i]);
						if(user.setGender(jumin[i])) {
							gender[i] = "남자";
						} else {
							gender[i] = "여자";
						}
						break;
					} else {
						// 거짓이면 
					System.out.println("가입이 완료되었습니다.");
					break;
				}
			} while(true);
		break;
		}
	}
	
	// 로그인 초기메뉴 
	public void showMenu() {
		line();
		do {
		System.out.println("<< Cinema Join >>");
		System.out.println("1. 로그인");
		System.out.println("2. 회원 가입");
		System.out.println("3. 되돌아가기");
		choice = sc.nextInt();
		choiceMenu(choice);
		line();
		} while(!( 1 > choice && choice > 3));
	}	
	
	// 선택 메뉴
	public void choiceMenu(int choice) {
		line();
		switch(choice) {
		case 1:
			// 로그인 
			login();
			break;
		case 2:
			// 회원가입
			join();
			break;
		case 3:
			// 되돌아가기
			ReserVationMain.showMenu();
			break;
		case 4:
			// 회원 찾기
			searchInfo();
			}
		}
	
	// 로그인 후 콘솔 
	public void longAfterMenu() {
		line();
		System.out.println("<< Cinema Hello >>");
		System.out.println("1. 로그인 정보");
		System.out.println("2. 로그 아웃");
		System.out.println("3. 회원 탈퇴");
		System.out.println("4. 뒤로 가기");
		
	}
	
	// 로그아웃 
	public void loginOut() {
		showMenu();
		line();
	}
	
	// 회원탈퇴 로그인다시 입력 
	public void joinCancel() {
		line();
		for(int i = 0; i < id.length; i++) {
			// 로그인 아이디 , 패스워드 다시 확인
			sc.nextLine();
			System.out.print("아이디 > ");
			String idCheck = sc.nextLine();
			if(idCheck.equals(id[i])) {
				System.out.print("비밀번호 입력 > ");
					String pwdCheck = sc.nextLine();
				if(pwdCheck.equals(pwd[i])) {
					System.out.println("접속되셨습니다.");
					// 회원탈퇴 진행 
					Confirmation(id);
					break;
				} else {
					System.out.println("비밀번호가 틀립니다.");
					break;
				}
			} else {
				System.out.println("아이디가 존재하지 않습니다.");
				break;
			}
		}
	}
	
	// 회원탈퇴 확정 페이지 
	public void Confirmation(String[] id) {
		for(int i = 0; i < id.length; i++) {
			if(id[i] != null) {
				id[i] = null; // 회원 탈퇴 진행 완료
				System.out.println("탈퇴 완료 하였습니다.");
			}
		}
	}
	
	// 아이디 비번 정보 찾기
	public void searchInfo() {
		System.out.println("성함 입력 ");
		System.out.println("주민번호 입력 ");
	}
	
	// 로그인 후 메뉴 
		public void choiceloginMenu() {
		line();
		
		do {
		longAfterMenu();
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			// 로그인 정보
			loginInfo();
			break;
		case 2:
			loginOut();
			// 로그아웃
			break;
		case 3:
			joinCancel();
			// 회원탈퇴
			break;
		case 4:
			// 초기 화면 이동
			ReserVationMain.showMenu();
			}
		} while(!(1 > choice && choice >= 5));
	}
}
