package com.codechobo.exception;

// ����� ���� ���� Ŭ���� ����
// Exception �� ��� �޾� ������ �Ѵ�.
public class MyException extends Exception {

	public MyException() {
		// ���� �޽��� ����
		// ����Ŭ������ Exception(String)���� �Ǿ� �ִ� �����ڸ޼��带
		// ȣ���ϸ� Exception Ŭ���� ���� ���� �޽����� �����Ѵ�.
		
		super("�Է°��� 1~100���̾�� �մϴ�.");
	}
	
	public MyException(String msg) {
		super(msg);
	}
}
