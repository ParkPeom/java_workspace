package com.codechono.array;

public class ArrayApp {
	
	public static void main(String[] args) {
		
		// 1차월 배열을 생성하여 참조변수 저장 - 형식 ) 자료형[] 참조변수명 = new 자료형[갯수]
		// => new 자료형[갯수] : 자료형의 값을 갯수만큼 저장 가능한 배열 생성
		// => 자료형[] 참조변수명 : 1차원 배열의 메모리 주소 (HashCode)를 저장하기 위한 참조 변수 
		// 1차원 배열은 요소(Element)를 이용하여 다수의 값 저장
		// => 배열의 요소는 첨자(index : 0 부터 1씩 자동 증가되는 정수값)를 이용하여 구분 
		// => 배열 생성시 배열의 요소는 자동적으로 기본값이 자동 저장된다. (숫자형 : 0 , 논리형 : flase , 참조형 : null )
		
		int[] num = new int[3]; // 0으로 자동 초기화  첨자는 0 , 1 , 2
		
		System.out.println(num); // [I@123a439b 참조변수에 저장된 메모리 주소(해시코드 - 16진수) 출력
	
		System.out.println("==================");
		// 배열 정보가 저장된 참조변수와 첨자를 이용하여 배열의 요소 표현
		// 형식) 참조변수명[첨자] 

		System.out.println("num[0] = " + num[0]);
		System.out.println("num[1] = " + num[1]);
		System.out.println("num[2] = " + num[2]);
	
		// 배열의 요소를 구분하는 첨자를 잘못 사용한 경우 예외가 발생
		// => 예외가 발생한 경우 강제로 프로그램 종료(스레드 소멸)
		//		System.out.println("num[3] = " + num[3]);  java.lang.ArrayIndexOutOfBoundsException: 배열의 범위 벗어남 
		
	// 참조변수.length : 참조변수에 저장된 배열의 요소의 갯수 표현 
		System.out.println("배열 요소의 갯수 = " + num.length); // 3
		System.out.println("=========");
		
		int index = 0;
		// 배열의 요소에 첨자는 변수 연산식으로 표현이 가능 
		num[index] = 10; // 요소값 변경 num[0]
		num[index+1] = 20; // num[1]
		num[index+2] = 30; // num[2]
		
		// for 구문을 이용하여 배열의 요소에 대한 일괄 처리 
		
		// => 초기식 조건식 증감식을 이용하여 첨자를 표현할수있다.
		// - 입력 , 연산 , 출력   
		for(int i = 0; i < num.length; i++) { // for문으로일괄처리 함
			System.out.println("num[" + i +"] = " + num[i]);
		}
		System.out.println("===================");
		// 배열 생성시 배열 요소에 기본값 대신 원하는 초기값 저장 가능 
		// 형식) 자료형[] 참조변수 = new 자료형[]{초기값,초기값,...}
		// => 나열된 초기값에 갯수 만큼의 요소를 가진 요소를 포함하는 배열 생성
		// => new 자료형[] 표현식은 생략이 가능
		int[] su = new int[] {10,20,30};
		int[] su2 = {10,20,30};
		
		// for 구문을 이용하여 배열의 요소에 대한 일괄처리
		// => 내부의 반복지시자(Iterator)를 이용하여 요소값을 차례대로 제공받아 변수에 저장하여 일괄처리할수있다.
		
		// 형식) for(자료형 변수열 : 참조변수) >> 변형된 for 구문 
		// => 참조변수에 저장된 배열의 요소값을 차례대로 제공받아 변수에 저장하여 반복처리한다.  -- 연산과 출력  입력안됨 요소에 접근하는것이지 메모리에 접하는것이 아니ㄷㅏ iterator
		// => 배열의 모든 요소값을 제공한 경우 반복문 종료 
		
		
		// iterator 요소 요소의 값을 차례대로 하나하나씩 불러옴 
		for(int temp : su) { // 배열의 요소값들이 temp 에 저장됨 
			System.out.println(temp + "\t");
		}
		System.out.println();
		System.out.println("====================");
		
		int[] array = {54,42,52,64,42,12,42,53,64,2,12,52,54,21};
		// 배열의 모든 요소값에 대한 합계 를 계산하여 출력하라
		int sum = 0;
		for (int number : array	) {
			sum += number;
		}
		System.out.println("요소 합계는 = " + sum);
		// "배열의 요소값이 30 ~ 60 범위인 값들의 갯수를 계산하여 출력하시오

		int count = 0;
		for(int number : array) {
			if(number >= 30 && number <= 60) {
				count++;
			}
		}
		System.out.println(" 30 ~ 60 범위의 요소 갯수 = " + count);
	}
}
 