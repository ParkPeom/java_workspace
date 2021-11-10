package com.codechobo.control;

import java.util.Scanner;

public class ForExample {

	public static void main(String[] args) {

		//본인 이름을 화면에 7번 출력하세요.
				//ex) 홍길동 홍길동 홍길동 홍길동 홍길동 홍길동 홍길동
				
				for(int i = 1; i <= 7; i++) {
					System.out.print("박범" + " \t ");
				}
				
				System.out.println();
				// 1~10 범위의 정수 중 홀수를 화면에 출력하세요.
				//ex) 1     3     5     7     9
		
				for(int i = 1; i <= 9; i=i+2) {
					System.out.print(i+ "\t");
				}
				System.out.println();
	
				//1~100 범위의 정수에서 3의 배수들의 합계와 5의 배수들의 합계를 계산하여
				//3의 배수의 합계에서 5의 배수의 합계를 뺀 결과값을 출력하세요.
				//ex) 결과 = 633		
		
				
				int result2 = 0;
				for(int i = 1;  i <= 100; i++) {
					if(i % 3 == 0) result2 += i; // 선택문(반복문)의 명령이 하나인 경우 { } 생략 가능 
					 
					if(i % 5 ==0) result2 -= i;	
				}
				System.out.println(result2);
				
				//구구단 중 7단을 화면에 출력하세요.
				//ex) 7 * 1 = 7
				//    7 * 2 = 14
				//    ...
				//    7 * 8 = 56
				//    7 * 9 = 63
				for(int i = 2; i <= 9; i++) {
					for(int j = 1; j<= 9; j++) {
						
						if(i == 7) {
							System.out.printf("%d * %d = %d%n",i,j,i*j);
						}
					}
				}

				//5!의 결과값을 출력하세요.(5! = 5 * 4 * 3 * 2 * 1)
				//ex) 5! = 120
				System.out.print("시작 값 입력 > ");
				Scanner scanner = new Scanner(System.in);
				int start = scanner.nextInt();
				int result = 1;
				for(int i = start ; i >= 1; i--) {
					result *= i;
				}
				System.out.print(String.format("%d ! = %d", start , result));
				
				//두 변수에 저장된 정수값 사이의 정수들을 화면에 출력하세요.
				//단, 한 줄에 정수값이 7개씩 출력되도록 프로그램을 작성하세요.
				//ex) 36    37    38     39     40     41     42
				//    43    44    45     46     47     48     49
				//    50    51    52     53     54     55     56
				//    57

				// 달력만들떄도 요일값으로 카운팅 함
				
				System.out.println();
				int begin = 36;
				int end = 56;
				int count = 0; // 카운트마다 줄바꿈 
				
				for(int i = 36; i <= 57; i++) {
					System.out.print(i + "\t");
					if(i % 7 == 0) {
						System.out.println();
					}
				}
			}
		}
