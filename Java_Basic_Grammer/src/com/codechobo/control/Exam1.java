package com.codechobo.control;

import java.util.Scanner;

public class Exam1 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int answer = (int)(Math.random() * 100) + 1;
		System.out.println("������" + answer);
		int input;
		
		do {
			System.out.print("���� �Է��ϼ��� > ");
			input = sc.nextInt();		
			if(input < answer) {
				System.out.println("�� ū���� �Է��ϼ���");
			} else if(input > answer) {
				System.out.println("�� ���� ���� �Է��ϼ���");
			}	
		}while(!(answer == input));
		System.out.println("�����Դϴ�.");
	}
}
