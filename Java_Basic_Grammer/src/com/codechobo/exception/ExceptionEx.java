package com.codechobo.exception;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 	�ֿܼ��� �ΰ��� ������ �Է� �޾� �μ��� ���� ��� �϶�.

  	���� 
  	ù��° ���� = ____
  	�ι�° ���� = ____
  	____ + ____ = _____
 */
public class ExceptionEx {
	Scanner sc;
	int num1 , num2 , sum , flag;
	public ExceptionEx() {
		sc = new Scanner(System.in);
		sum = addsum();
		print(sum);
	}
	// 2. �Է� 
	public int addsum() {
		do {
			flag = 1;
			try {
				System.out.print("ù���� ���� = ");
				num1 = sc.nextInt();		
				System.out.print("�ι��� ���� = ");
				num2 = sc.nextInt();	
				return num1 + num2; // 3. ó��
			}catch(InputMismatchException e) { // 4. ����ó��
				flag = 0;
				System.out.println("���ڸ� �Է����ּ���.");
				break;
			}
		} while(flag == 0);
		return 0;
	}
	// 5. ���
	public void print(int sum) {
		System.out.println(num1 + "+" + num2 + "=" + sum);
	}
	public static void main(String[] args) {
		new ExceptionEx(); // 1. ȣ��
	}
}
