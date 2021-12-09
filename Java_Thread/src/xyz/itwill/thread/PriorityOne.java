package xyz.itwill.thread;

public class PriorityOne extends Thread {
	
	@Override
	public void run() {
		while(true) { // 무한루프 
			System.out.print("A");
		}
	}
}
