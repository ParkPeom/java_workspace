package xyz.itwill.thread.revenge;

public class MultiThreadTwo implements Runnable { // Runnable 인터페이스를 상속받은 자식 클래스 생성 
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
