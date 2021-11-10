package com.codechono.array;

import java.util.Iterator;

public class LottoApp {
	
	// 1 ~ 45 범위의 중복되지 않는 정수 난수 6개를 제공받아 오름차순 정렬하여 출력하는 프로그램을 작성하시오
	// => 정렬(sort) 값을 순서대로 나열하는 기능	- 오름차순 정렬 , 내림차순 정렬
	public static void main(String[] args) {
		int[] lotto = new int[6];
		// 1 ~ 45 범위의 정수난수를 6개 제공받아 배열 요소에 저장
		for(int i = 0; i < lotto.length; i++) { // 새로운 난수값이 저장되는 배열 요소의 첨자 표현 
			// 요소에 저장된 새로운 난수값이 기존 요소들의 난수값과 모두 비교하여 다른 경우에 반복문이 종료 
			// => 새로운 난수값이 기존 요소들의 난수값과 같은 경우 반복처리 	
			while(true) { 
				// 요소에 새로운 난수값을 제공받아 저장 
				lotto[i] = (int)(Math.random() * 100) % 45+1; // 1 ~ 45 범위의 난수값을 제공받아 배열 요소에 저장						
				// 중복 상태정보를 저장하기 위한 변수
				// => false : 미중복 , true : 중복
				boolean result = false;		
				// 새로운 난수값을 기존 요소들의 난수 값과 비교할수있도록		
				for(int j = 0; j < i ; j++) { // 기존 배열 요소의 첨자를 표현
					// lotto[i] : 새로운 난수값이 저장된 배열 요소 표현
					// lotto[j] : 기존 난수값이 저장된 배열 요소 표현
					if(lotto[i] == lotto[j]) { // 새로운 난수값이 기존 난수값과 같다면 
						result = true;
						break;
					}
				}
				if(!result) break; // 반복문 종료 새로운 난수값이 기존 난수값과 같지 않은 경우 반복문 종료 
			}
		}
		// 배열의 요소값들을 서로 비교하여 오름차순 정렬되도록 요소 값을 바꾸어 저장
		// => 선택 정렬 알고리즘(Selection Sort Altorithm) 이용
		for(int i = 0; i < lotto.length-1; i++ ) { // 비교 오소의 첨자 표현 : 처음 ~ 끝-1
			for(int j = i+1; j<lotto.length; j++) { // 피비교 요소의 첨자 표현 : 비교 +1 ~ 끝
				// 오름차순 정렬되도록 요소값을 비교하여 바꾸어 저장 
				if(lotto[i] > lotto[j]) { // 비교하는애 > 비교당하는애
					// 요소값 치환
					int tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				}
			}
		}
		// 배열의 모든 요소값을 출력한다.
		System.out.print("행운의 숫자 >> ");
		for(int num : lotto) {
			System.out.println(num + " ");
		}
		System.out.println();
	}
}
