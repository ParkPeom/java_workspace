package com.codechobo.innerclass;

public class �͸�Ŭ�����׽�Ʈ {
	
	public static void main(String[] args) {
		(new Object() { // Ŭ������ ���ǿ� ��ü ������ ���ÿ� �Ѵ� - ��ȸ��
			public void methodTest() {
				System.out.println("���");
				StaticMethod();
			}
			public static void StaticMethod() {
				System.out.println("����");
			}
		}).methodTest();
		
	}
}
