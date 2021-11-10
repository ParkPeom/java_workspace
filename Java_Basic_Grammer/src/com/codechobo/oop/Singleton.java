package com.codechobo.oop;

// 싱글톤 디자인 패턴이 적용된 클래스 - 싱글톤 클래스(Singleton class)
// => 프로그램에 인스턴스를 하나만 제공하기 위한 클래스 

public class Singleton {
	
	// 클래스의 인스턴스를 저장하기 위한 필드 선언
	// => static 지정자를 이용하여 정적 필드로 선언 
	// 시스템 필드 : 클래스 내부에서만 사용될 값을 저장하기 위한 필드 
	// => Getter & Setter 메서드 미선언
	// => 필드의 이름은 _로 시작되도록 선언하는 것을 권장한다
	private static Singleton _instance;
	
	// 생성자를 은닉화 선언 - 클래스 외부에서 인스턴스 생성 불가능 
	// private - 
	private Singleton() {
		
	}
	// 정적 영역 (static Block) : 클래스가 메모리에(Static)에 저장된 후 자동 실행될 명령을
	// 작성하는 영역 - 프로그램에서 한번만 실행되는 명령 
	// => 정적 필드 , 정적 메서드만 사용할수있다. 
	static {
		// 클래스로 인스턴스를 생성하여 시스템 필드(정적필드)에 저장 
		_instance = new Singleton();
	}
	// 시스템 필드에 저장된 인스턴스를 반환하는 정적 메서드 선언 
	public static Singleton getInstance() {
		return _instance; // 시스템에 저장된 인스턴스를 반환하면됨 
		// 참조변수를 넘겨준다.
	}
	
	// 인스턴스 메서드 선언 
	public void display() {
		System.out.println("Singleton 클래스의 display() 메서드 호출 ");
	}	

}
