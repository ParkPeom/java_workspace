package com.codechobo.exception;

public class Ex8_9 {
	
	// throws ���ѱ�� �ڱ⸦ ȣ���� ������� ���ܸ� ���ѱ�
	
	public static void main(String[] args) throws Exception {
		
		method1(); // ���� Ŭ�������� static ��� �̹Ƿ� ��ü�������� ���� ȣ�� ����
		
	}
	static void method1() throws Exception {
		method2();
	}
	
	static void method2() throws Exception {
		throw new Exception(); // üũ�� ���� 
	}
}
