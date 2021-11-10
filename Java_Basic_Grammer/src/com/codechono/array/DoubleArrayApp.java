package com.codechono.array;

import java.util.ArrayList;
import java.util.List;

// 배열 : 1차원 배열 또는 다차원 배열(2차원 배열 , 3차원배열 ...)
// => 1차원 배열 : 요소(Element) 의 모임
// => 다차원 배열 : 배열의 모임 >> 2차원 배열 - 1차원 배열의 모임 

public class DoubleArrayApp {
	
	public static void main(String[] args) {
		
		// 형식 ) 자료형 [][] 참조변수 = new 자료형[][];
		// 1차원 배열이 2개 , 열 개수 3개 
		// => 행 갯수 : 1차원 배열의 갯수 표현
		// => 열 갯수 : 1차원 배열의 요소 갯수 표현 
		int[][] num = new int[2][3];

		List arr = new ArrayList();
		
		System.out.println("num = " + num[0][0]);
		System.out.println("num = " + num[0][1]);
		System.out.println("num = " + num[0][2]);
		System.out.println("==================================");
		System.out.println("num = " + num[1][0]);
		System.out.println("num = " + num[1][1]);
		System.out.println("num = " + num[1][2]);
		System.out.println("==================================");

		
		for (int i = 0; i < num.length; i++) { // 행 1차원 배열의 갯수만큼 반복처리 
			for (int j = 0; j < num[i].length; j++) { // 열 1차원 배열을 구성하는 요소의 갯수만큼 반복
				System.out.print(num[i][j] + "\t");	 
			}
		System.out.println();	
		}
		
		System.out.println("============================");
		int[][] su = new int[][] {{10,20,30},{40,50,60},{70,80,90}};
		
		for(int[] arr3 : su) { // 1차원 배열을 만드는 배열 저장 
			for(int arr2 : arr3) { // 2차원 배열을 만드는 배열 저장 
				System.out.print(arr2 + " \t");
			}
			System.out.println();
		}
		
		int[][] number = new int[3][]; // 1차원 배열이 없는 2차원 배열 생성 
									   // => 1차원 배열의 해쉬코드를 저장할 수 있는 참조변수만 생성
		System.out.println("number = " + number[0]);
		System.out.println(number[1]);
		System.out.println(number[2]);
		
		// null 이면 참조할수 없는 null 값
		
		// 2차원 배열의 참조요소에 1차원 배열을 생성하여 2차원 배열에 참조변수에 저장시켰다 
		// => 1차원 배열을 구성하는 요소의 갯수를 다르게 하여 생성했다 
		number[0] = new int[3];
		number[1] = new int[2];
		number[2] = new int[4];
		
		number[0][0] = 10;
		number[0][1] = 20;
		number[0][2] = 30;

		number[1][0] = 40;
		number[1][1] = 50;
		
		number[2][0] = 60;
		number[2][1] = 70;
		number[2][2] = 80;
		number[2][3] = 90;
		
		int[][] array = {{2,3},{5,6,7},{1,2,5},{6,4}};
		
		for(int[] arr3 : number) { // 1차원 배열을 만드는 배열 저장 
			for(int arr2 : arr3) { // 2차원 배열을 만드는 배열 저장 
				System.out.print(arr2 + " \t");
			}
			System.out.println();
		}
		
		
		
	}
}
