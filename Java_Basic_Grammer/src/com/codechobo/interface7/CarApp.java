package com.codechobo.interface7;

public class CarApp {
				// JVM이 public class CarApp 읽어들어서 static 메인 메서드를 호출 
	public static void main(String[] args) {
		
		/*
		 * Car car = new Car("홍길동","싼타페");
		 * 
		 * System.out.println("소유주 : " + car.getUserName()); System.out.println("모델명 : "
		 * + car.getModelName());
		 */
		
		
		// Object 메서드의  toString() - 객체를 문자열로 저장하여 반환 한다.
		/*
		System.out.println(" car.toString() = " + car.toString());
		
		// getClass().getname() + '@' + Integer.toHesString(hashCode())
						// 인스턴스로 만들어주는 메서드에  16진수 해시코드 로 만들어줌
		
		// Car 클래스는 Object 클래스를 상속 받기 때문에 Object 클래스의 메서드 호출 가능
		// Object.toString() : 인스턴스를 문자열로 반환하여 반환하는 메서드 
		
		
		// 참조변수에 저장된 인스턴스를 출력할 경우 자동으로 Object 클래스의 tostring() 메서드를 를 호출한다.
		// 하여 참조변수에 저장된 인스턴스를 문자열로 반환하여 출력 
		
		// 부모클래스의 메서드가 맘에 안들면 오버라이딩 
		System.out.println("car = " + car); 
		System.out.println("=========================================");
		*/
		
		// Object 클래스의 toString() 메서드를 호출하여 Object 클래스의 메서드 대신 자식 클래스의
		// toString() 메서드가 호출된다. 
//		System.out.println(car); // 인스턴스의 필드값을 반환받아 출력 (자식에서 오버라이드)
		System.out.println("==========================================");

		
		// Object 클래스의 toString() 메서드 대신 String클래스의 toString() 호출 
		String name = "홍길동";
		System.out.println("name.toString " + name.toString());
		System.out.println(name); // 자동으로 String클래스에서 toStrng 재정의해서 호출
	
	}
	
}
