package com.codechobo.exception;

import java.util.Scanner;

public class ExceptionEx02 {
	Scanner s = new Scanner(System.in);
	public ExceptionEx02() {

	}
	public void testStart() {
		try {
		int n1 = Integer.parseInt(s.nextLine()); // 한줄 입력받아서 정수로 변환
		int n2 = Integer.parseInt(s.nextLine()); // number Exception
		
		System.out.println(n1 + "+" + n2 +"="+n1+n2);
		System.out.println(n1 + "/" + n2 +"="+n1/n2); // Arth
		
		String[] names = {"홍길동","김길동","박길동"};
		for(int i=0; i < names.length; i++) { // 0, 1, 2, 3
			System.out.println("names[" + i + "]=" + names[i]); // Array
		}
	} catch(NumberFormatException e) {
		System.out.println("숫자를 입력하세요.");
	} catch (Exception e) {
		System.out.println(e.getMessage());
	} finally {
		// 예외가 발생하든 안하든 무조건 실행 
		System.out.println("finally 영역이 실행됨.");
	}
}
	public static void main(String[] args) {
		ExceptionEx02 ee = new ExceptionEx02();
		ee.testStart();
		
	}
}
