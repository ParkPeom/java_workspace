package xyz.itwill.thread;

public class PriorityOne extends Thread {
	
	@Override
	public void run() {
		while(true) { // ���ѷ��� 
			System.out.print("A");
		}
	}
}
