package com.codechobo.calendar.yundal;
//������� ���� ����Ŭ���� ����
// Exception�� ��ӹ޾� ������ �Ѵ�.
public class MyException extends Exception{

	public MyException() {
		// ���� �޽��� ����
		// ����Ŭ������ Exception(String)���� �Ǿ� �ִ� �����ڸ޼ҵ带
		// ȣ���ϸ� Exception Ŭ���� ���� ���� �޽����� �����Ѵ�.
		super("�Է°��� 1~100���̿��� �մϴ�.");
	}
	public MyException(String msg) {
		super(msg);
	}
}
