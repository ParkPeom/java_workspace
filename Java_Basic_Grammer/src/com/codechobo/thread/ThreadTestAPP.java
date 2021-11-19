package com.codechobo.thread;

public class ThreadTestAPP {
	public ThreadTestAPP() {
	}
	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest("¡Ú");
		RunnableApp t2 = new RunnableApp("¢¾");
		Thread t3 = new Thread(t2);
		t1.start(); 
		t3.start();
		System.out.println("Main End----------");
	}
}
