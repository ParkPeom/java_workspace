package com.codechobo.thread;

public class ThreadA {

	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start(); // 해당 스레드 시작 
		
		// 해당 스레드는 run메서드안에서 자신의 모니터링 락을 흭득
		// 동기화 블록 synchronized (this) 
		synchronized (b) { // 해당 메인 부분은 기다리게 됨 
			// 안에서 동작을 할수있도록 한다.
			try {
				System.out.println("b가 완료될때까지 기다립니다.");
				b.wait(); // Main 스레드는 정지된다. 
						  // notify 를 해야지 깨어난다. 
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			// notify() 로 main 스레드는 깨어나고 자기의일을 수행
			System.out.println("Total is : "+ b.total);
		}
	}
}
