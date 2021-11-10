package com.codechobo.control;

public class DataTypeApp {
	
	public static void main(String[] args) {
		
		System.out.println("<<������(Integer Type)>>");
	
		// println() �޼���� �������� 10������ ��ȯ�Ͽ� ���
		
		System.out.println("������(10����) = " + 100);
		System.out.println("������(8����) = " + 0100);
		System.out.println("������(16����) = " + 0x100);
			
		// int a5 = 100L; // ������ �ս� ���ɼ��� ���� ���� �߻�
		
		long a5 = 100;
		System.out.println("a5 = " + a5);
		System.out.println("==============================");
		
		System.out.println("<<�Ǽ���(Double Type)>>");
		System.out.println("�Ǽ���(4Byte) = "+ 12.3F);
		System.out.println("�Ǽ���(8Byte) = "+ 12.3);
	
		//�������� ǥ���ϱ� ���� �ڷ��� : byte , short , int ,long
		byte b1 = 127; // �޸� ����
		short a2 = 32767; // c��� ����
		int a3 = 2147483647; // ������ 4����Ʈ 
		long a4 = 2147483648L; // ������ 8����Ʈ 
		
		a3++;
		System.out.println("a3 : " +  a3); // -2147483648
		

		// println() �޼���� ���� ���� �Ǽ��� �Ǵ� ���� Ŀ�ٶ� �Ǽ����� �������·� ��ȯ�Ͽ� ����Ѵ�.
		System.out.println("�Ǽ���(8Byte = " + 0.000000000123);
		
		// �������·� ǥ�� 
		System.out.println("�Ǽ��� " + 1.23E10); // 123000000 �� �������·� ǥ��

		// �Ǽ����� ǥ���ϱ� ���� �ڷ��� : float , double 
		float f1 = 1.23456789F; // float >> 4byte ������ ǥ������ : 7�ڸ�
		double b2 = 1.23456789; // double >> 8byte - ������ : 15�ڸ�
	
		System.out.println("f1 = " + f1); // ©���� 7�ڸ������� ǥ�� 
		System.out.println("b2 = " + b2);
		
		long b3 = 100000000L * 30;
		System.out.println("b3 = " + b3);
		
		System.out.println("============");
		System.out.println("<<������(Character Type>>");
		
		// ���ڰ��� ' ' �ȿ� ǥ���Ͽ� ���������� ��ӵ� 2Byte ���������� ǥ��
		System.out.println("���ڰ�(2Byte) = " + 'A');
		
		// jAVA���� ǥ�� �Ұ����� ���ڴ� Escape Character(ȸ�ǹ���)
		// => \n : Enter , \t:tab , \" : ����" , \\" : ����\"
		System.out.println("���ڰ�(2Byte) = " + '\'');
		System.out.println("���ڰ�(2Byte) = " + '\\');
		
		// ���ڰ��� ǥ���ϱ� ���� �ڷ��� : char
		char c1 = 'A'; // 'A' = 65 , 'a' = 97
					   // '0' = 48 , ' ' = 32
					  // '\n' = 13 , '��' = 44032 - �ϼ��� 
			// ���� �������� ���ڰ��� ���� ��ӵ� ���������� ����
		char c2 = 65;
		System.out.println(c2); // A
		char c3 = 'a'- 32; // 'A
		System.out.println(c3);
		
		System.out.println("c1 = " + c1 );
		System.out.println("c2 = " + c2 );
		System.out.println("c3 = " + c3 );
		
		char c4 = 45000;
		System.out.println("c4 = " + c4);
		
		System.out.println("============================");
		System.out.println("<<����(Boolean Type)>>");
		System.out.println("����(1Byte) = " + false);
		System.out.println("����(1Byte) = " + true);
		// ���� ������(�񱳿�����)�� �̿��� ������� ��������� ���� ����
		System.out.println("����(1Byte) = " + (20 > 10)); // true
		System.out.println("����(1Byte) = " + (20 < 10)); // false
		
		// ������ ǥ���ϱ� ���� �ڷ��� : boolean 
		boolean d1 = false;
		boolean d2 = 20 > 10;
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		
		System.out.println("<<���ڿ�(String Type)>>");
		// ���ڿ��� " "�ȿ� ǥ���Ͽ� ������(Reference Type - Ŭ����)���� ǥ��
		System.out.println("���ڿ� = " + "ȫ�浿");
		// \" ȸ�ǹ��ڷ� ǥ�� 
		System.out.println("������ ���簡 \"���ѹα� ���� \" ��� ���ƽ��ϴ�.");
		String str = new String("hahaha");
		
		// ���ڿ��� ǥ���ϱ� ���� �ڷ��� : String Ŭ����)
		String name = "�Ӳ���";
		System.out.println("�̸� = " + name );
		
	}
}
