package com.codechobo.reallization;

// 클래스 선언시 기존 클래스를 상속받기 위해 extends 키워드를 사용 - 단일 상속만 가능
// 클래스 선언시 기존 인터페이스를 상속받기 위해 implements 키워드 사용 - 다중 상속 가능

// => 인터페이스를 상속받은 자식클래스는 인터페이스의 모든 추상메서드를 반드시 오버라이드 선언해줘야 한다.
public class WolfHuman extends Human implements Wolf {

	@Override
	public void cryLoudly() {
		System.out.println("[늑대] 큰소리로 울부짓을수 있는 능력");
	}

	@Override
	public void fastWlak() {
		System.out.println("[늑대] 내발로 빠르게 달릴 수 있는 능력");
		// TODO Auto-generated method stub
	}
	
	public void change() {
		System.out.println("[늑대인간] 변신할 수 있는 능력");
	}
	
	
}
