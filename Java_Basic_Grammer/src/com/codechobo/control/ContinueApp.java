package com.codechobo.control;

/*
 	Continue ���� ��ɹ��� �ǳʶ�ﶧ ���δ�. 

 */

public class ContinueApp {
	
	public static void main(String[] args) {
		
		for(int i = 1; i <= 5; i++ ) {
			// if������ ���ǽ��� ���� ��� �ݺ����� ó������ �ٽ� ���� 
			// => continue ��� �ϴܿ� �ۼ��� ��� �̽��� 

			if(i == 3) { // ��� �̽��� 
				continue;
			}
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println("===========");
		
		for(int i = 1; i <= 5; i++ ) {
			for(int j = 1; j<= 5; j++ ) {
				
				// continue ����� �ۼ��� �ݺ����� ����� ó������ �ٽ� ���� 
				if(j == 3) {
					continue;
				}
				System.out.println("i =" + i + " j = " + j);
			}
		}	
		System.out.println("============");
		
		loop:
		for(int i = 1; i <= 5; i++ ) {
			for(int j = 1; j<= 5; j++ ) {
				
				// continue ����� �ۼ��� �ݺ����� ����� ó������ �ٽ� ���� 
				if(j == 3) {
					continue loop; // break �� �����ϴ�. �����ʴ� ���� ���� ȿ�� 
									// �󺧸��� ���� i�� �̵�
				}
				System.out.println("i =" + i + " j = " + j);
			}
		}
	}
}
