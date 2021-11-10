package com.codechobo.forfor;

import java.util.Scanner;

public class MenuApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("<<학생 관리 프로그램 >>");
			// 메뉴 목록 출력
			System.out.println("1. 학생 정보 저장");
			System.out.println("2. 학생 정보 변경");
			System.out.println("3. 학생 정보 삭제");
			System.out.println("4. 학생 정보 검색");
			System.out.println("5. 학생 정보 종료");
			
			// 메뉴 선택 입력
			System.out.print("메뉴 선택 [1 ~ 5] >> ");
			int choice = scanner.nextInt();
			
			// 선택 메뉴에 대한 유효성 검사
			if(choice < 1 || choice > 5) {
				System.out.println("[에러] 선택된 메뉴가 존재하지 않습니다.");
				continue;
			}			
			// 선택메뉴에 대한 기능 제공
			if(choice == 5) {
				break;
			}
			switch(choice) { // switch 값에는 실수는 오지못한다. 
			case 1: // 변수가 올수없다. 
				System.out.println("[결과] 학생정보를 저장");
				break; // switch문을 빠져나간다. 
			case 2:
				System.out.println("[결과] 학생정보를 변경");
				break;
			case 3:
				System.out.println("[결과] 학생정보를 삭제");
				break;
			case 4:	
				System.out.println("[결과] 학생정보를 검색");
				break;
			}
			System.out.println();
		}
		System.out.println("[메세지]학생 관리 프로그램을 종료합니다.");
		scanner.close();
	}

}
