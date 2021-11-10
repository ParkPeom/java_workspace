package com.codechobo.exception;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 	콘솔에서 두개의 정수를 입력 받아 두수의 합을 출력 하라.

  	실행 
  	첫번째 정수 = ____
  	두번째 정수 = ____
  	____ + ____ = _____
 */
public class ExceptionEx {
	Scanner sc;
	int num1 , num2 , sum , flag;
	public ExceptionEx() {
		sc = new Scanner(System.in);
		sum = addsum();
		print(sum);
	}
	// 2. 입력 
	public int addsum() {
		do {
			flag = 1;
			try {
				System.out.print("첫번쨰 정수 = ");
				num1 = sc.nextInt();		
				System.out.print("두번쨰 정수 = ");
				num2 = sc.nextInt();	
				return num1 + num2; // 3. 처리
			}catch(InputMismatchException e) { // 4. 예외처리
				flag = 0;
				System.out.println("숫자만 입력해주세요.");
				break;
			}
		} while(flag == 0);
		return 0;
	}
	// 5. 출력
	public void print(int sum) {
		System.out.println(num1 + "+" + num2 + "=" + sum);
	}
	public static void main(String[] args) {
		new ExceptionEx(); // 1. 호출
	}
}
