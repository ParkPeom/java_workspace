package com.codechobo.innerclass;
public class AnonymousTest {
	AnonymousTest(){}
	void start() {
		//익명의 내부클래스
		new Sample() {
			//익명클래스
			//메소드 오버라이딩
			public void sum() {
				int s=0;
				for(int i=2; i<=100; i+=2) {
					s += i;
				}
				System.out.println("1~100까지의 짝수의 합은 "+ s);
			}
			//새로운 메소드 생성	
			//3의 배수의 합을 구하는 메소드를 생성
			public void threeSum(int max) {
				int total = 0;
				for(int n=0; n<=max ; n+=3) {
					total+= n;
				}
				System.out.println("1~"+max+"까지의 3의배수의 합은 "+ total);
			}
		}.threeSum(100);
		//sam.sum();
		//sam.threeSum(10);
	}	
	public static void main(String[] args) {
		new AnonymousTest().start();
	}
}
