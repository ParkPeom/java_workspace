package com.codechobo.thread;

public class MyThread5 extends Thread {

	public MyThread5() {
	}
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("MyThread5 : " + i);
			try {
				Thread.sleep(500); // 0.5 초씩 쉬게함 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
