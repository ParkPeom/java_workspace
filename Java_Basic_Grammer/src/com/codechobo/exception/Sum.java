package com.codechobo.exception;

import java.util.Scanner;

public class Sum {

	int first , second , total;
	Scanner scanner;
	
	public Sum() {
		scanner.nextInt();
	}
	
	public int add() {
		System.out.print("ù��° ���� : ");
		first = scanner.nextInt();
		System.out.print("�ι�° ���� : ");
		second = scanner.nextInt();
		total = first + second;
		return total;
	}
}
