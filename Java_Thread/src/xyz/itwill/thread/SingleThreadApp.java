package xyz.itwill.thread;

//프로그램 실행시 JVM이 main() 메서드를 호출하여 실행하기 위해 자동으로 main 스레드 생성 
// => main 스레드가 main() 메서드의 명령을 읽어 실행 
// => main 스레드만 이용하여 프로그램 작성 : 단일 스레드 프로그램 
// => 단일 스레드 프로그램은 main() 메소드가 종료되면 main 스레드 소멸 -  프로그램 종료
// => 인터프리터 방식 : 스레드가 명령 하나를 읽어들어 cpu가 그 명령을 처리 또 명령하나를 읽어들어 cpu가 명령을 처리


// 우리가 만드는 Swing 프로그램은 기본적으로 다중스레드 프로그램이다. 

public class SingleThreadApp {	
	public static void main(String[] args) {
		/*
		System.out.println("SingleThread 클래스의 main() 메서드에 명령 시작");
		
		//Thread : 스레드 관련 정보와 기능을 제공하기 위한 클래스
		//Thread.currentThread() : 현재 명령을 실행하는 Thread인스턴스를 반환하는 메소드
		//Thread.getName() : 스레드에 부여된 이름(식별자)을 반환하는 메소드
		
		System.out.println("["+Thread.currentThread().getName()+"]스레드에 의해 main() 메소드의 명령 실행되고 있어요");
		
		//인스턴스를 생성하여 메소드 호출하면 인스턴스 메소드로  스레드가 이동되어 메소드의
		//명령 실행 - 인스턴스 메소드가 종료되면 스레드 자동으로 복귀하여 하단에 작성된 명령 실행  
		new SingleThread().display(); // 인스턴스를 생성하고 메소드 호출 (메소드한번만 호출)
		
		System.out.println("SingleThread 클래스의 main() 메서드에 명령 종료");
		*/
		
		// 반복문을 이용하여 A~Z(알파벳 대문자)를 출력 
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
		new SingleThread().display(); // 호출 스레드가 이동 
		
		// 스레드 복귀 
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.print(i);
		}
	}
}
