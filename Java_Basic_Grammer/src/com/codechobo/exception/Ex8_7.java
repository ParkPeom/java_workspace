package com.codechobo.exception;

public class Ex8_7 {
	
	public static void main(String[] args) {
//		throw new Exception(); // ���Ƿ� Exception �߻� try-catch �ʼ�
		try {
			// RuntimeException�� �� �ڼ��� ����ó���� ������ �ʾƵ� �������� �ȴ�.(����)
			throw new RuntimeException(); // try-catch ���� 
		} catch(Exception e) {
		}
	}
}
