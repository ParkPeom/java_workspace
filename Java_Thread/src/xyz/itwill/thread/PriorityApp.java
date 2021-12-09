package xyz.itwill.thread;

public class PriorityApp {
	
	public static void main(String[] args) {
		
		PriorityOne one = new PriorityOne();
		PriorityTwo two = new PriorityTwo();
		
		//Thread.setPriority(int priority) : �������� �켱������ �����ϴ� �޼ҵ�
		// �������� �켱������ ���������� Ŭ���� �켱������ ������ ����
		// => ������ �켱 ���� ���� : 1(MIN_PRIORITY) 10(MAX_PRIORITY)  1~10 �⺻�� 5
		one.setPriority(Thread.MIN_PRIORITY);
		two.setPriority(Thread.MAX_PRIORITY);
		
		one.start();
		two.start();
	}
}
