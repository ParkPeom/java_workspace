package xyz.itwill.thread;

//다중 스레드 프로그램 - 개발자가 스레드를 생성하여 main 스레드와는 달리 다른 명령을 실행하는 프로그램
// => 모든 스레드가 소멸되어야만 프로그램이 종료 
public class MultiThreadApp {
	//main 메소드로 전달되는 모든 예외는 JVM에서 자동으로 예외 처리 
	public static void main(String[] args) throws InterruptedException {
		//JVM에 의해 main스레드 자동 생성
		// => main 스레드는 main() 메소드를 자동 호출하여 명령 실행 
		
		/*
		Thread thread = new Thread(); //Thread 인스턴스 생성
		//Thread.start() : Thread 인스턴스를 이용하여 새로운 스레드를 생성하는 메소드
		// => 새롭게 생성된 스레드는 Thread 인스턴스의 run() 메소드를 자동 호출하여 명령 실행 
		// Thread 인스턴스에 선언된 run() 메소드에는 실행될 명령 미존재 
		// => Thread 클래스를 상속받은 자식클래스를 작성하여 run() 메소드 오버라이드 선언
		thread.start();
		*/
		
		// Thread 클래스를 상속받은 자식클래스로 인스턴스 생성 - Thread 인스턴스 생성 
		// => 자식 클래스의 인스턴스가 생성되기 전에 부모 클래스(Thread 인스턴스)가  먼저 생성된다. 
		//부모클래스의 인스턴스로 start() 메소드를 호출하여 새로운 스레드가 생성된다.
		// => 새롭게 생성된 스레드는 자식 클래스의 인스턴스의 run() 메소드를 호출하여 명령 실행
		// => main 스레드와 새롭게 생성된 스레드는 서로 다른 스레드로 명령을 실행 
		//= > 새롭게 생성된 스레드는 자식 인스턴스를 실행하고
		//   run() 메소드의 명령을 동시에 실행 가능(동시에 보이지만 동시가 아님 먼저온애가 먼저실행)
		/*
		MultiThreadOne thread = new MultiThreadOne();
		thread.start();
		*/
		
		//하나의 Thread 인스턴스는 하나의 스레드만 생성 - 인스턴스를 저장한 참조변수 미사용
		new MultiThreadOne().start(); // 메소드를 한번만 호출 하는 방법 
		new MultiThreadOne().start();
		
		/*
		//Runnable 인터페이스를 상속받은 자식클래스로 인스턴스 생성
		MultiThreadTwo two = new MultiThreadTwo();
		//Thread(Runnable target) : Runnable 인터페이스를 상속받은 자식 인스턴스의 매개변수로 
		//전달받아 Thread 인스턴스 생성 
		// => 내부적으로 자식인스턴스의 run() 메소드를 오버라이드 선언한 것과 동일하게 처리
		Thread thread = new Thread(two);
		//Thread 인스턴스로 새로운 스레드를 생성하여  Runnable 인터페이스를 상속받은 자식 
		// 인스턴스의 run() 메소드가 자동 호출되어 명령 실행
		// ex) 배경 총알 비행기 따로따로 실행하게 된다.
		thread.start();
		*/
		
		// Runnable 인터페이스를 사용하는 이유 
		// => 자식클래스가 Thread 클래스를 상속받지 못할 경우 Runnable 인터페이스 사용 
		new Thread(new MultiThreadTwo()).start();
		
		for(int i = 0; i <= 9; i++) {
			System.out.print(i);
			// 01abcdefghijklmnopqrstuvwxyz23456789 순서가 정해지지않은채 실행됨
			
			//Thread.sleep(long ms) : 현재 명령을 실행하는 스레드를 매개변수에 
			// 전달된 시간(ms)만큼 일시 중지하는 메소드 
			// 너무 크게 잡으면 데드락 걸림 (죽어버림)
			// => InterruptedException 발생 - 예외처리 하지 않을 경우 에러 발생 (예외 전달 가능)
			Thread.sleep(500);
			
		}
	}
}
