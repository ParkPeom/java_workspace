package com.codechobo.control;

/*
 	Continue 문은 명령문을 건너띄울때 쓰인다. 

 */

public class ContinueApp {
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= 5; i++ ) {
			// if구문의 조건식이 참인 경우 반복문을 처음부터 다시 실행 
			// => continue 명령 하단에 작성된 명령 미실행 

			if(i == 3) { // 명령 미실행 
				continue;
			}
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println("===========");
		
		for(int i = 1; i <= 5; i++ ) {
			for(int j = 1; j<= 5; j++ ) {
				
				// continue 명령이 작성된 반복문의 명령을 처음부터 다시 실행 
				if(j == 3) {
					continue;
				}
				System.out.println("i =" + i + " j = " + j);
			}
		}	
		System.out.println("============");
		
		loop:
		for(int i = 1; i <= 5; i++ ) {
			for(int j = 1; j<= 5; j++ ) {
				
				// continue 명령이 작성된 반복문의 명령을 처음부터 다시 실행 
				if(j == 3) {
					continue loop; // break 와 유사하다. 같진않다 거의 같은 효과 
									// 라벨명을 통해 i로 이동
				}
				System.out.println("i =" + i + " j = " + j);
			}
		}
	}
}
