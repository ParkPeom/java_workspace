package com.codechobo.exception;

import java.util.Scanner;

/*
  Data - 계산 - 출력 
 */
public class ObjectTest {
	
	public ObjectTest() {
		start();
	
	}
	public void start() {
		int a = conIntInput("첫번째 정수");
		int b = conIntInput("두번째 정수");
		int result = calculator(a,b);
		resultOutput(a , b , result);
	}
	
	// 정수를 입력받는 메서드 : 메시지는 매개변수(argument)로 대입한다.
	public int conIntInput(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.println(msg + "=");
		int data = scan.nextInt();
		return data;
	}
	// 계산 : 콘솔에서 입력받은 2개의 수를 매개변수로 전달받아 합을 구한 후 반환하는 메서드 생성
	
	public int calculator(int n1 , int n2) {
		int hap = n1 + n2;
		return hap;
	}
	
	// 출력하기 : 첫번째 , 두번째 , 합 
	public void resultOutput(int one , int two , int result) {
		System.out.printf("%d + %d = %d\n", one , two , result);
	}
}
