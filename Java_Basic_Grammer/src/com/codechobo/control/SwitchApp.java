package com.codechobo.control;

/*
  ���� ����Ű  Ctrl + shift + F : ����� �����ϴ� ����Ű 
 
 */
public class SwitchApp {

	public static void main(String[] args) {

		int choice = 2; // break�� �Ⱦ��� ���� ���� ��ġ�� ������ �޷�� �����

		switch (choice) { // �ȿ� ���ǽľȾ�!!! ������ �� , (�Ǽ����� ���� �ȵȴ�.)

		case 1: // �ݷ� case���� ��� ���ڿ� ���� �ä����ְ� (������ ���� ���´�)
			System.out.println("�������� �̵��մϴ�.");
			break;
		case 2:
			System.out.println("�ݼ����� �̵��մϴ�.");
			break;
		case 3:
			System.out.println("ȭ������ �̵��մϴ�.");
			break;
		default:
			System.out.println("�ƹ��뵵 �Ȱ� ");
		}

		// switch �� �� (������,���� �����) case �� ��(���ͷ� , ���) �� ���Ͽ� ���� ���� ����
		// case ��ġ�κ��� �ϴܿ� �����ϴ� ��� ��� ����
		
		switch (choice) { // �ȿ� ���ǽľȾ�!!! ������ �� , (�Ǽ����� ���� �ȵȴ�.)

		case 1: // �ݷ� case���� ��� ���ڿ� ���� �ü��ְ� (������ ���� ���´�)
			System.out.println("�������� �̵��մϴ�.");
			break;
		case 2:
			System.out.println("�ݼ����� �̵��մϴ�.");
			break;
		case 3:
			System.out.println("ȭ������ �̵��մϴ�.");
			break;
		default: // ��� case�� ���� ���� ���� ��� ������ ����Ǵ� ����� �ۼ��ϴ� ��ġ�� ǥ�� 
			System.out.println("������ �̵��մϴ�. ");
		}
		
		// switch �� �������� 
		switch (choice) { 
		case 1: 
			System.out.println("�������� �̵��մϴ�.");
			break; // ���� ���� ��Ŵ 
		case 2:
			System.out.println("�ݼ����� �̵��մϴ�.");
			
		case 3:
			System.out.println("ȭ������ �̵��մϴ�.");
			
		default: 
			System.out.println("������ �̵��մϴ�. ");
		}
		
		// �������� 0~100 ������ ��ȿ������ �ƴ����� �����Ͽ� ��� - �Է°��� ��ȿ�� �˻�
		
		
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
		
		// �� ������ switch ������ ����
		
		// 100 ~ 90 , 90 ~ 80 , 80 ~ 70 , 70 ~ 60 , �׿� F
		// if�� Ȱ�밡ġ�� �� ���� 	
		
		jumsu = 88;
		switch(jumsu / 10) { // ������� ����� , �������� ���ϴ°� �� ���� 
			
		case 10: // 10 / 100 = 10 A
		case 9:  // 10 / 90 = 9 A
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
		
		System.out.println("������ " + jumsu +"����� " + grade + "�Դϴ�.");
		
		System.out.println("===============================================");
		
		String kor = "��";
		String eng = "";

		// JDK 1.7 �̻󿡼��� switch������ ���ڿ��� ���ؼ� ���� ���� �� �� �ִ�. 
		// �޴� ���� ��ɱ����� Switch���� ���� ���δ�. 
		// ������ �ǵ��� if���� ���� Ǭ��.
		switch(kor) {
		case "�ϳ�":
			eng = "One";
			break;
		
		case "��":
			eng = "Two";
			break;
			
		case "��":
			eng = "Three";
			break;
		}
		System.out.println("[���]" + kor + " = " + eng);
	}
}
