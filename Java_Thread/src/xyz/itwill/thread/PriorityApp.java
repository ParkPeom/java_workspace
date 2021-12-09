package xyz.itwill.thread;

public class PriorityApp {
	
	public static void main(String[] args) {
		
		PriorityOne one = new PriorityOne();
		PriorityTwo two = new PriorityTwo();
		
		//Thread.setPriority(int priority) : 스레드의 우선순위를 변경하는 메소드
		// 스레드의 우선순위는 정수값으로 클수록 우선순위가 높도록 설정
		// => 스레드 우선 순위 범위 : 1(MIN_PRIORITY) 10(MAX_PRIORITY)  1~10 기본값 5
		one.setPriority(Thread.MIN_PRIORITY);
		two.setPriority(Thread.MAX_PRIORITY);
		
		one.start();
		two.start();
	}
}
