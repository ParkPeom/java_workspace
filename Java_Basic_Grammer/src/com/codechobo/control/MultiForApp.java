package com.codechobo.control;
/*
	�������� �ٸ��� ���� �ٸ� ������ ���� ��� 

 */
public class MultiForApp {
	
	public static void main(String[] args) {
		
		int cnt = 0; // �̵������ ������ �����ϱ� ���� ����
		
		for(int i = 1 ; i <= 3; i++) { // A����  >> �� : �ݺ� 
			for(int j = 1; j <= 4; j++) { // �� >> B���� : �ݺ� 
				cnt++;
			}
		}
		System.out.println(String.format("�ݺ��� ������ %d " , cnt));
		System.out.println("=================================================================");
		
		for(int i=1; i<=9; i++) { // �� ǥ�� 
			for(int j=2; j<=9; j++) {  // �� ǥ�� 2�ܺ���
				System.out.print(j + " * " + i + " = " + j * i + "\t");
			}
			System.out.println();
		}

		System.out.println("==================");
		// 1 �簢��
		for(int i = 1; i <= 10; i++) { // ��(Row) �� �ݺ� ó���ϱ� ���� ��� 
			for(int j = 1; j <= 10; j++) { // ��(Column) �� �ݺ� ó���ϱ� ���� ��� 
				System.out.print("*");
			}
			System.out.println("");
		}
		// 2 �ﰢ�� 
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		System.out.println("=============");

		// 3 ���ﰢ��
		
		for(int i = 1; i <= 10; i++) {
			for(int j = 10; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		// 4 �ﰢ��
		for(int i = 0; i <= 10; i++) {
			
			for(int j = 10; j >= i; j--) {
				 // ����
				System.out.print(" ");
			}
			for(int k= 1; k <= i; k++)  {
				// ��
				System.out.print("*");				
			}
			System.out.println("");
		}
		// 5 �ﰢ��
		for(int i = 0; i <= 10; i++) {
			
			for(int j = 10; j >= i; j--) {
				 // ����
				System.out.print(" ");
			}
			for(int k= 1; k <= i * 2 + 1; k++)  {
				// ��
				System.out.print("*");				
			}
			System.out.println("");
		}	
		//  6 �� �ﰢ�� 
		for(int i = 0; i <= 10; i++) { // �ٹٲ� 
			for(int j = 1; j <= i; j++) {
				 // ����
				System.out.print(" ");
			}
			for(int k= 10; k >= i; k--)  {
				// ��
				System.out.print("*");				
			}
			System.out.println("");
		}    
		// 7  
		for(int i = 0 ; i <= 10; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for(int k = 10; k >= 0; k--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		// 8 �����ִ� �ﰢ��
		
		for(int i = 0; i <= 10; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for(int k = 10; k > i * 2 + 1; k--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		// 9 ������ 
		for(int i = 0; i <= 10; i++) {
			
			for(int j = 10; j >= i; j--) {
				 // ����
				System.out.print(" ");
			}
			for(int k= 1; k <= i * 2 + 1; k++)  {
				// ��
				System.out.print("*");				
			}
			System.out.println("");
		}
		// 10 �밢��
		for(int i = 0; i <= 10; i++) {
			for(int j = 0; j <= 10; j++) {
				if(i == j) {
					System.out.print("*");
				} else if(i != j){
				System.out.print(" ");
			}
			}
			System.out.println();
		}
		
		// 11 �� �밢��
		//0,0 0,1 0,2 0,3 
		//1,0 1,1 1,2 1,3
		//2,0 2,1 2,2 2,3
		//3,0 3,1 3,2 3,3
		//4,0 4,1 4,2 4,3
		
		
		for(int i = 0; i <= 20; i++ ) {
			for(int j = 0; j <= 20; j++) {
				if(i + j == 10) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
			
		
		
		// X �� �׸���	
		
	}
}


