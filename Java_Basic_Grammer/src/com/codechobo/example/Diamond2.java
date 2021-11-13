package com.codechobo.example;
import java.util.Scanner;

public class Diamond2 {
	Scanner scan = new Scanner(System.in);
	public Diamond2() {}
	public void start() {
		System.out.print("임의의 홀수 입력(1~49)->");
		int max = scan.nextInt();
		if(max%2==0) max++;
		char alpha = 'A';
		int step = 2;
		
		//삼각형
		for(int i=1; i>=1; i+=step) {// 1,3,5,7,9,.....max			
			for(int s=1; s<= (max-i)/2; s++) {//1,2, ,,,12//공백처리
				System.out.print(" ");
			}			
			for(int j=1; j<=i; j++) {//한줄 문자를 출력
				System.out.print(alpha++);
				if(alpha>'Z') alpha='A';
			}
			System.out.println();//줄바꿈
			//증가또는감소확인하여 값을 바꾼다.
			if(i>=max) step=-2;
		}			
	}
	public static void main(String[] args) {
		new Diamond2().start();
	}
}
