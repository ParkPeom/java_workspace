package com.codechono.innerclass;

// 메서드 내의 내부 클래스 
public class MethodInnerClass {
	
	String userid = "hong";
	String userpwd = "1234";

	//생성자 만들어주는게 좋음 - 나중 상속관계
	public MethodInnerClass() {}
	
	void innerClassTest() {
		
		// 메서드 내부클래스
		class MethodInner {
			String username = "박범";
			
			public MethodInner() {}
			void getMemberOutput() {
				System.out.println("username : " + username);
				// 외부클래스의 멤버변수를 접근할수 있다.
				System.out.println("userid : " + userid );
				// 외부클래스의 메서드를 호출할 수 있다.
				System.out.println("userpwd : " + userpwd);
				memberOutput();
			}
			
		}
		////////////////// 여기서만 객체를 만들수있다.
		////////////////// 오로직 내부에서만 객체를 생성할수있음
		// 메서드의 내부클래스는 메서드 내에서 만 객체를 생성할 수 있다.
		MethodInner mi = new MethodInner();
		mi.getMemberOutput();
		
	}
	void memberOutput() {
		System.out.println("아이디 = " + userid);
	}
	
	
	public static void main(String[] args) {
		new MethodInnerClass().innerClassTest();
		// 외부클래스의 객체를 생성해서 메서드를 호출하면 
		// 메서드의 내부클래스 객체의 메서드를 호출할수있다.
		
		
		
	}
}
