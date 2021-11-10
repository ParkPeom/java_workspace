package com.codechobo.interface7;

public interface Printable {
	
	// 추상 메서드 - 자식 클래스에서 반드시 오버라이드 선언
	void print();
	
	// JDK1.8 이상에서는 인터페이스에 명령을 작성할 수 있는 기본 메서드 선언
	// => default 키워드로 메서드를 선언 
	// 기본 메서드(Default Method) : 인터페이스를 상속받은 자식클래스에서 
	// 오버라이드 선언하지 않아도 되는 메서드 
	// => 자식 클래스에서 오버라이드 선언하지 않으면 기본 메서드의 호출 
	
	default void scan() {
		System.out.println("[에러]스캔 기능을 제공하지 않습니다.");
		
	}
	
}
