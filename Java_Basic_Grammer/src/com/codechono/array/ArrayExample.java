package com.codechono.array;

public class ArrayExample {
	public static void main(String[] args) {
		int[] age = {17,22,36,57,60,43,23,14,29,44,52,69,51,39,33,11};
		int[] age2 = new int[6];
			
		int sum = 0;
		int average = 0;
		
		for(int i = 0; i < age.length; i++ ) {
			sum += age[i];
			average = sum / age.length;
		}
		System.out.println("평균나이 : " + average);
		System.out.println("============================");
		// 배열에 저장된 사람들의 나이를 연령별로 구분하여 인원수를 계산하여 출력하세요
		// 10대 - 3명
		// 20대 - 4명
		// ....
		// 60대 - 2명	
		int[] count = new int[7];
		int agede;
		for(int i = 0; i < age.length; i++) {
				agede = age[i] / 10;
				count[agede]++;
		}
			for(int i = 0; i < 7; i++) {
				System.out.println(i * 10 +"대 - " + count[i] + "명");
			}			
	}
}