package com.codechobo.collection.exam;
//����� ���� ���� Ŭ���� ����.
// Exception�� ��ӹ޾� ������ ��.

public class MyException extends Exception{

	public MyException() {
			//���� �޼��� ����
			//���� Ŭ������ Exceoption(String)���� �Ǿ� �ִ� �����ڸ޼ҵ带
			//ȣ���ϸ� Exception  Ŭ���� ���� ���� �޽����� �����Ѵ�.
			super("���� 1~12�� ���̿��� �մϴ�.");
		
		    // ���� Ŭ������ Exception(String)���� �Ǿ� �ִ� �����ڸ޼ҵ带
	        // ȣ���ϸ� Exception Ŭ�������� ���� �޽����� �����Ѵ�.
	
	}
	public MyException(String msg) {
		super(msg);
	}
}
