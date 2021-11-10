package com.codechobo.control;

import java.util.Iterator;

public class ForApp {
	
	public static void main(String[] args) {
		
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		
		// "Java Programming" 를 화면에 5번 출력
		// 반복의 횟수를 알면 원하는 횟수만큼 알수있다.
		// 반복 횟수 부등호를 잘못주면 무한반복이 될수있다.
			
		for (int i = 0; i <= 5 ; i++) { // i변수는 지역변수라서 for문이끝나면 소멸 
											// 초기식이 되는것이다.
			// 초기식 조건식 증감식 
			System.out.println("Java Programming");
		}
		// 네트워크 서버 만들때는 클라이언트가 접속되는걸 기다리기 떄문에
		// 일부러 무한루프 
		
		System.out.println("==========================================");
		
		// 원하는 횟수만큼 반복 처리 한다. 
		for(int i = 5; i >= 1; i--) { // i 가 0 이 되면 나가게 한다. 
			System.out.println("Java Programming");
		}	
		System.out.println("==========================================");
		System.out.println("1  2  3  4  5");
		
		for(int i = 1; i <= 5; i++ ) { // i를 반복문내 명령으로 쓸수있다.
			System.out.print((6-i) +"\t"); // Tab >> "\t"
		}	
		System.out.println(); // Enter 출력
		System.out.println("=======================================");
		
		// "2  4  6  8  10" 를 화면에 출력
		for(int i = 2; i <= 10; i+=2) {
			System.out.print(i + "\t");
		}
		
		// 1 부터 100 범위의 정수들의 합계를 계산하여 출력하시오
		System.out.println("========================");
		
		int top = 0;
		for(int i = 1 ; i <= 100; i++) {
				top += i;
		}
		System.out.println("========================");
		System.out.println("1~100 범위의 합계는 : " +  top);
		
		// 두 변수에 저장된 정수값 범위의 정수들의 합계를 계산하여 출력하시오
		
		
		
		// 쓰레드 : 명령을 일시적으로 읽어드릴수있는 
		
		
		int begin = 80; // 멈추고싶은 명령위치에 라인넘버에서 더블클릭 -> breakPoint생김 
						// -> F11 -> 방화벽허용 -> Perspective 를 디버그 Perspective 로 바꿀건가?
						// 왼쪽에 스레드가 보인다.
					    // 왼쪽에 main 메서드 스레드가 59번에 멈처있다. (스레드종류)
						// 녹색은 스레드가 읽어드릴부분 
						// 오른쪽에 지금까지 변수가 보임
						// 밑에 콘솔 결과
						// F5 : 눈에 보이지않는것까지 내부적으로 표현되서 명령들을 실행
						// F6 : 눈에 보이는 명령들만 실행됨
		int end = 100;
		int sum = 0;
		
		// 입력값에 대한 유효값 검사를 한다.
		// 시작값이 종료값 보다 큰경우 두 변수값을 서로 바꾸어 저장
		if(begin > end) {
			// 알고리즘 : 프로그램 작성에서 발생되는 문제를 해결하기 위한 명령 
			// 치환 알고리즘 (두변수의 값을 바꾸기 위한 방법)	
			
			int tmp = 0; // 임시 변수 
			tmp = begin;
			begin = end;
			end = tmp;
		}
		
		if(begin > end) {
			System.out.println("[에러] 시작값이 종료값보다 작아야 합니다.");
			System.exit(0); // 프로그램을 강제 종료하는 메서드를 호출했다.
		}
		for(int i = begin; i <= end; i++) {
			sum += i;
		}
		System.out.println(begin + " ~ " + end + " 합계 는 :" + sum);
		
		
		// 초기식 또는 증감식은 , 기호를 사용하여 여러개 나열 작성이 가능하다 
	    // 별로 권장하지 않는다.
		for(int i = 1,j = 5 ; i <= 3; i++,j--) {
			System.out.println("");
		}
		System.out.println("===========================================");
		
		int i = 1; // for구문에 상관없이 계속 존재한다.(main메서드가 끝날때 까지 존재한다
		
		// for구문은 초기식 조건식 증감식 생략이 가능하다 
		for( ; i <= 4; i++) {
			System.out.println(i +"\t");
		} // 끝나면 i는 5가되서 빠져나감 
		
		// i = 5
		for(; i>=1; i--) {
			System.out.println(i +"\t");
		}
//		for(;;) { // 다 생략해도 for문에는 반드시 ;; 
//				  // 조건식이 생략된 경우 무조건 true이다. -> 무한루프 (종료되지 않는 반복문)
//			System.out.println("무한반복되는 명령");
//		}
		//	System.out.println("==================================="); 데드코드 : 무한루프 때문에 하단 실행이 안됨(에러발생)
	
	}
}
