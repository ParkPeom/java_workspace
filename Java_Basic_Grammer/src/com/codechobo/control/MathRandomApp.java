package com.codechobo.control;

/*
	��ǻ�ͷκ��� �������� �����޾� ����ϴ� ���α׷� �ۼ��Ͻÿ�
	=> ������ : �ұ�Ģ�ϰ� �߻��Ǵ� ���ڰ� 
	
 */
public class MathRandomApp {
	
	 /*
		������ �߻��ϴ� ���� : ������� ���� ���� ���

	 */
	public static void main(String[] args) {
		
		for(int i = 1; i<=5; i++) {
			
			// Math Ŭ���� : ���� ���� ����� �����ϴ� �޼��尡 ����� Ŭ����
			// static �޼��带 ������ �־ Ŭ�����κ��� �޼��带 ȣ���Ҽ��ִ�.
			
			// Math.random() : 0.0 ���� ũ�ų� ���� 1.0 ���� ���� �Ǽ� �������� ��ȯ�ϴ� �޼���
			System.out.println(i +"��° �Ǽ� ���� �� " + Math.random());
										
			for (int j = 0; j < args.length; j++) {
				System.out.println(i +"��° �Ǽ� ������ = " + Math.random()); 
			}
			System.out.println("==========================================");
			
	  		for(i = 1; i <= 5; i++) {
				// 0 ~ 99 ������ ������ �����޾� ����Ѵ�.
				System.out.println(i+"��° ���� ������ = " + (int)(Math.random()*100));
				
				// 1 ~ 45���� 
				// 0.0 <= random() < 1.0
				// (int)0 * 45 <= (int)(Math.random() * 45)  < (int)45
				// 1 <= (int)(Math.random() * 45) + 1 < (int)46
			}
			System.out.println();
		}
	}
}
