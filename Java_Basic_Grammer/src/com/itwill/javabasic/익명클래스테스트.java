package com.itwill.javabasic;

public class �͸�Ŭ�����׽�Ʈ {
	
	public static void main(String[] args) {
		(new Object() {
			public void methodTest() {
				System.out.println("���");
				StaticMethod();
			}
			public static void StaticMethod() {
				System.out.println("����");
			}
		}).methodTest();
		
	}
}
