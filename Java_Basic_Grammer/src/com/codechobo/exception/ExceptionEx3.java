package com.codechobo.exception;

import java.util.Scanner;

public class ExceptionEx3 {
	int sum;
	Scanner sc = new Scanner(System.in);
	
	public ExceptionEx3() {
		add(new Plus());
		showTotal();
	}

	public int add(Plus plus) {
		plus.add();
		sum = plus.total;
		return sum;
	}
	
	private void showTotal() {
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
	new ExceptionEx3();	
		
	}
}
