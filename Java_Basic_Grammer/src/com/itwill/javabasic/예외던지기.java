package com.itwill.javabasic;

import java.util.Scanner;

public class ���ܴ����� {
	Scanner scan = new Scanner(System.in);
	public ���ܴ�����() {
		int sum = printApp();
	}
	public int printApp() {
		int first = stringprint("ù ��° "); 
		int second = stringprint("ù ��° "); 
		return first + second;
	}
	
	public int stringprint(String msg) {
		System.out.print(msg + "=");
		int num = 0;
	do {	
		try {
			num = scan.nextInt();
			if(num < 0) {
				throw new ExceptionApp("������ �߻�");	
			}
		}catch(ExceptionApp e) {
			System.out.println("������ �߻��Ͽ����ϴ�.");
		}
		return num;
	} while(num < 0);
}
	public static void main(String[] args) {
		new ���ܴ�����();
	}
}
