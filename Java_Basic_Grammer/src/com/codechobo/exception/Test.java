package com.codechobo.exception;

public class Test {
	
	public Test() {
	
	}
	// 1. Ŭ������ ��ü�� �����. 
	public void testMethod() {
		ExceptionEx qa = new ExceptionEx();
		qa.addsum(); // Ŭ������ �޼��带 ȣ���ؼ� ���°��� ��ü���� �̴�.
		
	}

	public static void main(String[] args) {
//		new Test().testMethod();
		new ObjectTest();
	}
}
