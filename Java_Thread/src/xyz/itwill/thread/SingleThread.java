package xyz.itwill.thread;

public class SingleThread {
	
	public void display() {
		/*
		System.out.println("SingleThread Ŭ������ display() �޼��忡 ��� ����");
		
		System.out.println("["+Thread.currentThread().getName()+"]�����忡 ���� main() �޼ҵ��� ��� ����ǰ� �־��");
		
		System.out.println("SingleThread Ŭ������ display() �޼��忡 ��� ����");
		*/
		// �ݺ����� �̿��Ͽ� a~z(���ĺ� �ҹ���)�� ��� 
		for(char i = 'a'; i <= 'z'; i++) {
			System.out.print(i);
		}
	}
}
