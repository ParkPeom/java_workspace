package com.codechono.innerclass;

public class Sample {
		
	public Sample() {
		
	}
	public void sum() {
		int s = 0;
		for(int i=1; i<=100; i++) {
			s += i;
		}
		System.out.println("1~100������ ���� " + s); 
	}
	
	public void oddSum(int max) {
		int tot = 0;
		for(int i = 1; i <= max; i+=2) {
			tot += i;
		}
		System.out.println("1~"+max+"���� Ȧ���� ����" + tot);
	}
}
