package com.codechobo.control;

public class IfApp {
	
	public static void main(String[] args) {
		
		int su = 90;
		// �������� 50�̻��� ��쿡�� ������ ���
		
		if(su >= 50) { // su 50���� ũ�ų� ������ true ���� ��µ� 
			System.out.println("sum = " + su);			
		}
		
		System.out.println("===========================");
		
		int score = 50;
		
		// �������� 60�̻��� ��� �հ� �޽��� ��� , 60 �̸��� ��� ���հ� �޽��� ���
		
		
		/* if��� ������ 2���� �ִ� , ���϶��� ����� 
		if(score >= 60) {
			System.out.println("����� 60�� �̻����� �հ��Դϴ�.");
		} 
		if(score < 60) {
			System.out.println("����� 60�� �̸����� ���հ� �Դϴ�");
		}
		*/

		// if �ϳ��� ȿ�����̴�.
		
		if(score >= 60) { // ������ ���϶� ���� 
			System.out.println("����� 60�� �̻����� �հ��Դϴ�.");
		} else { // ������ �����϶� ����
			System.out.println("����� 60�� �̸����� ���հ� �Դϴ�.");
		}
		System.out.println("========================================");
		
		int num = 9;
		
		// �������� Ȧ���� ¦���� �����Ͽ� ��� x % y == 0  [  x�� y�� ����̴�. ] 
		
		if(num % 2 == 0) { // ��� �����ڸ� ������ָ� �ȵ� 
			System.out.println(num + "¦�� �Դϴ�.");
		} else {
			System.out.println(num + " Ȧ�� �Դϴ�.");
		} 
		
		// ���׿����ڷ� ǥ���ϸ�
		String str = num % 2 == 0 ? num + " ¦�� �Դϴ�." : num + " Ȧ�� �Դϴ�";
		System.out.println(str);
		
		System.out.println("===============================");
		
		char mun = 'O';
		
		
		// �������� ������ �Ǵ� �񿵹��ڷ� �����Ͽ� ����ϱ�
		
		if(mun == '0') {
			System.out.println("�񿵹��� 0 �Դϴ�.");
		} else if('a' <= mun && mun <= 'z') {
			System.out.println("�ҹ��� �Դϴ�.");
		} else if('A' <= mun && mun <= 'Z') {
			System.out.println("�빮�� �Դϴ�.");
		} else {
			System.out.println("�ƹ� ���ڵ� �ƴմϴ�. ");
		}
		
		// ������� Ǯ���ֽŹ�� 
		// ������ ������ && 
		if(mun > 'a' && mun <= 'z' || mun >= 'A' && mun <= 'Z') {
			System.out.println("������ �Դϴ�.");
		} else {
			System.out.println("�񿵹��� �Դϴ�.");
		}

		System.out.println("================================");
		
		// boolean ������ �̿��ؼ� true false 
		
		boolean sw = true;
		// ���ǽ� ��� boolean �������� �̿��Ͽ� ��� ���� ���� ����
		if(sw) { // sw���� true�� ��� , ��ȣ �ȿ��� true �ƴϸ� false �� ������ �ȴ�.
			System.out.println("���� ���´� ���Դϴ�. ");
		} else {
			System.out.println("���� ���´� �����Դϴ�.");
		}
		
		System.out.println("=================================");
		
		// ������ ���϶����� ������ �����϶� ���α׷� ����� ��찡 ����
		// �߸��� ���̶�� ����� �����ؼ� ���̻� ���α׷��� �������� �ʵ��� �ϱ� ����
		// not �����ڴ� ���� ����. 
			
		// ����ڰ� ���� �Է����� ������ , �Է��Ѱ��� �����̶� �ٸ��� 
		// ���� �ƴ϶�� 
		
		if(!sw) { // not�� �������ν� �����϶� ��� �����ϰ� ���� 
			System.out.println("���� ���´� ���Դϴ�. ");
		} else {
			System.out.println("���� ���´� �����Դϴ�.");
		}	
		// while(!(input == answer))
		
		System.out.println("===============================");
		
		int jumsu = 98; // �Է°��� ��ȿ�� �˻� ( ex ) ���̵� , �н����� �� 
		// �������� 0���� 100 ������ ��ȿ������ �ƴ����� �����Ͽ� ����Ͻÿ�
		// ����ڰ� �Է��� ���� ��ȿ�Ѱ����� �ݵ�� Ȯ���� �ؾ��Ѵ�.
			
		// ���ڿ��� �ʱⰪ�� NullString�� ���� �ش�. 
		String grade = ""; // ����� �����ϱ� ���� ���� 
		String oper = "";
		if(!(0 <= jumsu && jumsu <= 100)) { // && ������ ǥ���ϴ� ���ǽ� 
			System.out.println("��ȿ�����ʽ��ϴ�.");
		} else {
			// ��ȿ�� ���� �Է��� ��� �������� �̿��Ͽ� ����� �����Ͽ� ����Ѵ�. 
			// 100~90 A , 89~80 B , 79~70 C , 69 ~ 60 D , 59 ~ 0 F
			// 95 �̻�  + , 85 �̻� + , 75 �̻� + , 69 �̻� + 55 �̻� + 

			// �ۿ��� �̹� ��ȿ�� �˻��ؼ� ������ �̹� �ɷ��� �ֱ� ������ 
			// ũ�� ��� ����� �ȴ�. (�ڵ��� ���ʿ����� ���ϼ��ִ�.)
			if(jumsu >= 90) {
				grade += "A";
				if(jumsu >= 95) {
					oper += "+";
				}
			}
			else if(jumsu >= 80) {
				grade += "B";
				if(jumsu >= 85) {
					oper += "+";
				}
			}
			else if(jumsu >= 70) {
				grade += "C";
				if(jumsu >= 75) {
					oper += "+";
				}
			} else if(jumsu >= 60) {
				grade += "D";
				if(jumsu >= 65) {
					oper += "+";
				}
			} else { // ��� ������ �����̶�� (������������ ����� 
				grade += "F";
			}
			System.out.println("��� : " + jumsu +"�� ����� " + grade+oper);	
		}	
		
		
	}
}
