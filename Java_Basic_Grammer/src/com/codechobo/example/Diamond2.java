package com.codechobo.example;
import java.util.Scanner;

public class Diamond2 {
	Scanner scan = new Scanner(System.in);
	public Diamond2() {}
	public void start() {
		System.out.print("������ Ȧ�� �Է�(1~49)->");
		int max = scan.nextInt();
		if(max%2==0) max++;
		char alpha = 'A';
		int step = 2;
		
		//�ﰢ��
		for(int i=1; i>=1; i+=step) {// 1,3,5,7,9,.....max			
			for(int s=1; s<= (max-i)/2; s++) {//1,2, ,,,12//����ó��
				System.out.print(" ");
			}			
			for(int j=1; j<=i; j++) {//���� ���ڸ� ���
				System.out.print(alpha++);
				if(alpha>'Z') alpha='A';
			}
			System.out.println();//�ٹٲ�
			//�����Ǵ°���Ȯ���Ͽ� ���� �ٲ۴�.
			if(i>=max) step=-2;
		}			
	}
	public static void main(String[] args) {
		new Diamond2().start();
	}
}
