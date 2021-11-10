package com.codechobo.control;

// ����ȯ(Type Cast) : ���� �ڷ����� �Ͻ������� ��ȯ�Ͽ� ����ϴ� ���
// => �ڵ��� ��ȯ(JVM) , ���� ����ȯ(���α׷���)
public class TypeCastApp {
	public static void main(String[] args) {
		
		// �ڵ� ����ȯ : �ڷ����� �ٸ� ���� �����ϱ� ���� JVM�� ���� �ڷ����� ��ȯ
		
		System.out.println("��� = " + (3 + 1.5)); // 3.0 + 1.5 >> ū �������� Ÿ������ 
										
		double su = 10; // 10 >> 10.0
		System.out.println("su = " + su);
		
		System.out.println("��� = " + (95 / 10)); // 9 �������� ���� ���� ��� : ������ >> 9
		System.out.println("��� = " + (95 % 10)); // 5
		
		System.out.println("��� = " + (95.0 / 10)); // �ڵ�����ȯ 9.5  �Ǽ� / ���� >> �Ǽ� 
		System.out.println("��� = " + (95 / 10.0)); // 9.5  �Ǽ� / ���� >> �Ǽ� 
		
		int kor = 95 , eng = 90; // ���� �Է� 
		int total = kor + eng; // ���� ��� 
		// double avg = total / 2; // ��� ��� 92.0 - ���� ��� : ������ >> ������ 92.0
		double avg = total / 2.0; // ��� ��� 92.5 - ���� ��� : �Ǽ��� >> ������ 92.5
		
		System.out.println(String.format("���� �հ� %d" , total));
		System.out.println("����� " + avg); 
		
		byte su1 = 10 , su2 = 20;
		byte su3 = (byte)(su1 + su2); // int���� ���� Ÿ�Գ��� �����ϸ� int������ �ڵ�����ȯ
									   // byte �� �������� ��������ȯ�� ������Ѵ�.
		System.out.println(su3);
		System.out.println("===============================================");
		
		// ���� ����ȯ : ���α׷��Ӱ� Cast �����ڸ� �̿��Ͽ� ���ϴ� �ڷ����� ������ �Ͻ������� 
		// ��ȯ�Ͽ� ����ϴ� ����̴�. - (�ڷ���)��
		int num = (int)12.3; // (int)12.3 >> 12 ������  ��������ȯ�� �ȴ�. 
		System.out.println("num = " + num); // 12 
		
		int num1 = 95 , num2 = 10;
		double num3 = num1 / (double)num2; // �������� (double) �ؼ� >> 9.5 
		System.out.println(num3);
		
		// ū �������� _�� �̿��Ͽ� ǥ�� ���� 
		int num4 = 100_000_000 , num5 = 30; // 1��
		long num6 = (long)num4 * num5; // �������� ������ ������� ������ �׷��Ƿ�
										// ���� ������� 4Byte�� �ʰ��ϸ� ������� ���� �߻��Ѵ�.
										// ���������� ���� ������ ����
										// �ǿ����ڸ� long���� ĳ�����ϰ� ������� long���� 
		System.out.println(num6);
		
		double number = 1.23656789;
		System.out.println("number" + number);
		
		// �Ҽ��� ���ڸ� ���� ��ġ������ ����ϵ��� ���α׷� �ۼ�
		System.out.printf("%.2f", number);
		System.out.println("number(����) = "+ (int)(number * 100) / 100.0); // 1.23
		System.out.println("number(�ݿø�) = "+ (int)(number * 100 + 0.5) / 100.0); // 1.23
		
		// �ø� ���ڸ��� 0�̾ƴϸ� �����ǿø� 
		System.out.println("number(�ݿø�) = "+ (int)(number * 100 + 0.9) / 100.0);  // ������ �ø�
		
		// �Ҽ��� ���ڸ����� 
	
		//////////////////////////////////////////
		// �ݿø�
	
		double number2 = 1.65432; // �Ҽ�����°�ڸ�
		System.out.println((int)(number2 * 1000 + 0.5) / 1000.0);
		
		double number3 = 25.6522; // ��°�ڸ����� �ݿø��ϱ�
		System.out.println((int)(number3 * 100 + 0.5) / 100.0);
		
		int num66 = 456;
		System.out.println(num66 / 100 * 100 );
		
	}
}
