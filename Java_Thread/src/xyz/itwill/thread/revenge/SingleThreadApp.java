package xyz.itwill.thread.revenge;

public class SingleThreadApp {
	
	public static void main(String[] args) {
		
		System.out.println("SingleThread 클래스의 main() 메소드에 명령 시작 ");
		
		System.out.println(Thread.currentThread().getName()); // main
		
		new SingleThread().display();
		
		for(char i='A'; i<='Z'; i++) {
			System.out.print(i);
		}
		
		new SingleThread().display(); // 호출 스레드가 이동
		
		for(int i='A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
		
		new SingleThread().display();
		
		for(int i = 'A'; i<='Z'; i++) {
			System.out.print(i);
		}
	}
}
