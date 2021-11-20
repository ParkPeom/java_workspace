package com.codechobo.threadProgrammers;

public class MyThread1 extends Thread {

	String str;
	public MyThread1(String str) {
		this.str = str;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println(str);
			
		}
	}
	
	public static void main(String[] args) {
		
	}
}
