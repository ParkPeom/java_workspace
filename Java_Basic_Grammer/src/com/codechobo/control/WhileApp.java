package com.codechobo.control;


/*
	while���� �ݺ�Ƚ���� ������ ���� ������ ���δ�

 */
public class WhileApp {
	
	public static void main(String[] args) {
		
		// Java Programming �� ȭ�鿡 5�� ���	
		int i = 1; // �ʱ��(���� ����)
		while(i <= 5) { // ���ǽ� 
			
			System.out.println("Java Programming");
			i++; // ������ (���� ����)
		}
		System.out.println("============");
		
		// 1 ~ 100 ������ ���� �հ� -> ������ �հ�� ������ ������ �־ for���� ����ϴ� ���� ���� 
		// GUI �� While���� ���� ���δ�
		i = 1;
		int sum = 0;
		do {
			sum += i;
			i++;
		} while( i < 100 );
	System.out.println("1 ~ 100 �� : " + sum);	
	
	// A4 ������ ������ ��� ���� ������ �� �簢�� ����� 500�� �̻��� ����� ������ ��� ����� �Ǵ���
	// �����Ͽ� ����Ͻÿ�(�ݺ�Ƚ���� �𸦶� while��) 
	int num = 0;
	i = 0; // ���� Ƚ�� 
	while(true) {
		i++; // ����Ƚ�� 
		num++; // �簢������ ������ 
		
		if(num >= 500) { // �簢�� ����� ������ 500�� �̻��� ��� �ݺ��� ���� 
			break;
		}	
		num *= 2; // �簢�� ���� 
	}
	System.out.print("���� Ƚ���� : " + i + " �簢���� ������ : " + num);
	System.out.println("");
	
	int gae = 1;
	int cnt = 0;
	
	while (gae <= 500) {
		cnt++;
		gae *= 2;
	}
	System.out.print("���� Ƚ���� : " + i + " �簢���� ������ : " + num);
	System.out.println("");
	
	
	// 1 ~ x ������ �������� �հ谡 300 �̻� �Ƿ��� x�� ������ ����Ͽ� ����Ͻÿ�
	// �������� �ݺ��ؾ����� �𸦶� while �� ���°� ȿ�����̴�.
	
	i = 1 ;
	int sum2 = 0;
	while(true) {
	
		sum2 += i;
		if(sum2 >= 300) {
			break;
		}
		i++;
	}
	System.out.println("x �� ��� ������ " + i );
	
	}
}
