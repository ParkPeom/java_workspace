package xyz.itwill.thread.revenge;

public class MultiThreadOne extends Thread {
	
	// ���ν������ ������ ���� 
	public void run() {
		for(char i='a'; i<='z'; i++) {
			System.out.print(i);
		try {
			Thread.sleep(500); // 0.5�� 
		} catch (InterruptedException e) {
			e.printStackTrace();
			} 
		}
	}
}
