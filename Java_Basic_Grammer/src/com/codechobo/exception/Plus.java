package com.codechobo.exception;

import java.util.Scanner;

public class Plus {

	int first , second , total;
	Scanner sc = new Scanner(System.in);
	public Plus() {

	}
	public int add() {
		System.out.print("첫번째 수를 입력하세요 >> ");
		first = sc.nextInt();
		System.out.print("두번째 수를 입력하세요 >> ");
		second = sc.nextInt();
		System.out.println("두수의 합은 ");
		System.out.println(first + second);
		return total;
	}
}
