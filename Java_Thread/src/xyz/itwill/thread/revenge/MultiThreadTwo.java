package xyz.itwill.thread.revenge;

public class MultiThreadTwo implements Runnable { // Runnable �������̽��� ��ӹ��� �ڽ� Ŭ���� ���� 
	@Override
	public void run() {
		for (int i = 'a'; i <= 'z'; i++) {
			System.out.print(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
