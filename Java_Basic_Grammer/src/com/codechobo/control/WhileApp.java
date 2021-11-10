package com.codechobo.control;


/*
	while문은 반복횟수가 정해져 있지 않을때 쓰인다

 */
public class WhileApp {
	
	public static void main(String[] args) {
		
		// Java Programming 를 화면에 5번 출력	
		int i = 1; // 초기식(따로 써줌)
		while(i <= 5) { // 조건식 
			
			System.out.println("Java Programming");
			i++; // 증감식 (따로 써줌)
		}
		System.out.println("============");
		
		// 1 ~ 100 범위의 정수 합계 -> 정수의 합계는 범위가 정해져 있어서 for문을 사용하는 것이 좋다 
		// GUI 는 While문을 많이 쓰인다
		i = 1;
		int sum = 0;
		do {
			sum += i;
			i++;
		} while( i < 100 );
	System.out.println("1 ~ 100 합 : " + sum);	
	
	// A4 용지를 반으로 계속 접어 펼쳤을 때 사각형 모양이 500개 이상이 만들어 지려면 몇번 접어야 되는지
	// 예상하여 출력하시오(반복횟수를 모를때 while문) 
	int num = 0;
	i = 0; // 접는 횟수 
	while(true) {
		i++; // 접은횟수 
		num++; // 사각형갯수 증가식 
		
		if(num >= 500) { // 사각형 모양의 갯수가 500개 이상인 경우 반복문 종료 
			break;
		}	
		num *= 2; // 사각형 갯수 
	}
	System.out.print("접은 횟수는 : " + i + " 사각형의 갯수는 : " + num);
	System.out.println("");
	
	int gae = 1;
	int cnt = 0;
	
	while (gae <= 500) {
		cnt++;
		gae *= 2;
	}
	System.out.print("접은 횟수는 : " + i + " 사각형의 갯수는 : " + num);
	System.out.println("");
	
	
	// 1 ~ x 범위의 정수들의 합계가 300 이상 되려면 x가 얼마인지 계산하여 출력하시오
	// 언제까지 반복해야할지 모를때 while 를 쓰는게 효율적이다.
	
	i = 1 ;
	int sum2 = 0;
	while(true) {
	
		sum2 += i;
		if(sum2 >= 300) {
			break;
		}
		i++;
	}
	System.out.println("x 의 계수 범위는 " + i );
	
	}
}
