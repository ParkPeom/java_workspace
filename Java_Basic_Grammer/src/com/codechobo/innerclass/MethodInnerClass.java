package com.codechobo.innerclass;
//2. 메소드에 정의하는 내부클래스
public class MethodInnerClass {
	String userid = "hong";
	String userpwd = "1234";
	
	MethodInnerClass(){
		
	}
	void innerClassTest() {
		//내부클래스
		class MethodInner{
			String username="이순신";
			MethodInner(){
				
			}
			void getMemberOutput() {
				System.out.println("username="+ username);
				//외부클래스의 멤버변수를 접근할수 있다.
				System.out.println("userid="+ userid);
				//외부클래스의 메소드를 호출할 수 있다.
				memberOutput();
			}
		}
		////////////
		//메소드내의 내부클래스는 메소드내에서 만 객체를 생성할 수 있다.
		
		MethodInner mi = new MethodInner();
		mi.getMemberOutput();
	}
	void memberOutput() {
		System.out.println("아이디="+userid);
	}
	public static void main(String[] args) {
		new MethodInnerClass().innerClassTest();
	}

}
