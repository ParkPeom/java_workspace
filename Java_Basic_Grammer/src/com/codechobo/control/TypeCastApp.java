package com.codechobo.control;

// 형변환(Type Cast) : 값을 자료형을 일시적으로 변환하여 사용하는 방법
// => 자동형 변환(JVM) , 강제 형변환(프로그래머)
public class TypeCastApp {
	public static void main(String[] args) {
		
		// 자동 형변환 : 자료형이 다른 값을 연산하기 위한 JVM에 의해 자료형을 변환
		
		System.out.println("결과 = " + (3 + 1.5)); // 3.0 + 1.5 >> 큰 데이터의 타입으로 
										
		double su = 10; // 10 >> 10.0
		System.out.println("su = " + su);
		
		System.out.println("결과 = " + (95 / 10)); // 9 정수값에 대한 연산 결과 : 정수값 >> 9
		System.out.println("결과 = " + (95 % 10)); // 5
		
		System.out.println("결과 = " + (95.0 / 10)); // 자동형변환 9.5  실수 / 정수 >> 실수 
		System.out.println("결과 = " + (95 / 10.0)); // 9.5  실수 / 정수 >> 실수 
		
		int kor = 95 , eng = 90; // 점수 입력 
		int total = kor + eng; // 총점 계산 
		// double avg = total / 2; // 평균 계산 92.0 - 연산 결과 : 정수값 >> 변수값 92.0
		double avg = total / 2.0; // 평균 계산 92.5 - 연산 결과 : 실수값 >> 변수값 92.5
		
		System.out.println(String.format("점수 합계 %d" , total));
		System.out.println("평균은 " + avg); 
		
		byte su1 = 10 , su2 = 20;
		byte su3 = (byte)(su1 + su2); // int보다 작은 타입끼리 연산하면 int형으로 자동형변환
									   // byte 에 담으려면 강제형변환을 해줘야한다.
		System.out.println(su3);
		System.out.println("===============================================");
		
		// 강제 형변환 : 프로그래머가 Cast 연산자를 이용하여 원하는 자료형의 값으로 일시적으로 
		// 변환하여 사용하는 방법이다. - (자료형)값
		int num = (int)12.3; // (int)12.3 >> 12 정수값  강제형변환이 된다. 
		System.out.println("num = " + num); // 12 
		
		int num1 = 95 , num2 = 10;
		double num3 = num1 / (double)num2; // 변수값에 (double) 해서 >> 9.5 
		System.out.println(num3);
		
		// 큰 정수값은 _를 이용하여 표현 가능 
		int num4 = 100_000_000 , num5 = 30; // 1억
		long num6 = (long)num4 * num5; // 정수값을 연산한 결과값은 정수다 그러므로
										// 연산 결과값이 4Byte를 초과하면 쓰레드기 값이 발생한다.
										// 비정상적인 값이 변수에 저장
										// 피연산자를 long으로 캐스팅하고 계산결과를 long으로 
		System.out.println(num6);
		
		double number = 1.23656789;
		System.out.println("number" + number);
		
		// 소수점 두자리 까지 위치까지만 출력하도록 프로그램 작성
		System.out.printf("%.2f", number);
		System.out.println("number(내림) = "+ (int)(number * 100) / 100.0); // 1.23
		System.out.println("number(반올림) = "+ (int)(number * 100 + 0.5) / 100.0); // 1.23
		
		// 올림 세자리에 0이아니면 무조건올림 
		System.out.println("number(반올림) = "+ (int)(number * 100 + 0.9) / 100.0);  // 무조건 올림
		
		// 소수점 한자리까지 
	
		//////////////////////////////////////////
		// 반올림
	
		double number2 = 1.65432; // 소수점세째자리
		System.out.println((int)(number2 * 1000 + 0.5) / 1000.0);
		
		double number3 = 25.6522; // 둘째자리까지 반올림하기
		System.out.println((int)(number3 * 100 + 0.5) / 100.0);
		
		int num66 = 456;
		System.out.println(num66 / 100 * 100 );
		
	}
}
