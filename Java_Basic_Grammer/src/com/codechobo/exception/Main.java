package com.codechobo.exception;

public class Main {

	int total;
	public Main() {
	
	}
	public void sum(Sum sum) {
		 total = sum.add();
		 showInfo(total);
	}
	
	public void showInfo(int total) {
		System.out.println("°á°ú´Â : " + total);
	}
	
	public static void main(String[] args) {
		new Main().sum(new Sum());
	}
}
