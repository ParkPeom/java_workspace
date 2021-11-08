package com.codechobo.innerclass;

public class Ex7_14 {
	private int outerIv = 0;
	static int outerCv = 0;
	
	class InstanceInner {
		int iiv = outerIv; // 1. 외부클래스의 private 멤버도 접근 가능
		int iiv2 = outerCv;
	}
	
	static class StaticInner {
//		int siv = outerIv; // 스태틱 클래스는 외부 클래스의 인스턴스멤버에 접근 불가
		static int scv = outerCv;
	}
	
	void myMethod() {
		final int lv = 0; // lv가 변수지만 값을 변경하는 코드가 없으므로 실제로는 상수와 다름 없다.
					// 값이 바뀌지 않는 변수는 상수로 간주 
		int LV = 0; // JDK 1.8 부터 final 생략 가능
//		lv = 4;
		
		// 상수는 constant pool 에 따로 저장 메서드가 종료되도 남아있다. 
		
		class LocalInner { // 2. 지역 내부 클래스를 감싸고 있는 메서드의 상수만 사용 가능 
			int liv = outerIv;
			int liv2 = outerCv;
		// 외부 클래스의 지역변수는 final 이 붙은 변수(상수)만 접근 가능
			int liv3  = lv; // 값을 바꾸면 상수로 간주하지않아서 에러가 생김 
			int liv4 =  LV;
		
			void method() {
				System.out.println(lv);
			}
		}
	}
}
