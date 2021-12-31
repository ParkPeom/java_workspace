package xyz.itwill.thread.revenge;

class odskdsd {
	static int count = 5000;
}
class MyThread3 extends Thread {
	
	public void run() {
		odskdsd.count -= 500;
	}
}
public class MyThread2 implements Runnable {

	@Override
	public void run() {
		odskdsd.count += 3000;
	}
	public static void main(String[] args) {
		
		// ´ÙÇü¼º
		Runnable r = new MyThread2();
		Thread th = new Thread(r);
		Thread th2 = new MyThread3();
		th.start();
		th2.start();
		System.out.println(odskdsd.count);
	}
}
