package com.itwill.javabasic;

import java.util.Scanner;

public class 예외던지기 {
	Scanner scan = new Scanner(System.in);
	public 예외던지기() {
		int sum = printApp();
	}
	public int printApp() {
		int first = stringprint("첫 번째 "); 
		int second = stringprint("첫 번째 "); 
		return first + second;
	}
	
	public int stringprint(String msg) {
		System.out.print(msg + "=");
		int num = 0;
	do {	
		try {
			num = scan.nextInt();
			if(num < 0) {
				throw new ExceptionApp("오류가 발생");	
			}
		}catch(ExceptionApp e) {
			System.out.println("오류가 발생하였습니다.");
		}
		return num;
	} while(num < 0);
}
	public static void main(String[] args) {
		new 예외던지기();
	}
}
