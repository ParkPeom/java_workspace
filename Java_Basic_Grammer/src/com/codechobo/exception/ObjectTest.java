package com.codechobo.exception;

import java.util.Scanner;

/*
  Data - ��� - ��� 
 */
public class ObjectTest {
	
	public ObjectTest() {
		start();
	
	}
	public void start() {
		int a = conIntInput("ù��° ����");
		int b = conIntInput("�ι�° ����");
		int result = calculator(a,b);
		resultOutput(a , b , result);
	}
	
	// ������ �Է¹޴� �޼��� : �޽����� �Ű�����(argument)�� �����Ѵ�.
	public int conIntInput(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.println(msg + "=");
		int data = scan.nextInt();
		return data;
	}
	// ��� : �ֿܼ��� �Է¹��� 2���� ���� �Ű������� ���޹޾� ���� ���� �� ��ȯ�ϴ� �޼��� ����
	
	public int calculator(int n1 , int n2) {
		int hap = n1 + n2;
		return hap;
	}
	
	// ����ϱ� : ù��° , �ι�° , �� 
	public void resultOutput(int one , int two , int result) {
		System.out.printf("%d + %d = %d\n", one , two , result);
	}
}
