package com.codechobo.calendar;

public class Ex_5_6동전구하기 {
	
	public static void main(String[] args) {
		
		int[] coinUnit = {500,100,50,10};
		
		int money = 2680;
		System.out.println("month="+money);
		
		for(int i = 0; i < coinUnit.length; i++) {
			int count = 0;
			count = money / coinUnit[i];
			money = money % coinUnit[i];
			System.out.println(coinUnit[i]+"원 : " + count);
		}
	}
}
