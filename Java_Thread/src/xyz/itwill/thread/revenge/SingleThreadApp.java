package xyz.itwill.thread.revenge;

public class SingleThreadApp {
	
	public static void main(String[] args) {
		
		System.out.println("SingleThread Ŭ������ main() �޼ҵ忡 ��� ���� ");
		
		System.out.println(Thread.currentThread().getName()); // main
		
		new SingleThread().display();
		
		for(char i='A'; i<='Z'; i++) {
			System.out.print(i);
		}
		
		new SingleThread().display(); // ȣ�� �����尡 �̵�
		
		for(int i='A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
		
		new SingleThread().display();
		
		for(int i = 'A'; i<='Z'; i++) {
			System.out.print(i);
		}
	}
}
