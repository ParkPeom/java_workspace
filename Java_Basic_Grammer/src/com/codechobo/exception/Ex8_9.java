package com.codechobo.exception;

public class Ex8_9 {
	
	// throws 떠넘기기 자기를 호출한 사람한테 예외를 떠넘김
	
	public static void main(String[] args) throws Exception {
		
		method1(); // 같은 클래스내의 static 멤버 이므로 객체생성없이 직접 호출 가능
		
	}
	static void method1() throws Exception {
		method2();
	}
	
	static void method2() throws Exception {
		throw new Exception(); // 체크드 예외 
	}
}
