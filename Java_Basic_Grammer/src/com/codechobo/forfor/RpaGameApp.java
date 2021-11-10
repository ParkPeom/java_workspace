package com.codechobo.forfor;

import java.util.Scanner;

// 가위바위보 게임 프로그램을 작성 하세요 
// => 컴퓨터(난수)와 사용자(키보드) 의 가위바위보 대결
// => 사용자가 이길 경우 대결 반복 실행하며 질 경우 게임 종료
// => 게임 종료 후 사용자의 승리 횟수 출력 

//컴퓨터와 사용자의 승패를 판단하여 결과 출력
		// => 사용자가 이긴 경우 연승 횟수를 1 증가 시킨다. >> 계속 대결을 반복할수 있도록 한다.
		// => 사용자가 지는 경우 반복문을 종료 한다. 	
public class RpaGameApp {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 사용자의 연승 횟수를 저장하기 위한 변수
		int count = 0;
		// 가위바위보 대결 - 반복 처리
		int user;
		while(true) {
			// 컴퓨터에게 가위바위보 중 하나를 제공받아 저장 >> 난수 : 1 ~ 3 
			// => 1 : 가위 , 2 : 바위 , 3 : 보 
			// 1 ~ 3 범위의 정수값을 난수로 제공받아 저장 
			int computer = (int)(Math.random() * 3) + 1; // random()*10)%3+1
			// 사용자에게 가위,바위,보 중 하나를 입력 받아 저장 
			// => 입력값이 1 ~ 3 범위의 정수값이 아닌 경우 에러 메세지 출력 후 재입력
			while(true) { // 이반복문은 올바른 값을 입력할 경우 빠져 나간다.
				System.out.println("가위바위보 [ 1. 가위, 2. 바위 , 3. 보] >> ");
				user = scanner.nextInt();
				if(user >= 1 && user <= 3) break;
				System.out.println("[에러] 가위,바위,보 중 하나만 선택 가능합니다.");
			}	
			// 컴퓨터와 사용자가 제공한 가위바위보를 출력 
			System.out.print("[입력] 컴퓨터 = ");
			if(computer == 1) {
				System.out.println("가위");
			} else if (computer == 2) {
				System.out.println("바위");
			} else {
				System.out.println("보");
			}
			System.out.print("사용자 = ");
			if(user == 1) {
				System.out.println("가위");
			} else if (user == 2) {
				System.out.println("바위");
			} else { 
				System.out.println("보");
			}	
			if(computer == user) {
				System.out.println("[결과] 사용자와 컴퓨터가 비겼습니다.");
				// 사용자가 이긴 경우 
			} else if(computer==1 && user==2 || (computer==2 && user==3) || (computer==3 && user==1)) {
				System.out.println("[결과] 사용자가 컴퓨터에게 이겼습니다.");
				count++; // 사용자가 이기면 연승횟수 증가
			} else {
				System.out.println("[결과] 사용자가 컴퓨터에게 졌습니다.");
				break; // 반복문 종료 - 대결 종료 
			} 
		} 	
		// 게임 결과 출력 	
		System.out.println();
		if(count == 0) {
			System.out.println("사용자가 컴퓨터에게 한번도 이기지 못했습니다.");
		} else {
			System.out.println("사용자가 컴퓨터에게 " + count + "번 연속해서 이겼습니다.");
		}
		scanner.close();
	}
}
