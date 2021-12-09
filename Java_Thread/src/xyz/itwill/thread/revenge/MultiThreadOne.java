package xyz.itwill.thread.revenge;

public class MultiThreadOne extends Thread {
	
	// 메인스레드와 별개로 실행 
	public void run() {
		for(char i='a'; i<='z'; i++) {
			System.out.print(i);
		try {
			Thread.sleep(500); // 0.5초 
		} catch (InterruptedException e) {
			e.printStackTrace();
			} 
		}
	}
}
