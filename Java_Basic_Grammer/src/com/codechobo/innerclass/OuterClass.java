package com.codechobo.innerclass;
//내부클래스는 클래스내에 정의하는 클래스이다.
//1. 클래스의 멤버영역에 정의하는 내부클래스
//2. 메소드에 정의하는 내부클래스
//3. 클래스명이 존재하지 않는 익명(anonymous)의 내부클래스
public class OuterClass {
	//멤버영역의 선언
	//멤버변수
	//  static{}
	int num = 100;
	String name = "홍길동";
	
	//생성자
	OuterClass(){
		//외부클래스에서 내부 클래스의 멤버 변수는 접근할수 없다.
		//System.out.println("주소="+ addr);
		System.out.println("OuterClass()->실행됨");
		
		//외부클래스에서 내부 클래스의 메소드는 호출할수 없다.
		//int r = sumResult(10, 20);
	}
	
	//메소드
	void method() {
		//현재클래스 내의 내부 클래스를 객체생성하여 메소드 호출하기
		InnerClass ii = new InnerClass();
		ii.memberOutput();
		
	}
	void message() {
		System.out.println("외부 클래스의 message()메소드 실행됨.");
	}
	//내부클래스
	//여러개 정의 가능하다.
	public class InnerClass{
		//멤버변수
		String userid = "hong";
		String addr = "서울시 강남구";
		//생성자메소드
		InnerClass(){
			System.out.println("InnerClass()->실행됨");
		}
		InnerClass(String addr){
			this.addr = addr;
			System.out.println("InnerClass(String addr)->실행됨");
		}
		//메소드
		void memberOutput() {
			System.out.println("아이디="+userid);
			System.out.println("주소="+addr);
			//내부클래스에서 외부 클래스의 멤버변수를 접근할수 있다.
			System.out.println("이름="+name);	
			//외부클래스의 메소드는 내부클래스에서 호출가능하다.
			message();
		}
		int sumResult(int n1, int n2) {
			return n1+n2;
		}
	}	
	
	public static void main(String[] args) {		
		//내부클래스 객체 생성방법 1
		//다른 클래스에서 내부클래스 객체 생성하여 메소드를 호출할 수 있다.
		// 외부클래스를 먼저 객체 생성
		OuterClass oc = new OuterClass();
		
		// 외부클래스 객체를 통해 내부 클래스 객체를 생성할수 있다.
		OuterClass.InnerClass ic = oc.new InnerClass();
		
		ic.memberOutput();
		
		//내부클래스 객체생성방버 2
		OuterClass.InnerClass ic2 = new OuterClass().new InnerClass();
		ic2.memberOutput();
		
		oc.method();
	}
}
