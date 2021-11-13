package com.codechobo.lamdba;

public class lamdaTest {
	
	public lamdaTest() {
	
	}
	public static void main(String[] args) {
		// Object obj = (a, b) -> a > b ? a : b; // 람다식. 익명객체
		MyFunction f = new MyFunction() { // 익명함수를 다루기 위한 참조변수는 Object
			public int max(int a, int b) { // 오버라이딩 - 접근제어자는 좁게 못바꾼다
				return a > b ? a : b;
			}
		}; // 이걸 간단히 표현한게 람디식 
		// ★ 람다식을 다루려면 참조변수가 필요한데.. 그건 함수형 인터페이스 ★
		
		// 람다식(익명 객체)을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
		MyFunction f2 = (a , b) -> a > b ?  a : b;
		
		int value = f.max(3,5); // 함수형 인터페이스가 필요함.(다음 강의에서 배움)
		System.out.println("value="+value);
		
	}	
}

@FunctionalInterface // 함수형 인터페이스 표시하면 - 무조건 추상메서드는 하나 
interface MyFunction { 
//	public abstract int max(int a,int b); public abstract 생략 가능
	int max(int a,int b); // 추상메서드를 통해서 람다식을 호출한다. 
}