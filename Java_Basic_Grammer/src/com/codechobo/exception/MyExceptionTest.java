package com.codechobo.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyExceptionTest {
	
	Scanner sc = new Scanner(System.in);

	public MyExceptionTest() {
	
	}
	void start() {
		// 1 ~ 100������ ���� ���� �Է� �޾� �� ���ڱ��� ���� ���Ͽ� ����ϴ� ���α׷�
		
	try {
		System.out.print("����(1~100)=>");
		int max = sc.nextInt();	// 5  105 	
		// 1 ~ 100 ���̰� �ƴϸ� ���� �߻� 
		if(max < 1 || max > 100) {
			// ������ ���ܸ� �߻���Ų��. -- > catch������ �̵� 
			throw new MyException("���Ƿ� ���ܸ޽����� �����Ҽ��ִ�.");
		}
		
		// �� 
		System.out.println("�� �� : " + total(max));
		
		}catch(InputMismatchException e) {
			System.out.println("���ڸ� �Է����� �ʾҽ��ϴ�.");
		}catch(MyException e) {
			// 1  ~ 100 ���̰� �ƴҋ�
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
