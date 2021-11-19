package com.codechobo.thread;

public class ThreadB extends Thread {
	int total;
	
	public void run() {
		synchronized (this) { 	//동기화
			for(int i = 0; i < 5; i++) {
				System.out.println(i+"를 더합니다.");
				total += i;
				try {
					Thread.sleep(500);  // 0.5초 쉰다.
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		notify();// main스레드를 깨움
		}
	}
}
