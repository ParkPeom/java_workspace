package com.codechobo.exception;

import java.util.Scanner;

public class Plus {

	int first , second , total;
	Scanner sc = new Scanner(System.in);
	public Plus() {

	}
	public int add() {
		System.out.print("ù��° ���� �Է��ϼ��� >> ");
		first = sc.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ��� >> ");
		second = sc.nextInt();
		System.out.println("�μ��� ���� ");
		System.out.println(first + second);
		return total;
	}
}
