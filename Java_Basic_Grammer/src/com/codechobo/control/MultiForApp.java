package com.codechobo.control;
/*
	육지에서 다리를 걸쳐 다른 육지로 가는 방법 

 */
public class MultiForApp {
	
	public static void main(String[] args) {
		
		int cnt = 0; // 이동방법의 갯수를 저장하기 위한 변수
		
		for(int i = 1 ; i <= 3; i++) { // A나라  >> 섬 : 반복 
			for(int j = 1; j <= 4; j++) { // 섬 >> B나라 : 반복 
				cnt++;
			}
		}
		System.out.println(String.format("반복의 갯수는 %d " , cnt));
		System.out.println("=================================================================");
		
		for(int i=1; i<=9; i++) { // 행 표현 
			for(int j=2; j<=9; j++) {  // 열 표현 2단부터
				System.out.print(j + " * " + i + " = " + j * i + "\t");
			}
			System.out.println();
		}

		System.out.println("==================");
		// 1 사각형
		for(int i = 1; i <= 10; i++) { // 행(Row) 을 반복 처리하기 위한 명령 
			for(int j = 1; j <= 10; j++) { // 열(Column) 을 반복 처리하기 위한 명령 
				System.out.print("*");
			}
			System.out.println("");
		}
		// 2 삼각형 
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		System.out.println("=============");

		// 3 역삼각형
		
		for(int i = 1; i <= 10; i++) {
			for(int j = 10; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		// 4 삼각형
		for(int i = 0; i <= 10; i++) {
			
			for(int j = 10; j >= i; j--) {
				 // 공백
				System.out.print(" ");
			}
			for(int k= 1; k <= i; k++)  {
				// 별
				System.out.print("*");				
			}
			System.out.println("");
		}
		// 5 삼각형
		for(int i = 0; i <= 10; i++) {
			
			for(int j = 10; j >= i; j--) {
				 // 공백
				System.out.print(" ");
			}
			for(int k= 1; k <= i * 2 + 1; k++)  {
				// 별
				System.out.print("*");				
			}
			System.out.println("");
		}	
		//  6 역 삼각형 
		for(int i = 0; i <= 10; i++) { // 줄바꿈 
			for(int j = 1; j <= i; j++) {
				 // 공백
				System.out.print(" ");
			}
			for(int k= 10; k >= i; k--)  {
				// 별
				System.out.print("*");				
			}
			System.out.println("");
		}    
		// 7  
		for(int i = 0 ; i <= 10; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for(int k = 10; k >= 0; k--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		// 8 공백있는 삼각형
		
		for(int i = 0; i <= 10; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for(int k = 10; k > i * 2 + 1; k--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		// 9 마름모 
		for(int i = 0; i <= 10; i++) {
			
			for(int j = 10; j >= i; j--) {
				 // 공백
				System.out.print(" ");
			}
			for(int k= 1; k <= i * 2 + 1; k++)  {
				// 별
				System.out.print("*");				
			}
			System.out.println("");
		}
		// 10 대각선
		for(int i = 0; i <= 10; i++) {
			for(int j = 0; j <= 10; j++) {
				if(i == j) {
					System.out.print("*");
				} else if(i != j){
				System.out.print(" ");
			}
			}
			System.out.println();
		}
		
		// 11 역 대각선
		//0,0 0,1 0,2 0,3 
		//1,0 1,1 1,2 1,3
		//2,0 2,1 2,2 2,3
		//3,0 3,1 3,2 3,3
		//4,0 4,1 4,2 4,3
		
		
		for(int i = 0; i <= 20; i++ ) {
			for(int j = 0; j <= 20; j++) {
				if(i + j == 10) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
			
		
		
		// X 자 그리기	
		
	}
}


