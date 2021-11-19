package com.codechobo.thread;

public class RunnableApp implements Runnable {
	
	String str;
	
	public RunnableApp() {
	}
	public RunnableApp(String str){
		this.str = str;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(str);
		}
	}
}
