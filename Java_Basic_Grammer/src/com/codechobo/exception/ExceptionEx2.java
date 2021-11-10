package com.codechobo.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx2 {
	// 멤버 영역
	Scanner sc;
	int first;
	int second;
	// 생성자 메서드
	public ExceptionEx2() {
		sc = new Scanner(System.in);
		numberProcess();
	}
	// 메서드 생성
	void numberProcess() {
		// 1.  데이터 준비하기
//		try { // 에러가 발생할것같은 1. 데이터 준비하기 
//		System.out.print("첫번째 정수는 =");
////		// 정수로 입력을 받음 
//		first = sc.nextInt(); // InputMismatchException 
//		System.out.print("두번째 정수는 ="); // InputMismatchException 
//		second = sc.nextInt();
//		
//		}catch(Exception e) { // 만약에 예외가 발생하면 처리할 실행문을 초기화
//			// 예외 발생시에만 실행됨
//			// 만약에 예외가 발생하면 처리할 실행문을 표기하는 곳
//			System.out.println(e.getMessage());	 
//		}
//		int hap = first + second;
		// 2. 계산 하기
		// 3. 출력 하기
		// %d : decimal(정수) , %f : float 실수 , %s : String 문자열
		// %c : Character(문자)  
//		System.out.printf("%d + %d = %d\n",first,second,hap);
	
		// 입력받은 두수를 나누어 몫을 출력하라.
		try {
			System.out.print("첫번째 정수는 =");
			first = sc.nextInt();
			System.out.print("두번째 정수는 =");
			second = sc.nextInt();
			
			int div = first / second;
			System.out.println(first + "  /  " + second + "=" + div);
		}catch(InputMismatchException ime) {
			System.out.println("데이터를 잘못 입력 하셨습니다.");
			// 현재 발생한 예외의 정보를 확인할수 있다.
//			ime.printStackTrace();
			System.out.println("에러메시지 : " + ime.getMessage());
			
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없습니다.");
			// 현재발생한 예외의 정보를 확인할수 있다.
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}	
	}
	
	public static void main(String[] args) {
		new ExceptionEx2();
	}
}
