package com.codechobo.control;

public class BreakApp {
	
	public static void main(String[] args) {
		// �ݺ����� ���ǽ��� false �̸� �ݺ��� ���� 
		
		for(int i = 1; i <= 5; i++) {
			if(i==3) break; // if�� ������ ���ǽ��� ��(true)�� ��� break ������� �ݺ��� ����
			System.out.print(i + "\t");
		}
		
		System.out.println();
		System.out.println("===============================");
		 
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {				
				// break ����� �ۼ��� �ݺ��� ���� for(int j=1; j<=5; j++) �ݺ��� ���� 
				if(j == 3) { 
					break; // break�� ����� �ݺ����� ����������. 
				}
				System.out.println(" i = " + i + "  j = " + j);
			}
		}
		
		System.out.println("===============================");
		
		// �ݺ����ȿ� �ݺ����� �����Ҽ� �ִ� (�ĺ���) �־�� �Ѵ�. 
		// ����) �󺧸� : �ݺ��� 
		
		// ���� for������ �ݺ����� �󺧸��� ���� �ݺ����� ��ü�� ���������� ���ش� 
		
		loop:
		for (int i = 0; i <= 5; i++) { // j �� 3�ϴ� ��� �ݺ����� ���� ������. 
			for(int j = 1; j <= 5; j++) { 
				
				if(j==3) break loop;  // �ݺ����� ������ �󺧸��� �̿��Ͽ� �ݺ��� ����
									  //  ���� ) break �󺧸�;
				System.out.println("i = " + i + " j = " + j );
			}
		}
		System.out.println("=========================");
		
	}
}
