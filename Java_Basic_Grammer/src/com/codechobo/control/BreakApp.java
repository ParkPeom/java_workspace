package com.codechobo.control;

public class BreakApp {
	
	public static void main(String[] args) {
		// 반복문의 조건식이 false 이면 반복문 종료 
		
		for(int i = 1; i <= 5; i++) {
			if(i==3) break; // if문 구문의 조건식이 참(true)인 경우 break 명령으로 반복문 종료
			System.out.print(i + "\t");
		}
		
		System.out.println();
		System.out.println("===============================");
		 
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {				
				// break 명령이 작성된 반복문 종료 for(int j=1; j<=5; j++) 반복문 종료 
				if(j == 3) { 
					break; // break는 가까운 반복문을 빠져나간다. 
				}
				System.out.println(" i = " + i + "  j = " + j);
			}
		}
		
		System.out.println("===============================");
		
		// 반복문안에 반복문을 구별할수 있는 (식별자) 있어야 한다. 
		// 형식) 라벨명 : 반복문 
		
		// 다중 for문에서 반복문의 라벨명을 통해 반복문을 전체다 빠져나가게 해준다 
		
		loop:
		for (int i = 0; i <= 5; i++) { // j 가 3일대 모든 반복문을 빠져 나간다. 
			for(int j = 1; j <= 5; j++) { 
				
				if(j==3) break loop;  // 반복문에 지정된 라벨명을 이용하여 반복문 종료
									  //  형식 ) break 라벨명;
				System.out.println("i = " + i + " j = " + j );
			}
		}
		System.out.println("=========================");
		
	}
}
