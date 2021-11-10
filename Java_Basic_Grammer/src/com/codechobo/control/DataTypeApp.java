package com.codechobo.control;

public class DataTypeApp {
	
	public static void main(String[] args) {
		
		System.out.println("<<정수형(Integer Type)>>");
	
		// println() 메서드는 정수값을 10진수로 변환하여 출력
		
		System.out.println("정수값(10진수) = " + 100);
		System.out.println("정수값(8진수) = " + 0100);
		System.out.println("정수값(16진수) = " + 0x100);
			
		// int a5 = 100L; // 데이터 손실 가능성에 의한 에러 발생
		
		long a5 = 100;
		System.out.println("a5 = " + a5);
		System.out.println("==============================");
		
		System.out.println("<<실수형(Double Type)>>");
		System.out.println("실수값(4Byte) = "+ 12.3F);
		System.out.println("실수값(8Byte) = "+ 12.3);
	
		//정수값을 표현하기 위한 자료형 : byte , short , int ,long
		byte b1 = 127; // 메모리 절약
		short a2 = 32767; // c언어 연동
		int a3 = 2147483647; // 정수값 4바이트 
		long a4 = 2147483648L; // 정수값 8바이트 
		
		a3++;
		System.out.println("a3 : " +  a3); // -2147483648
		

		// println() 메서드는 아주 작은 실수값 또는 아주 커다란 실수값을 지수형태로 변환하여 출력한다.
		System.out.println("실수값(8Byte = " + 0.000000000123);
		
		// 지수형태로 표현 
		System.out.println("실수값 " + 1.23E10); // 123000000 을 지수형태로 표현

		// 실수값을 표현하기 위한 자료형 : float , double 
		float f1 = 1.23456789F; // float >> 4byte 가수부 표현범위 : 7자리
		double b2 = 1.23456789; // double >> 8byte - 가수부 : 15자리
	
		System.out.println("f1 = " + f1); // 짤려서 7자리까지만 표현 
		System.out.println("b2 = " + b2);
		
		long b3 = 100000000L * 30;
		System.out.println("b3 = " + b3);
		
		System.out.println("============");
		System.out.println("<<문자형(Character Type>>");
		
		// 문자값은 ' ' 안에 표현하여 내부적으로 약속된 2Byte 정수값으로 표현
		System.out.println("문자값(2Byte) = " + 'A');
		
		// jAVA에서 표현 불가능한 문자는 Escape Character(회피문자)
		// => \n : Enter , \t:tab , \" : 문자" , \\" : 문자\"
		System.out.println("문자값(2Byte) = " + '\'');
		System.out.println("문자값(2Byte) = " + '\\');
		
		// 문자값을 표현하기 위한 자료형 : char
		char c1 = 'A'; // 'A' = 65 , 'a' = 97
					   // '0' = 48 , ' ' = 32
					  // '\n' = 13 , '가' = 44032 - 완성형 
			// 문자 변수에는 문자값에 대한 약속된 정수값으로 저장
		char c2 = 65;
		System.out.println(c2); // A
		char c3 = 'a'- 32; // 'A
		System.out.println(c3);
		
		System.out.println("c1 = " + c1 );
		System.out.println("c2 = " + c2 );
		System.out.println("c3 = " + c3 );
		
		char c4 = 45000;
		System.out.println("c4 = " + c4);
		
		System.out.println("============================");
		System.out.println("<<논리형(Boolean Type)>>");
		System.out.println("논리값(1Byte) = " + false);
		System.out.println("논리값(1Byte) = " + true);
		// 관계 연산자(비교연산자)를 이용한 연산식의 결과값으로 논리값 제공
		System.out.println("논리값(1Byte) = " + (20 > 10)); // true
		System.out.println("논리값(1Byte) = " + (20 < 10)); // false
		
		// 논리값을 표현하기 위한 자료형 : boolean 
		boolean d1 = false;
		boolean d2 = 20 > 10;
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		
		System.out.println("<<문자열(String Type)>>");
		// 문자열은 " "안에 표현하여 참조형(Reference Type - 클래스)으로 표현
		System.out.println("문자열 = " + "홍길동");
		// \" 회피문자로 표현 
		System.out.println("유관순 열사가 \"대한민국 만세 \" 라고 외쳤습니다.");
		String str = new String("hahaha");
		
		// 문자열을 표현하기 위한 자료형 : String 클래스)
		String name = "임꺽정";
		System.out.println("이름 = " + name );
		
	}
}
