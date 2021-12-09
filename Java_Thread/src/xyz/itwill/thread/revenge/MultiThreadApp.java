package xyz.itwill.thread.revenge;

public class MultiThreadApp {
	
	public static void main(String[] args) throws InterruptedException {
	
		Thread thread = new Thread();
		
		thread.start(); // run 메소드 에는 실행될 명령 미존재
		
		
		new MultiThreadOne().start(); // 자식클래스의 인스턴스가 생성되기 전에 부모클래스(Thread 인스턴스가 먼저 생성)
		
		new MultiThreadOne().start();
		
		// Runnable 인터페이스 사용 이유 >> 자식 클래스가 Thread 클래스를 상속받지 못할 경우 Runnable 인터페이스 사용 ( 상속은 단일상속만 되니까 ) 
		new Thread(new MultiThreadTwo()).start();
		
		for (int i = 0; i <= 9; i++) {
			System.out.print(i);
		}
		Thread.sleep(500);
	}
}
