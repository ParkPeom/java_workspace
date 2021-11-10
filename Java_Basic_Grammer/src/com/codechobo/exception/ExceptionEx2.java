package com.codechobo.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx2 {
	// ��� ����
	Scanner sc;
	int first;
	int second;
	// ������ �޼���
	public ExceptionEx2() {
		sc = new Scanner(System.in);
		numberProcess();
	}
	// �޼��� ����
	void numberProcess() {
		// 1.  ������ �غ��ϱ�
//		try { // ������ �߻��ҰͰ��� 1. ������ �غ��ϱ� 
//		System.out.print("ù��° ������ =");
////		// ������ �Է��� ���� 
//		first = sc.nextInt(); // InputMismatchException 
//		System.out.print("�ι�° ������ ="); // InputMismatchException 
//		second = sc.nextInt();
//		
//		}catch(Exception e) { // ���࿡ ���ܰ� �߻��ϸ� ó���� ���๮�� �ʱ�ȭ
//			// ���� �߻��ÿ��� �����
//			// ���࿡ ���ܰ� �߻��ϸ� ó���� ���๮�� ǥ���ϴ� ��
//			System.out.println(e.getMessage());	 
//		}
//		int hap = first + second;
		// 2. ��� �ϱ�
		// 3. ��� �ϱ�
		// %d : decimal(����) , %f : float �Ǽ� , %s : String ���ڿ�
		// %c : Character(����)  
//		System.out.printf("%d + %d = %d\n",first,second,hap);
	
		// �Է¹��� �μ��� ������ ���� ����϶�.
		try {
			System.out.print("ù��° ������ =");
			first = sc.nextInt();
			System.out.print("�ι�° ������ =");
			second = sc.nextInt();
			
			int div = first / second;
			System.out.println(first + "  /  " + second + "=" + div);
		}catch(InputMismatchException ime) {
			System.out.println("�����͸� �߸� �Է� �ϼ̽��ϴ�.");
			// ���� �߻��� ������ ������ Ȯ���Ҽ� �ִ�.
//			ime.printStackTrace();
			System.out.println("�����޽��� : " + ime.getMessage());
			
		}catch(ArithmeticException e) {
			System.out.println("0���� ������ �����ϴ�.");
			// ����߻��� ������ ������ Ȯ���Ҽ� �ִ�.
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}	
	}
	
	public static void main(String[] args) {
		new ExceptionEx2();
	}
}
