package com.codechono.innerclass;

public class AnonymousTest {
	
	public AnonymousTest() {}
	
	void start() {	
		// 익명의 내부클래스
		new Sample() {  // 익명클래스 
			// Sample 상위 그밑 하위클래스 라고 생각
			// 메서드 오버라이딩
			public void sum() {
				int s = 0;
				for(int i = 2; i <= 100; i+=2) {
					s += i;
				}
				System.out.println("1~100까지의 짝수의 합은 " + s);
			}
			// 새로운 메서드 생성 (Sample 에 존재하지않은 메서드)
			// 3의 배우싀 합을 구하는 메서드를 생성
			public void threeSum(int max) {
				int tot=0;
				for(int i = 0; i <= max; i+=3) {
					tot += i;
				}
				System.out.println("1~"+ max +" 까지의 3의 배수합은 " + tot);
			}
			public void fourSum(int min) {
				sum();
			}
		}.fourSum(100);
//		sam.sum();
//		sam.threeSum(10); 새로운 메서드 호출을못함..
	}
	public static void main(String[] args) {
		new AnonymousTest().start();	
	}
}
