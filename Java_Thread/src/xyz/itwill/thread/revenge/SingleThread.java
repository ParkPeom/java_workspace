package xyz.itwill.thread.revenge;

public class SingleThread {
	
	public void display() {
		System.out.println("SingleThread Ŭ������ display() �޼ҵ��� ��� ����");
		
		System.out.println("["+Thread.currentThread().getName()+"]�����忡 ���� main() �޼ҵ��� ��� �����");
		
		System.out.println("SingleThread Ŭ������ display() �޼ҵ��� ��� ���� ");
		
		//�ݺ����� �̿��Ͽ� a~z(���ĺ� �ҹ���)�� ���
		for(char i='a'; i<='z'; i++) {
			System.out.print(i);
		}
	}
	
}
