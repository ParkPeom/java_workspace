package com.codechobo.control;

import java.util.Scanner;

public class ForExample {

	public static void main(String[] args) {

		//���� �̸��� ȭ�鿡 7�� ����ϼ���.
				//ex) ȫ�浿 ȫ�浿 ȫ�浿 ȫ�浿 ȫ�浿 ȫ�浿 ȫ�浿
				
				for(int i = 1; i <= 7; i++) {
					System.out.print("�ڹ�" + " \t ");
				}
				
				System.out.println();
				// 1~10 ������ ���� �� Ȧ���� ȭ�鿡 ����ϼ���.
				//ex) 1     3     5     7     9
		
				for(int i = 1; i <= 9; i=i+2) {
					System.out.print(i+ "\t");
				}
				System.out.println();
	
				//1~100 ������ �������� 3�� ������� �հ�� 5�� ������� �հ踦 ����Ͽ�
				//3�� ����� �հ迡�� 5�� ����� �հ踦 �� ������� ����ϼ���.
				//ex) ��� = 633		
		
				
				int result2 = 0;
				for(int i = 1;  i <= 100; i++) {
					if(i % 3 == 0) result2 += i; // ���ù�(�ݺ���)�� ����� �ϳ��� ��� { } ���� ���� 
					 
					if(i % 5 ==0) result2 -= i;	
				}
				System.out.println(result2);
				
				//������ �� 7���� ȭ�鿡 ����ϼ���.
				//ex) 7 * 1 = 7
				//    7 * 2 = 14
				//    ...
				//    7 * 8 = 56
				//    7 * 9 = 63
				for(int i = 2; i <= 9; i++) {
					for(int j = 1; j<= 9; j++) {
						
						if(i == 7) {
							System.out.printf("%d * %d = %d%n",i,j,i*j);
						}
					}
				}

				//5!�� ������� ����ϼ���.(5! = 5 * 4 * 3 * 2 * 1)
				//ex) 5! = 120
				System.out.print("���� �� �Է� > ");
				Scanner scanner = new Scanner(System.in);
				int start = scanner.nextInt();
				int result = 1;
				for(int i = start ; i >= 1; i--) {
					result *= i;
				}
				System.out.print(String.format("%d ! = %d", start , result));
				
				//�� ������ ����� ������ ������ �������� ȭ�鿡 ����ϼ���.
				//��, �� �ٿ� �������� 7���� ��µǵ��� ���α׷��� �ۼ��ϼ���.
				//ex) 36    37    38     39     40     41     42
				//    43    44    45     46     47     48     49
				//    50    51    52     53     54     55     56
				//    57

				// �޷¸��鋚�� ���ϰ����� ī���� ��
				
				System.out.println();
				int begin = 36;
				int end = 56;
				int count = 0; // ī��Ʈ���� �ٹٲ� 
				
				for(int i = 36; i <= 57; i++) {
					System.out.print(i + "\t");
					if(i % 7 == 0) {
						System.out.println();
					}
				}
			}
		}
