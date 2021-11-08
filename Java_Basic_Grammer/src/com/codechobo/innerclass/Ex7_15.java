package com.codechobo.innerclass;
import com.codechobo.innerclass.Ex7_12.StaticInner;

class Outer2 {
	class InstanceInner {
		int iv = 100;
	}
	static class StaticInner {
		int iv = 200;
		static int cv = 200;
	}
	void myMethod() {
		class LocalInner {
			int iv = 400;
		}
	}
}
public class Ex7_15 {
	public static void main(String[] args) {
		Outer2 ou = new Outer2(); // 외부 클래스의 인스턴스를 먼저 생성하고 인스턴스 클래스 생성 가능 
		Outer2.InstanceInner ii = ou. new InstanceInner();
		
		System.out.println("ii.iv : " + ii.iv);
		System.out.println("Outer2.StaticInner.cv : " + Outer2.StaticInner.cv);

		// 스태틱 내부 클래스의 인스턴스는 외부클래스를 먼저 생성 하지 않아도 된다.
		Outer2.StaticInner ou2 = new Outer2.StaticInner();
		System.out.println(ou2.cv);	
		System.out.println(Outer2.StaticInner.cv); // static 내부클래스는 바로 접근 가능 
		System.out.println(StaticInner.cv); // static 내부클래스는 바로 접근 가능 
	}
}
