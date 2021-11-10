package com.codechobo.oop;

/*
  Runtime : Java 프로그램을 실행하는 JVM 관련 정보를 저장하는 클래스  
  => 생성자가 은닉화 선언되어 있어 NEW 연산자로 인스턴스 생성 불가능
  => getRuntime() 이라는 정적 메서드 호출하여 Runtime인스턴스를 반환받아 사용
  => 프로그램에 인스턴스를 하나만 제공하는 클래스 - 싱글톤 클래스(Singleton class)
 */
public class RunTimeApp {
	
	public static void main(String[] args) {
		
// Runtime runtime = new Runtime(); 생성자가 은닉화되어 인스턴스화 할수 없다.
		
		// 클래스로부터 static 인 getRuntime() 으로 반환받아올수있다.
		
		// Runtime.getRuntime() : Runtime 인스턴스를 반환하는 메서드
		Runtime runtime1 = Runtime.getRuntime();
		Runtime runtime2 = Runtime.getRuntime();
		
		// 두개는 같은 인스턴스
		System.out.println("runtime1 = " + runtime1);
		System.out.println("runtime2 = " + runtime2);
	
		// .getRuntime() 메서드를 여러번 호출해도 반환되는 인스턴스는 동일
		// 싱글톤 클래스는 인스턴스를 반환받아 참조변수에 저장하지 않고 직접 메서드를 호출
		// Runtime.totalMemory() : JVM이 사용할 수 있는 전체 메모리의 크기를 반환하는 메서드
		// Runtime.freeMemory() : JVM이 사용할 수 있는 남은 메모리의 크기를 반환하는 메서드
		System.out.println("청소 전 JVM 사용 메모리 크기 = " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) + "Byte");

		// Runtime.gc() : garbage collector 를 실행하는 메서드
		// => System.gc() 메서드 호출 과 동일한 기능 제공 
		// Runtime.getRuntime().gc();
		System.gc(); // 정적메서드로 호출 
		
		System.out.println("청소 후 JVM 사용 메모리 크기 = " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) + "Byte");
	}
}
