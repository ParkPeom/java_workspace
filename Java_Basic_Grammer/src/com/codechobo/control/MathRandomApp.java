package com.codechobo.control;

/*
	컴퓨터로부터 난수값을 제공받아 출력하는 프로그램 작성하시오
	=> 난수값 : 불규칙하게 발생되는 숫자값 
	
 */
public class MathRandomApp {
	
	 /*
		난수가 발생하는 게임 : 퍼즐게임 에서 많이 사용

	 */
	public static void main(String[] args) {
		
		for(int i = 1; i<=5; i++) {
			
			// Math 클래스 : 수학 관련 기능을 제공하는 메서드가 선언된 클래스
			// static 메서드를 가지고 있어서 클래스로부터 메서드를 호출할수있다.
			
			// Math.random() : 0.0 보다 크거나 같고 1.0 보다 작은 실수 난수값을 반환하는 메서드
			System.out.println(i +"번째 실수 난수 값 " + Math.random());
										
			for (int j = 0; j < args.length; j++) {
				System.out.println(i +"번째 실수 난수값 = " + Math.random()); 
			}
			System.out.println("==========================================");
			
	  		for(i = 1; i <= 5; i++) {
				// 0 ~ 99 범위의 난수를 제공받아 출력한다.
				System.out.println(i+"번째 정수 난수값 = " + (int)(Math.random()*100));
				
				// 1 ~ 45까지 
				// 0.0 <= random() < 1.0
				// (int)0 * 45 <= (int)(Math.random() * 45)  < (int)45
				// 1 <= (int)(Math.random() * 45) + 1 < (int)46
			}
			System.out.println();
		}
	}
}
