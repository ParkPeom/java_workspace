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
		Outer2 ou = new Outer2(); // �ܺ� Ŭ������ �ν��Ͻ��� ���� �����ϰ� �ν��Ͻ� Ŭ���� ���� ���� 
		Outer2.InstanceInner ii = ou. new InstanceInner();
		
		System.out.println("ii.iv : " + ii.iv);
		System.out.println("Outer2.StaticInner.cv : " + Outer2.StaticInner.cv);

		// ����ƽ ���� Ŭ������ �ν��Ͻ��� �ܺ�Ŭ������ ���� ���� ���� �ʾƵ� �ȴ�.
		Outer2.StaticInner ou2 = new Outer2.StaticInner();
		System.out.println(ou2.cv);	
		System.out.println(Outer2.StaticInner.cv); // static ����Ŭ������ �ٷ� ���� ���� 
		System.out.println(StaticInner.cv); // static ����Ŭ������ �ٷ� ���� ���� 
	}
}
