package xyz.itwill.thread;

// Runnable �������̽��� ��ӹ��� �ڽ� Ŭ���� ����
// => �������̽��� run() �޼ҵ带 ������ �������̵� ����  
public class MultiThreadTwo implements Runnable {
	@Override
	public void run() {
		for(char i = 'a'; i <= 'z'; i++) {
			System.out.print(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
