package xyz.itwill.thread;

// Runnable 인터페이스를 상속받은 자식 클래스 생성
// => 인터페이스의 run() 메소드를 무조건 오버라이드 선언  
public class MultiThreadTwo implements Runnable {
	@Override
	public void run() {
		for(char i = 'a'; i <= 'z'; i++) {
			System.out.print(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
