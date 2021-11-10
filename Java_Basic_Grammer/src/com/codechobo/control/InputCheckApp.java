package com.codechobo.control;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// Ű����� ������ �Է¹޾� ������ ����Ͽ� ����ϴ� ���α׷� �ۼ� 
// => 100 ~ 90 A , 89 ~ 80 : B , 79 ~70 : C , 69 ~ 60 : D , 59 ~ 0 : F 
// => Ű���� �Է� ������ 0 ~ 100 ������ �������� �ƴ� ��� ���� �޽��� ��� �� ���Է� 

public class InputCheckApp {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner scanner = new Scanner(System.in);
		
		int score = 0;
		String grade = "";
			
		do {
			System.out.print("������ �Է� �Ͻÿ� > "); // �ٽ� �Է¹ް� �ݺ��� �ȿ� ��������Ѵ�. 
			score = scanner.nextInt(); // �ٽ� �Է¹ް� �ݺ��� �ȿ� ��������Ѵ�. 
		
			// ��ȿ�� �˻� 
			if(!(0 <= score && score <= 100)) {
				System.out.println("�߸��� �� �Է��ϼ̾��"); // �߸��� ���� ����ϱ� ���� ���ǹ� 
			}
			switch(score / 10) { 
			case 10:
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;
			case 6:
				grade = "D";
				break;
			default :
				grade = "F";
			}
		}while(! (0 <= score && score <= 100) ); // ���������� ���� �ԷµǸ� �ݺ� ����ɼ� �ְ� �� 
	System.out.println("[���]" + score + "�� >> " + grade + "����");
	
	System.out.println();
	
	// ���ǽ� ��� true�� ����� ��� ������ ������ ó���Ǿ�
	// ���ǽ� ��� ��(true)�� ����� ��� ���ѷ��� �̴�.
	
	while(true) { // while���� ������ true �� �ϴ°� ���� break�� ���������� 
				   // �߰����� �������־ ����. 

		System.out.print("������ �Է� �Ͻÿ� > "); // �ٽ� �Է¹ް� �ݺ��� �ȿ� ��������Ѵ�. 
		score = scanner.nextInt(); // �ٽ� �Է¹ް� �ݺ��� �ȿ� ��������Ѵ�.
		
		// ���ѹݺ��� ����� �ְ� �Ϸ��� ������ ���ǹ��� �༭ break �� ���������� �Ѵ�.
		
		if(score >= 0 && score <= 100) { // �������� ���� �Էµ� ���
			break; // �ݺ����� ������
		}
		// ���������� ���� �Էµ� ��� ���� �޽��� ��� 
		System.out.println("[����] ������ 0  ~ 100 ������ ���ڸ� �Է� �����մϴ�. ");
	}
		switch(score / 10) { 
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default :
			grade = "F";
		}
		System.out.println("[���]" + score + "�� >> " + grade + "����");
	}
}
