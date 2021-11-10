package com.codechobo.interface7;

public class PrintApp {
	
	public static void main(String[] args) {
	// 기본메서드를 호출하기 위해서는 참조변수를 반드시 인터페이스로 생성
		
		Printable printOne = new PrintSingle();
		
		printOne.print();
		printOne.scan(); // 부모 인터페이스의 기본 메서드 호출
		
		System.out.println("==============");
		Printable printTwo = new PrintMultiple();
		
		printTwo.print();
		printTwo.scan(); // 자식 인스턴스의 오버라이드 메서드 호출
		
	}
}
