package com.codechobo.control;

import java.util.Scanner;

public class OperatorApp {
	
	public static void main(String[] args) {
		
		System.out.println("10 + 20 * 3 = " + (10 + 20 * 3)); // 70
		System.out.println("10 + 20 * 3 = " + ((10 + 20) * 3)); // 90
			
		// [] 배열연산자 
		// . 객체연산자 
		System.out.println("=================================");
		
		// 단항연산자 + , - 
		int a1 = 10;
		System.out.println("a1 = " + a1);  //10
		System.out.println("a1 = " + (-a1));  // -10
		
		// ! 연산자 true -> false , false -> true
		System.out.println("20 > 10 = "+ (20 > 10));
		System.out.println("20 > 10 = "+ !(20 > 10));
		
		System.out.println("=================================");
		int a2 = 10, a3 = 10;
		System.out.println("연산 전 : a2 = " + a2 + " a3 = "+ a3);
		
// 유일하게 연산자 피연산자 순서가 바껴도됨 	
//		++a2; // a2 = a2 + 1
//		--a3; // a3 = a3 - 1
	
		// ++ 또는 -- 연산자는 피연산자 앞 또는 뒤에 사용이 가능하다 
		//연산식만 사용되는 단독 명령인 경우 연산자의 위치는 연산식에 미영향 
		
		a2++;
		a3--;
		
		System.out.println("연산 후 : a2 = " + a2 + " a3 = "+ a3);
		
		int a4 = 10 , a5 = 10;
		
		// 연산식이 다른 명령과 같이 사용될 경우 연산자의 위치는 
		// 연산식에 처리순서에 영향을준다.
		
		int a6 = ++a4; // 11   전처리 ++a4 명령 실행 후 int a6 = a4 명령 실행
		int a7 = a5++; // 10   후처리 int a7 = a5 명령 실행 후 a5++ 명령 실행 
		
		System.out.println("연산 전 : a4 = " + a4 + " a5 = "+ a5);
		System.out.println("연산 후 : a6 = " + a6 + " a7 = "+ a7);
		
		int b1 = 20 , b2 = 10;
		System.out.println(b1 + " * " + b2 + " = " + (b1 * b2)); // 200
		System.out.println(b1 + " / " + b2 + " = " + (b1 / b2)); // 2
		System.out.println(b1 + " % " + b2 + " = " + (b1 % b2)); // 0
		System.out.println(b1 + " + " + b2 + " = " + (b1 + b2)); // 30
		System.out.println(b1 + " - " + b2 + " = " + (b1 - b2)); // 10
		
		System.out.println("20 > 10 = " + (20 > 10)); // true
		System.out.println("20 < 10 = " + (20 < 10)); // false
		System.out.println("20 == 10 = " + (20 == 10)); // false
		System.out.println("20 != 10 = " + (20 != 10)); // true
		
		int c = 20;
		System.out.println("c = " + c); 
		System.out.println("c >= 10 && c <= 30" + (c >= 10 && c <= 30)); // true 범위연산식에 많이쓰임
		System.out.println("c <= 10 || c > 30" + (c <= 10 && c > 30)); // false
		
		int d1 = 10 , d2 = 20;
		System.out.println("큰 값 = " + (d1 > d2 ? d1  : d1 < d2 ? d2 : "같음" ));
		
		int d3 = 11;
		System.out.println(d3 % 2 == 0 ? "짝수" : "홀수");
		
		int e = 10;
		System.out.println("e = " + e);
		
		// 복합대입 연산자 
		e += 5; // e = e + 5  >> e = 15
		
		
	}
}
