package com.codechono.array;

public class LottoApp2 {
	
	public static void main(String[] args) {
		int[] lottoball = new int[45];
		int[] chance = new int[6];
		int temp = 0;
		
		int max = lottoball[0];
		int min = lottoball[0];
		
		
		temp = (int)(Math.random() * 45) +1;
		
		for(int i = 0; i < lottoball.length; i++) {			
			lottoball[i] = i + 1;
		}
			for(int i = 0; i < lottoball.length; i++) {
				int random = (int)(Math.random() * 44) +1;
				temp = lottoball[i];
				lottoball[i] = lottoball[random];
				lottoball[random]= temp;
			}	
		for(int i = 0; i < 6; i++) {
			
			if(lottoball[0] < max ) {
			}
			System.out.print(lottoball[i] + " ");
			
		}
		
		
		
		
	}
}
