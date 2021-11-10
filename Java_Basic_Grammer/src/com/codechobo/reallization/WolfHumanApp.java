package com.codechobo.reallization;

public class WolfHumanApp {
	
	public static void main(String[] args) {
		WolfHuman wolfHuman = new WolfHuman();
		
		wolfHuman.speak();
		wolfHuman.walk();
		wolfHuman.smile();
		wolfHuman.change();
		wolfHuman.cryLoudly();
		wolfHuman.fastWlak();
		
		System.out.println("===============================");
		// 부모클래스로 참조변수를 생성하여 자식 인스턴스 저장
		// => 참조변수는 부모 인스턴스의 메서드만 호출가능
		// => 객체 형변환을 이용하면 자식 인스턴스의 메서드 호출 가능
		
		Human human = new WolfHuman();
		human.speak();
		human.walk();
		human.smile();
		
		System.out.println("===============================");
		
		// 명시적 객체 형변환을 이용하여 자식 메서드를 호출할 수 있다. 
		((WolfHuman)human).change();
		System.out.println("===============================");
//		Wolf wolf = new Wolf();
		// 인터페이스로 참조변수를 생성하여 자식 인스턴스 저장 가능
//		Wolf wolf = new WolfHuman();
		
		// 자식 클래스가 같은 부모 클래스 또는 부모 인터페이스는 서로 명시적 객체 형변환을 
		// 이용하여 자식 인스턴스 저장 가능 
		// 부모는 자식을 같이 사용할수있다.
		
		// 묵시적 객체 형변환에 의해 자식 인스턴스의 메서드 호출 
		// 인터페이스는 무조건 자식 인스턴스가 호출된다. 
		Wolf wolf = (Wolf)human;
		wolf.cryLoudly();
		wolf.fastWlak();
	}
}
