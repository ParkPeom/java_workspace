package com.codechobo.control;

import java.util.Calendar;

/*
   ���� ���� - ������(4Byte)�� �����ϱ� ���� su ����
   ������ 100�� ���Կ����ڸ� �̿��Ͽ� su ������ ���� 
   ���� ���� ���� �Ұ��� - ���� �߻�
   ������ ��� ���ο� ���� ������ ����
   "" (���ڿ�)+��� >> ���� ���ڿ� ���� 
   ���� ���� �� �ʱⰪ( ����
*/
public class VariableApp {
	
	public static void main(String[] args) {
	
	int intMount; 
	intMount = 100; 

	System.out.print("���� �� ������ = " + intMount);
	// int intMount; 
		
	intMount = 20; // ���� �� �ʱ�ȭ
	
	System.out.print("���� �� ������ = " + intMount);
		
	int num = 100;
	System.out.println("num = " + num);
		
		
	System.out.println("���ش�" + 2 + 0 + 2 + 1 + "�� �Դϴ�."); // 2021��
	System.out.println(2 + 0 + 2 + 1 + "�� �Դϴ�."); // 5�� (�߸��� ���) - ���� ����
	
	// ���α׷� ����� ���� �� �ؾ��� ���� �׽�Ʈ 
	// "" : ���ڰ� �ϳ��� ���� ���ڿ� - NullString ������������ �� 
	
	System.out.println("���ش�" + 2 + 0 + 2 + 1 + " �Ҷ��� �Դϴ�."); // 2021��
	
	// ������ �ڷ����� ������ , ��ȣ�� ����Ͽ� ���� ���� ���� 
	int num1 = 100 , num2 = 200;
	
	// ���� ��ȣ�� �ؼ� �켱������ ���ش�. ( ���α׷� ���� �ӵ��� ������ ) 

	System.out.println("���� ��� = " +  num1 + num2); // 100200
	System.out.println("���� ��� = " +  (num1 + num2)); // 300
	
	// + ���� *�����ΰ���?
	
	System.out.println("���� ��� = " + num1 * num2); // 20000
	System.out.println("���� ��� = " + (num1 * num2)); // 20000
	
	int kor = 88 , eng = 90; // ������ ���� ���� ����ž������� ��Ȱ�뼺 
	
	int tot = kor + eng; // ���� ����� ������ ���� 
	System.out.println("���� �հ�" + tot);
	
	// ������ ���� ����Ǿ� ���� ���� ���·� ������ ����� ��� ���� �߻�
	
	
	int number = 3; // ���������� ����ϱ����� �ݵ�� �ʱ�ȭ�ؾ��Ѵ�.
	
	System.out.println("number = " + number);
	
	
	System.out.println("������(4Byte) = " + 2147483647);
	System.out.println("������(4Byte) = " + 21474836472L);
	
	}
}
