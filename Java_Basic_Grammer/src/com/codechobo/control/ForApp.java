package com.codechobo.control;

import java.util.Iterator;

public class ForApp {
	
	public static void main(String[] args) {
		
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		System.out.println("Java Programming");
		
		// "Java Programming" �� ȭ�鿡 5�� ���
		// �ݺ��� Ƚ���� �˸� ���ϴ� Ƚ����ŭ �˼��ִ�.
		// �ݺ� Ƚ�� �ε�ȣ�� �߸��ָ� ���ѹݺ��� �ɼ��ִ�.
			
		for (int i = 0; i <= 5 ; i++) { // i������ ���������� for���̳����� �Ҹ� 
											// �ʱ���� �Ǵ°��̴�.
			// �ʱ�� ���ǽ� ������ 
			System.out.println("Java Programming");
		}
		// ��Ʈ��ũ ���� ���鶧�� Ŭ���̾�Ʈ�� ���ӵǴ°� ��ٸ��� ������
		// �Ϻη� ���ѷ��� 
		
		System.out.println("==========================================");
		
		// ���ϴ� Ƚ����ŭ �ݺ� ó�� �Ѵ�. 
		for(int i = 5; i >= 1; i--) { // i �� 0 �� �Ǹ� ������ �Ѵ�. 
			System.out.println("Java Programming");
		}	
		System.out.println("==========================================");
		System.out.println("1  2  3  4  5");
		
		for(int i = 1; i <= 5; i++ ) { // i�� �ݺ����� ������� �����ִ�.
			System.out.print((6-i) +"\t"); // Tab >> "\t"
		}	
		System.out.println(); // Enter ���
		System.out.println("=======================================");
		
		// "2  4  6  8  10" �� ȭ�鿡 ���
		for(int i = 2; i <= 10; i+=2) {
			System.out.print(i + "\t");
		}
		
		// 1 ���� 100 ������ �������� �հ踦 ����Ͽ� ����Ͻÿ�
		System.out.println("========================");
		
		int top = 0;
		for(int i = 1 ; i <= 100; i++) {
				top += i;
		}
		System.out.println("========================");
		System.out.println("1~100 ������ �հ�� : " +  top);
		
		// �� ������ ����� ������ ������ �������� �հ踦 ����Ͽ� ����Ͻÿ�
		
		
		
		// ������ : ����� �Ͻ������� �о�帱���ִ� 
		
		
		int begin = 80; // ���߰���� �����ġ�� ���γѹ����� ����Ŭ�� -> breakPoint���� 
						// -> F11 -> ��ȭ����� -> Perspective �� ����� Perspective �� �ٲܰǰ�?
						// ���ʿ� �����尡 ���δ�.
					    // ���ʿ� main �޼��� �����尡 59���� ��ó�ִ�. (����������)
						// ����� �����尡 �о�帱�κ� 
						// �����ʿ� ���ݱ��� ������ ����
						// �ؿ� �ܼ� ���
						// F5 : ���� �������ʴ°ͱ��� ���������� ǥ���Ǽ� ��ɵ��� ����
						// F6 : ���� ���̴� ��ɵ鸸 �����
		int end = 100;
		int sum = 0;
		
		// �Է°��� ���� ��ȿ�� �˻縦 �Ѵ�.
		// ���۰��� ���ᰪ ���� ū��� �� �������� ���� �ٲپ� ����
		if(begin > end) {
			// �˰��� : ���α׷� �ۼ����� �߻��Ǵ� ������ �ذ��ϱ� ���� ��� 
			// ġȯ �˰��� (�κ����� ���� �ٲٱ� ���� ���)	
			
			int tmp = 0; // �ӽ� ���� 
			tmp = begin;
			begin = end;
			end = tmp;
		}
		
		if(begin > end) {
			System.out.println("[����] ���۰��� ���ᰪ���� �۾ƾ� �մϴ�.");
			System.exit(0); // ���α׷��� ���� �����ϴ� �޼��带 ȣ���ߴ�.
		}
		for(int i = begin; i <= end; i++) {
			sum += i;
		}
		System.out.println(begin + " ~ " + end + " �հ� �� :" + sum);
		
		
		// �ʱ�� �Ǵ� �������� , ��ȣ�� ����Ͽ� ������ ���� �ۼ��� �����ϴ� 
	    // ���� �������� �ʴ´�.
		for(int i = 1,j = 5 ; i <= 3; i++,j--) {
			System.out.println("");
		}
		System.out.println("===========================================");
		
		int i = 1; // for������ ������� ��� �����Ѵ�.(main�޼��尡 ������ ���� �����Ѵ�
		
		// for������ �ʱ�� ���ǽ� ������ ������ �����ϴ� 
		for( ; i <= 4; i++) {
			System.out.println(i +"\t");
		} // ������ i�� 5���Ǽ� �������� 
		
		// i = 5
		for(; i>=1; i--) {
			System.out.println(i +"\t");
		}
//		for(;;) { // �� �����ص� for������ �ݵ�� ;; 
//				  // ���ǽ��� ������ ��� ������ true�̴�. -> ���ѷ��� (������� �ʴ� �ݺ���)
//			System.out.println("���ѹݺ��Ǵ� ���");
//		}
		//	System.out.println("==================================="); �����ڵ� : ���ѷ��� ������ �ϴ� ������ �ȵ�(�����߻�)
	
	}
}
