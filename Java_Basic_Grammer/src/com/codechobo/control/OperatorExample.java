package com.codechobo.control;

public class OperatorExample {
		
	public static void main(String[] args) {
			
		//245678�ʸ� �Ͻú��� �������� ��ȯ�Ͽ� ����ϼ���.
		
		// ���� Ǯ��
		
		int cho = 245678;
		
		int day = cho / (60 * 60 * 24);
		cho %= (60 * 60 * 24);
		
		int hour = cho / (60 * 60);
		cho %= (60 * 60);
		
		int min = cho / 60;
		cho %= 60;
		
		int sec = cho;	
		System.out.println(day + "��" + hour + "��" + min +"��" + sec +"��");
		
//		int cho = 245678;
//		System.out.print(" �� = " + cho);
//		
//	
//		int day = cho / (24 * 60 * 60); // 245678 / 86400 
//		System.out.println("\n" + day + "��");
//		
//		cho %= 86400; // ���� ���������� ������ 
//		System.out.println(" �� = " + cho);
//		
//		int hour = cho / (60 * 60); // 60 * 60 = 3600
//		cho %= 3600;
//		
//		int min = cho / 60;
//		int sec = cho % 60;
		
//		System.out.println(day +"��" + hour + "��" + min + "��" + sec + "��");

		System.out.println("===============================================");
		
		//�Ѵ��� ������ 1�� 5õ������ ����⸦ 20�� ������ ��� �����ؾߵ� �ݾ��� ����Ͽ� 
		//����ϼ���. 
		//��, 15�� �̻� ������ ��� 1��� 25%�� �������� �����Ͽ� ����ϼ���.
		
		int AirplanPrice = 150_000_000;
		int AirplanOrder = 20;
		long price = 0; 
		
		System.out.println((long)(AirplanPrice * 0.25)); // �Ѵ�� ���ΰ��� 
		
		price = AirplanOrder >= 15 ? AirplanPrice * 14 + ((AirplanOrder - 14) * (long)(AirplanPrice * 0.75)) : AirplanPrice * AirplanOrder;
		//                            14������� ������ + 15����� 1�뾿 25���� 
		
		System.out.println("������ ����� ���� : " + AirplanOrder + " �� ������ : " + price);
		

		//	�Ѵ��- 37,500,000	
		//	15�� 22��5õ����
		//	562,500,000�� 5��6õ   ,  	
		// 14��  2,100,000,000   15�� 187,500,000 
		
		
		System.out.println("===============================================");
	}
}
