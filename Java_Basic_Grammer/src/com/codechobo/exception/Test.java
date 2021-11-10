package com.codechobo.exception;

public class Test {
	
	public Test() {
	
	}
	// 1. 클래스를 객체로 만든다. 
	public void testMethod() {
		ExceptionEx qa = new ExceptionEx();
		qa.addsum(); // 클래스로 메서드를 호출해서 쓰는것이 객체지향 이다.
		
	}

	public static void main(String[] args) {
//		new Test().testMethod();
		new ObjectTest();
	}
}
