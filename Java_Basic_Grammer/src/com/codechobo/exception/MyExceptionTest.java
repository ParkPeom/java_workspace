package com.codechobo.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyExceptionTest {
	
	Scanner sc = new Scanner(System.in);

	public MyExceptionTest() {
	
	}
	void start() {
		// 1 ~ 100사이의 임의 수를 입력 받아 그 숫자까지 합을 구하여 출력하는 프로그램
		
	try {
		System.out.print("정수(1~100)=>");
		int max = sc.nextInt();	// 5  105 	
		// 1 ~ 100 사이가 아니면 예외 발생 
		if(max < 1 || max > 100) {
			// 강제로 예외를 발생시킨다. -- > catch문으로 이동 
			throw new MyException("임의로 예외메시지를 지정할수있다.");
		}
		
		// 합 
		System.out.println("합 은 : " + total(max));
		
		}catch(InputMismatchException e) {
			System.out.println("숫자를 입력하지 않았습니다.");
		}catch(MyException e) {
			// 1  ~ 100 사이가 아닐떄
			System.out.println(e.getMessage());
		}
	}
	public int total(int max) {
		int s = 0;
		for(int i = 1; i <= max; i++) {
			s += i;
		}
		return s;
	}
	
	public static void main(String[] args) {
		MyExceptionTest mt = new MyExceptionTest();
		mt.start();
	}
}
