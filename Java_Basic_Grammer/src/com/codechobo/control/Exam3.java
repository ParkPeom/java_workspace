package com.codechobo.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam3 {
	
	public static void main(String[] args) throws IOException {
		
		boolean is = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		do {
			System.out.print("�޴� 1 ~ 2 ���� �ٽ� , ���� : 3  > ");
			int choice = br.read();
			
			switch(choice) {	
			case 1: 
				System.out.println("1���޴��Դϴ�.");
				continue; // �ٽü��� 
			case 2:
				System.out.println("2���޴��Դϴ�.");
				continue; // �ٽ� ����
			case 3:	
				System.out.println("����");
				break;
			}

		}while(!true);
	}
}
