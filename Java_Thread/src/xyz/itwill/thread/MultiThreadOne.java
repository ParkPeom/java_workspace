package xyz.itwill.thread;

import javax.swing.JOptionPane;

//Thread 클래스를 상속받은 자식클래스 - 반드시 run() 메소드 오버라이드 선언
public class MultiThreadOne extends Thread {
	//자식클래스의 인스턴스로 생성된 새로운 스레드가 실행할 명령을 작성하는 메소드
	
	// 메인스레드와 별개로 실행됨 
	@Override
	public void run() {
		// 메인스레드가 종료되도 새롭게 생성된 스레드는 실행됨 
		for(char i='a'; i <= 'z'; i++) {
			System.out.print(i);
			
			// 오버라이드 선언된 메소드는 예외 전달 불가능 
			try {
				Thread.sleep(500);
				// 출력하고 0.5초 쉼
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
}
