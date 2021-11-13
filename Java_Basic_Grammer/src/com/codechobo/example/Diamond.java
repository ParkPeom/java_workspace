package com.codechobo.example;

import java.util.Scanner;

public class Diamond {
	Scanner scan = new Scanner(System.in);
	public Diamond() {}
	public void start() {
		System.out.print("임의의 홀수 입력(1~49)->");
		int max = scan.nextInt();
		if(max%2==0) max++;
		char alpha = 'A';
		
		//삼각형
		for(int i=1; i<=max; i+=2) {// 1,3,5,7,9,.....max
			//공백처리
			for(int s=1; s<= (max-i)/2; s++) {//1,2, ,,,12
				System.out.print(" ");
			}
			//한줄 문자를 출력
			for(int j=1; j<=i; j++) {
				System.out.print(alpha++);
				if(alpha>'Z') alpha='A';
			}
			System.out.println();//줄바꿈
		}
		//역삼각형
		for(int i=max-2; i>=1; i-=2) {// 23, 21, 19, 17, .....1
			//공백처리
			for(int s=1; s<= (max-i)/2 ; s++) {
				System.out.print(" ");
			}
			//문자출력
			for(int j=1; j<=i; j++) {// 1,2,3,4,5...i
				System.out.print(alpha++);
				if(alpha>'Z')alpha='A';
			}
			//줄바꿈
			System.out.println();
		}
	}
	public static void main(String[] args) {
		new Diamond().start();
	}
}
