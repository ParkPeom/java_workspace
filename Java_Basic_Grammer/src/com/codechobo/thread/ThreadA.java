package com.codechobo.thread;

public class ThreadA {

	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start(); // �ش� ������ ���� 
		
		// �ش� ������� run�޼���ȿ��� �ڽ��� ����͸� ���� ŉ��
		// ����ȭ ��� synchronized (this) 
		synchronized (b) { // �ش� ���� �κ��� ��ٸ��� �� 
			// �ȿ��� ������ �Ҽ��ֵ��� �Ѵ�.
			try {
				System.out.println("b�� �Ϸ�ɶ����� ��ٸ��ϴ�.");
				b.wait(); // Main ������� �����ȴ�. 
						  // notify �� �ؾ��� �����. 
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			// notify() �� main ������� ����� �ڱ������� ����
			System.out.println("Total is : "+ b.total);
		}
	}
}
