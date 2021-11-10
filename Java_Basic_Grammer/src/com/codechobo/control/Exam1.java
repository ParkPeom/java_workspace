package com.codechobo.control;

import java.util.Scanner;

public class Exam1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int answer = (int)(Math.random() * 100) + 1;
		System.out.println("정답은" + answer);
		int input;
		
		do {
			System.out.print("수를 입력하세요 > ");
			input = sc.nextInt();		
			if(input < answer) {
				System.out.println("더 큰수를 입력하세요");
			} else if(input > answer) {
				System.out.println("더 작은 수를 입력하세요");
			}	
		}while(!(answer == input));
		System.out.println("정답입니다.");
	}
}
