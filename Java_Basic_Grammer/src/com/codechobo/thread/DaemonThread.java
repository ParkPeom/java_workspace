package com.codechobo.thread;

public class DaemonThread implements Runnable {
	
	public DaemonThread() {}
	@Override
	public void run() {
		// 무한루프 0.5초씩 데몬스레드가 실행중입니다. 작성해봄
		while(true) {
			System.out.println("데몬 스레드가 실행중입니다. ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
	public static void main(String[] args) {
		Thread thread = new Thread(new DaemonThread());
		thread.setDaemon(true); // 데몬스레드로 설정
		thread.start(); // 데몬스레드가 종료가되면 모든 스레드가 종료됨
		
		// 메인스레드 자체에 sleep 1초정도 있다가 종료
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 메인스레드가 종료되니까 데몬스레드도 종료된다.
	System.out.println("메인 스레드가 종료 됩니다.");	
	}
}
