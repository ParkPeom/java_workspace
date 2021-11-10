package com.codechobo.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExMain {
	
	Scanner sc = new Scanner(System.in);
	
	public ExceptionExMain() {

	}
	// 단을 입력받아 구구단을 출력하는 메서드
	public void gugudan() {
		while(true) {
			try {
			System.out.print("단을 입력하세요 > ");
			int dan = sc.nextInt();
			sc.nextLine();
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d \n" , dan, i , dan * i);
			}
		} catch(InputMismatchException ime) {
				System.out.println("단은 숫자(정수)만 입력하세요.");
//				int dan = sc.nextInt();
				int dan = Integer.parseInt(sc.nextLine()); // 문자열을 정수로 
				for(int i = 1; i <= 9; i++) {
					System.out.printf("%d * %d = %d \n" , dan, i , dan * i);
				}
				ime.printStackTrace();
				break;
			}
		}
	}
	
	public static void main(String[] args) {
//		new ExceptionExMain().gugudan();
//		System.out.println("아이디 = " + args[0]);
//		System.out.println("비밀번호 = " + args[1]);
		// 아이디와 비밀번호 일치할 경우 서비스를 제공하겠다.
		if(args[0].equals("djkk1234") && args[1].equals("1234")) {
				System.out.println("로그인 되셨습니다.");
				// 그러면 구구단을 제공함
				new ExceptionExMain().gugudan();
			} else {
				System.out.println("아이디와 비밀번호를 잘못입력하였습니다.");
			}
		}
	}
