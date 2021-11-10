package com.codechono.innerclass;
//내부클래스는 클래스내에 정의하는 클래스이다.
// 1.클래스의 멤버영역에 정의하는 내부클래스
// 2.메서드에 정의하는 내부클래스
// 3.클래스명이 존재하지 않는 익명(anonymous)의 내부클래스 

// 외부클래스 = 범위 부모같은 개념 
public class OuterClass {
	//멤버영역의 선언
	//멤버변수
	// static{}
	// 외부에 있는 멤버변수
	
	int num = 100;
	String name = "홍길동";

	
	//생성자 
	OuterClass() {
		System.out.println("OuterClass()->실행됨");
//		System.out.println("주소 : " + addr); 내부 멤버 못씀
//		외부클래스에서 내부 클래스의 멤버 변수는 접근할수 없다.		
		
		// 외부클래스에서 내부 클래스의 메서드는 호출할 수 없다.
		// int r = ic.sumResult(10,20);
		
		
	}
	//메서드
	void method() {
		// 현재클래스의 내의 내부 클래스를 객체생성하여 메서드 호출하기
		InnerClass ii = new InnerClass();
		ii.memberOutput();
	}
	
	void message() {
		System.out.println("외부 클래스의 message() 메서드 실행됨.");
	}
	
	//내부클래스 = 자식 
	public class InnerClass {
		//내부에 있는 멤버변수
		String userid = "hong";
		String addr = "서울시 강남구";
		
		// 생성자 메서드
		InnerClass() {
			System.out.println("InnerClass()->실행됨");
		}
		InnerClass(String addr){
			this.addr = addr;
			System.out.println("InnerClass(String addr)->실행됨");
		}
		// 메서드
		void memberOutput() {
			System.out.println("아이디 : " + userid);
			System.out.println("주소 : " + addr);
			// 내부클래스에서 외부클래스 멤버 쓸수있음 
			System.out.println("이름 : " + name);
			// 외부클래스의 메서드는 내부 클래스에서 호출 가능하다. 
			message();
		}
		
		int sumResult(int n1,int n2) {
			return n1+n2;
		}
	}
	
	public static void main(String[] args) {
		// 다른 클래스에서 내부 클래스 객체 생성하여 메서드를 호출할수있다.
		// 1. 외부 클래스를 먼저 객체 생성
		OuterClass oc = new OuterClass();
		OuterClass.InnerClass ic = oc.new InnerClass();
		// 2. 외부 클래스 객체를 통해 내부 클래스 객체를 생성할 수 있다.
	
		// 3. 외부를 만들고 내부를 만들지 못하면 내부접근 못함
		ic.memberOutput();
		System.out.println("========================");
		// 내부 클래스 객체 생성 방법 2  
		// 한번에 만드는 방법
		OuterClass.InnerClass ic2 = new OuterClass().new InnerClass();
		ic2.memberOutput();
		
		System.out.println("========================");
		oc.method();
		
	}
}
