package com.codechobo.control;

import java.util.Scanner;

public class OperatorApp {
	
	public static void main(String[] args) {
		
		System.out.println("10 + 20 * 3 = " + (10 + 20 * 3)); // 70
		System.out.println("10 + 20 * 3 = " + ((10 + 20) * 3)); // 90
			
		// [] �迭������ 
		// . ��ü������ 
		System.out.println("=================================");
		
		// ���׿����� + , - 
		int a1 = 10;
		System.out.println("a1 = " + a1);  //10
		System.out.println("a1 = " + (-a1));  // -10
		
		// ! ������ true -> false , false -> true
		System.out.println("20 > 10 = "+ (20 > 10));
		System.out.println("20 > 10 = "+ !(20 > 10));
		
		System.out.println("=================================");
		int a2 = 10, a3 = 10;
		System.out.println("���� �� : a2 = " + a2 + " a3 = "+ a3);
		
// �����ϰ� ������ �ǿ����� ������ �ٲ����� 	
//		++a2; // a2 = a2 + 1
//		--a3; // a3 = a3 - 1
	
		// ++ �Ǵ� -- �����ڴ� �ǿ����� �� �Ǵ� �ڿ� ����� �����ϴ� 
		//����ĸ� ���Ǵ� �ܵ� ����� ��� �������� ��ġ�� ����Ŀ� �̿��� 
		
		a2++;
		a3--;
		
		System.out.println("���� �� : a2 = " + a2 + " a3 = "+ a3);
		
		int a4 = 10 , a5 = 10;
		
		// ������� �ٸ� ��ɰ� ���� ���� ��� �������� ��ġ�� 
		// ����Ŀ� ó�������� �������ش�.
		
		int a6 = ++a4; // 11   ��ó�� ++a4 ��� ���� �� int a6 = a4 ��� ����
		int a7 = a5++; // 10   ��ó�� int a7 = a5 ��� ���� �� a5++ ��� ���� 
		
		System.out.println("���� �� : a4 = " + a4 + " a5 = "+ a5);
		System.out.println("���� �� : a6 = " + a6 + " a7 = "+ a7);
		
		int b1 = 20 , b2 = 10;
		System.out.println(b1 + " * " + b2 + " = " + (b1 * b2)); // 200
		System.out.println(b1 + " / " + b2 + " = " + (b1 / b2)); // 2
		System.out.println(b1 + " % " + b2 + " = " + (b1 % b2)); // 0
		System.out.println(b1 + " + " + b2 + " = " + (b1 + b2)); // 30
		System.out.println(b1 + " - " + b2 + " = " + (b1 - b2)); // 10
		
		System.out.println("20 > 10 = " + (20 > 10)); // true
		System.out.println("20 < 10 = " + (20 < 10)); // false
		System.out.println("20 == 10 = " + (20 == 10)); // false
		System.out.println("20 != 10 = " + (20 != 10)); // true
		
		int c = 20;
		System.out.println("c = " + c); 
		System.out.println("c >= 10 && c <= 30" + (c >= 10 && c <= 30)); // true ��������Ŀ� ���̾���
		System.out.println("c <= 10 || c > 30" + (c <= 10 && c > 30)); // false
		
		int d1 = 10 , d2 = 20;
		System.out.println("ū �� = " + (d1 > d2 ? d1  : d1 < d2 ? d2 : "����" ));
		
		int d3 = 11;
		System.out.println(d3 % 2 == 0 ? "¦��" : "Ȧ��");
		
		int e = 10;
		System.out.println("e = " + e);
		
		// ���մ��� ������ 
		e += 5; // e = e + 5  >> e = 15
		
		
	}
}
