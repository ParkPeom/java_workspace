package com.codechobo.thread;

public class ThreadB extends Thread {
	int total;
	
	public void run() {
		synchronized (this) { 	//����ȭ
			for(int i = 0; i < 5; i++) {
				System.out.println(i+"�� ���մϴ�.");
				total += i;
				try {
					Thread.sleep(500);  // 0.5�� ����.
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		notify();// main�����带 ����
		}
	}
}
