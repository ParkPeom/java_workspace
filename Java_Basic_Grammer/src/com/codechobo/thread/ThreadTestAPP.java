package com.codechobo.thread;

public class ThreadTestAPP {
	public ThreadTestAPP() {
	}
	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest("��");
		RunnableApp t2 = new RunnableApp("��");
		Thread t3 = new Thread(t2);
		t1.start(); 
		t3.start();
		System.out.println("Main End----------");
	}
}
