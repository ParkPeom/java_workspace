package com.codechobo.control;

public class ForApp2 {
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%d * %d = %d \t", j , i , j*i );
			}
		System.out.println("");	
		}
	}
}
