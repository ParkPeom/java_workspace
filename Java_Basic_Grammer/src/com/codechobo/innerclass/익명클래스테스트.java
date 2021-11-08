package com.codechobo.innerclass;

public class 익명클래스테스트 {
	
	public static void main(String[] args) {
		(new Object() { // 클래스의 정의와 객체 생성을 동시에 한다 - 일회용
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
