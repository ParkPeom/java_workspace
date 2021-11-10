package com.codechobo.control;

import java.util.Calendar;

/*
   변수 선언 - 정수값(4Byte)를 저장하기 위한 su 변수
   정수값 100을 대입연산자를 이용하여 su 변수에 저장 
   같은 변수 선언 불가능 - 에러 발생
   기존값 대신 새로운 값이 변수에 저장
   "" (문자열)+대상 >> 대상과 문자열 결합 
   변수 선언 및 초기값( 저장
*/
public class VariableApp {
	
	public static void main(String[] args) {
	
	int intMount; 
	intMount = 100; 

	System.out.print("변경 전 변수값 = " + intMount);
	// int intMount; 
		
	intMount = 20; // 선언 및 초기화
	
	System.out.print("변경 후 변수값 = " + intMount);
		
	int num = 100;
	System.out.println("num = " + num);
		
		
	System.out.println("올해는" + 2 + 0 + 2 + 1 + "년 입니다."); // 2021년
	System.out.println(2 + 0 + 2 + 1 + "년 입니다."); // 5년 (잘못된 결과) - 실행 오류
	
	// 프로그램 만들기 전에 꼭 해야할 것은 테스트 
	// "" : 문자가 하나도 없는 문자열 - NullString 존재하지않은 것 
	
	System.out.println("올해는" + 2 + 0 + 2 + 1 + " 소띠해 입니다."); // 2021년
	
	// 동일한 자료형의 변수는 , 기호를 사용하여 나열 선언 가능 
	int num1 = 100 , num2 = 200;
	
	// 연산 괄호를 해서 우선순위를 해준다. ( 프로그램 실행 속도가 빨라짐 ) 

	System.out.println("연산 결과 = " +  num1 + num2); // 100200
	System.out.println("연산 결과 = " +  (num1 + num2)); // 300
	
	// + 보다 *먼저인경우면?
	
	System.out.println("연산 결과 = " + num1 * num2); // 20000
	System.out.println("연산 결과 = " + (num1 * num2)); // 20000
	
	int kor = 88 , eng = 90; // 변수를 쓰는 이유 값대신쓰기위한 재활용성 
	
	int tot = kor + eng; // 연산 결과를 변수에 저장 
	System.out.println("점수 합계" + tot);
	
	// 변수에 값이 저장되어 있지 않은 상태로 변수를 사용할 경우 에러 발생
	
	
	int number = 3; // 지역변수는 사용하기전에 반드시 초기화해야한다.
	
	System.out.println("number = " + number);
	
	
	System.out.println("정수값(4Byte) = " + 2147483647);
	System.out.println("정수값(4Byte) = " + 21474836472L);
	
	}
}
