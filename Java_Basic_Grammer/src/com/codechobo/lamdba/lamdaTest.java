package com.codechobo.lamdba;

public class lamdaTest {
	
	public lamdaTest() {
	
	}
	public static void main(String[] args) {
		// Object obj = (a, b) -> a > b ? a : b; // ���ٽ�. �͸�ü
		MyFunction f = new MyFunction() { // �͸��Լ��� �ٷ�� ���� ���������� Object
			public int max(int a, int b) { // �������̵� - ���������ڴ� ���� ���ٲ۴�
				return a > b ? a : b;
			}
		}; // �̰� ������ ǥ���Ѱ� ����� 
		// �� ���ٽ��� �ٷ���� ���������� �ʿ��ѵ�.. �װ� �Լ��� �������̽� ��
		
		// ���ٽ�(�͸� ��ü)�� �ٷ�� ���� ���������� Ÿ���� �Լ��� �������̽��� �Ѵ�.
		MyFunction f2 = (a , b) -> a > b ?  a : b;
		
		int value = f.max(3,5); // �Լ��� �������̽��� �ʿ���.(���� ���ǿ��� ���)
		System.out.println("value="+value);
		
	}	
}

@FunctionalInterface // �Լ��� �������̽� ǥ���ϸ� - ������ �߻�޼���� �ϳ� 
interface MyFunction { 
//	public abstract int max(int a,int b); public abstract ���� ����
	int max(int a,int b); // �߻�޼��带 ���ؼ� ���ٽ��� ȣ���Ѵ�. 
}