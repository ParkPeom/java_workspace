package xyz.itwill.thread;

public class SingleThread {
	
	public void display() {
		/*
		System.out.println("SingleThread 클래스의 display() 메서드에 명령 시작");
		
		System.out.println("["+Thread.currentThread().getName()+"]스레드에 의해 main() 메소드의 명령 실행되고 있어요");
		
		System.out.println("SingleThread 클래스의 display() 메서드에 명령 종료");
		*/
		// 반복문을 이용하여 a~z(알파벳 소문자)를 출력 
		for(char i = 'a'; i <= 'z'; i++) {
			System.out.print(i);
		}
	}
}
