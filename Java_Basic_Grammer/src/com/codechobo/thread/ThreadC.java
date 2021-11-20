package com.codechobo.thread;

public class ThreadC extends Thread {

	public ThreadC() {
	}
	public void run() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		
		
	}
}
