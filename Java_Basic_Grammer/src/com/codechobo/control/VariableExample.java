package com.codechobo.control;
/*
	���α׷��� ������ ������ ���� ��Ƽ� ����Ѵ�. 

*/
public class VariableExample {
	
	public static void main(String[] args) {
		//������ ���̰� 7�̰� ������ ���̰� 10�� �簢���� ���̸� ����Ͽ� ����ϼ���.
				int garo = 7; // ����
				int saro = 10; // ����
				int rectangle = 0; // ���� 
				
				rectangle = garo * saro;
				System.out.println("�ﰢ�� ���� " + rectangle);
				System.out.println("======================================================");
				
				//���̰� 9�̰� �غ��� ���̰� 7�� �ﰢ���� ���̸� ����Ͽ� ����ϼ���.
				
				int height = 9; // ����
				int base = 7;	// ����	
				double triangle = height * base / 2.0;
				System.out.println("�ﰢ�� ���� " + triangle);
				
				System.out.println("======================================================");
				
				//10���� ��ü �����԰� 759Kg�� ��� ��� �����Ը� ����Ͽ� ����ϼ���.
				
				int num = 10;
				int totalweight = 759;
				double averageweight = 0.0;
				
				averageweight = (double)totalweight / num;
				System.out.println("��� �����Դ� " + averageweight);

				System.out.println("======================================================");
				
				//�̸��� [ȫ�浿]�� �л��� �������� 89��, �������� 93��, �������� 95���� ���� ���
				//������ ����� ����Ͽ� �̸�, ����, ����� ����ϼ���.
				//��, ����� �Ҽ��� ���ڸ������� ����ϰ� �������� ���� ó�� �ϼ���.

				String name = "ȫ�浿";
				int kor = 89 , eng = 93 , math = 95;
				
				float average = 0.0f;
				
				int sum = kor + eng + math;
				average = (float)sum / 3;
				
				
				System.out.println((int)(average * 10) / 10.0);
				
				System.out.printf("�̸� %s ���� %d ��� %.1f " , name , sum ,(int)(average * 10) / 10.0);
				System.out.println("======================================================");
	}

}


