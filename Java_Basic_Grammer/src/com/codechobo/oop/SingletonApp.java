package com.codechobo.oop;

public class SingletonApp {
	
	public static void main(String[] args) {
		
		/*
		// new 연산자로 클래스의 생성자를 호출하여 인스턴스를 생성 
		// => 생성된 인스턴스를 참조변수에 저장하여 사용 
		// => 참조변수를 이용하여 인스턴스의 메서드 호출 
		// => 인스턴스의 메서드를 지속적으로 호출하고자 할경우 사용 
		
		Singleton singleton = new Singleton();
		sing.display();
		
		// new 연산자로 클래스의 생성자를 호출하여 인스턴스 생성 후 메서드 직접 호출 가능
		// => 인스턴스 생성 후 메서드를 하나만 호출할 경우 사용
		new Singleton().display();
		*/
		// new 연산자로 생성자를 호출하여 인스턴스를 생성하면 서로 다른 값이 저장된 인스턴스다 
		// => 일반적인 클래스는 인스턴스를 여러개 생성할수있다.
		// => 똑같은걸 계속 생성하는 낭비다..
		/*
		Singleton singleton1 = new Singleton();
		Singleton singleton2 = new Singleton();
		
		System.out.println("singleton1 = " + singleton1);
		System.out.println("singleton2 = " + singleton2);

		singleton1.display();
		singleton2.display();
		*/
		
		//<------------------불필요한 참조변수가 생성되는걸 막고싶으면 ? ---------------
		// 싱글톤패턴을 사용해보자 > 인스턴스를 반환하는 정적메서드를 호출하여 인스턴스를 반환받아 저장  
		// => 클래스가 메모리에 저장된 후 미리 생성된 인스턴스 반환 - 동일 인스턴스 반환 
		
		Singleton singleton1 = Singleton.getInstance(); // 인스턴스를 넘겨줄수있다.
		Singleton singleton2 = Singleton.getInstance(); // 인스턴스를 넘겨줄수있다.
		
		System.out.println("singleton1 = " + singleton1);
		System.out.println("singleton2 = " + singleton2);
		System.out.println("===========================");
		singleton1.display();
		singleton2.display();
		System.out.println("===========================");
		
		if(singleton1 == singleton2) {
			System.out.println(true);
		}
		
		
		// 싱글톤 클래스는 인스턴스를 반환받아 직접 메서드를 호출하는것을 권장한다. 
		singleton1.getInstance().display();
		// System.out.println();
		System.out.println();
	}
}
