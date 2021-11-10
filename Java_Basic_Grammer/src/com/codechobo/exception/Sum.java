package com.codechobo.exception;

import java.util.Scanner;

public class Sum {

	int first , second , total;
	Scanner scanner;
	
	public Sum() {
		scanner.nextInt();
	}
	
	public int add() {
		System.out.print("첫번째 정수 : ");
		first = scanner.nextInt();
		System.out.print("두번째 정수 : ");
		second = scanner.nextInt();
		total = first + second;
		return total;
	}
}
