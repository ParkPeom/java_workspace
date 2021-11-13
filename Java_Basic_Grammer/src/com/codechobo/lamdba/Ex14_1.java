package com.codechobo.lamdba;

@FunctionalInterface
interface MyFunction2 {
	void run(); // public abstract void run();
}

public class Ex14_1 {
	static void execute(MyFunction2 f) { // 매개변수의 타입이 MyFunction인 메서드
						// 매개변수로 람다식을 받음 ㅇㅇ 
		f.run();
	}
	
	static MyFunction2 getMyFunction() { // 반환타입이 인터페이스 인 MyFunction인 메서드
		MyFunction2 f = () -> System.out.println("f3.run()"); // void run();
		return f;
	}
	public Ex14_1() {
	}
	public static void main(String[] args) {
		//람다식으로 MyFunction의 run()을 구현
		MyFunction2 f1 = () -> System.out.println("f1.run()");
		
		MyFunction2 f2 = new MyFunction2() { // 익명클래스로 run()을 구현
			public void run() { // public을 반드시 붙여야 한다
				System.out.println("f2.run()");
			}
		};
		MyFunction2 f3 = getMyFunction();
		
		// 람다식 호출 
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( ()-> System.out.println("run()"));
	}
}
