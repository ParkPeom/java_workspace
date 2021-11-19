package com.codechobo.thread;

public class ThreadTest extends Thread {
	String str;
	public ThreadTest() {
	}
	public ThreadTest(String str) {
		this.str = str;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(str);
		}
	}
}
