package xyz.itwill.thread.revenge;

public class MultiThreadApp {
	
	public static void main(String[] args) throws InterruptedException {
	
		Thread thread = new Thread();
		
		thread.start(); // run �޼ҵ� ���� ����� ��� ������
		
		
		new MultiThreadOne().start(); // �ڽ�Ŭ������ �ν��Ͻ��� �����Ǳ� ���� �θ�Ŭ����(Thread �ν��Ͻ��� ���� ����)
		
		new MultiThreadOne().start();
		
		// Runnable �������̽� ��� ���� >> �ڽ� Ŭ������ Thread Ŭ������ ��ӹ��� ���� ��� Runnable �������̽� ��� ( ����� ���ϻ�Ӹ� �Ǵϱ� ) 
		new Thread(new MultiThreadTwo()).start();
		
		for (int i = 0; i <= 9; i++) {
			System.out.print(i);
		}
		Thread.sleep(500);
	}
}
