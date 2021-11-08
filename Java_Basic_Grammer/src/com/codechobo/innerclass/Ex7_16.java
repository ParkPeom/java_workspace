package com.codechobo.innerclass;

class Outer3 {
	int value = 10;
	class Inner {
		int value = 20;
		void method1() {
			int value = 30;
			System.out.println("             valie :" + value); // 30 
			System.out.println("       this.value :" + this.value); // 20 
			System.out.println("Outer3.this.value :" + Outer3.this.value); // 10
		}
	}
}
public class Ex7_16 {
	public static void main(String[] args) {
		Outer3 outer = new Outer3();
		Outer3.Inner inner = outer.new Inner();
		inner.method1();
	}
}
