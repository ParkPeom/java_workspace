package com.codechobo.control;

// �������� (Local Variable) : �޼��� �Ǵ� ��� ���� �� ���ο��� ����� ���� 
// => ���������� ����� �� ���ο����� ��� ���� 
// => ���������� ����� ���� ����Ǹ� ���������� �ڵ� �Ҹ� �ȴ�.(�޸𸮻� ���°�)
// 
public class localVariableApp {
	
	
	
	public static void main(String[] args) {
		
		int num1 = 100; 
		
		// ���� �� , ���������� ����� ������ �Ҹ�ȴ�. 
		{ 
			int num2 = 200; // ����� ������ �Ҹ�� 
			
			System.out.println("=======���Ǻ� ����======");
			System.out.println("num2 = " + num1);
			System.out.println("num1 = " + num2);
		}
		int num2 = 200;
		System.out.println("=======���Ǻ� �ܺ�=======");
		System.out.println("num1 = " + num1);
		
		// ���Ǻ�� ����� num2 ������ �Ҹ�ǹǷ� ��� �Ұ���
		// System.out.println("num2 = " + num2);
	}
}



