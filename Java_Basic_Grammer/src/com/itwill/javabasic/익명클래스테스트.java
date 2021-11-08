package com.itwill.javabasic;

public class 익명클래스테스트 {
	
	public static void main(String[] args) {
		(new Object() {
			public void methodTest() {
				System.out.println("출력");
				StaticMethod();
			}
			public static void StaticMethod() {
				System.out.println("하하");
			}
		}).methodTest();
		
	}
}
