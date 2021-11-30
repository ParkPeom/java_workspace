package xyz.itwill.jdbc;

public class StaticBlock {

	// 정적영역(Static Block) : ClassLoader 프로그램에 의해 클래스가 메모리에 저장된 후 
	// 자동으로 실행될 명령을 작성하는 영역 - 정적 영역의 명령은 프로그램에서 한번만 실행 
	static {
		System.out.println("### StaticBlock 클래스의 정적영역에 작성된 명령 실행 ###");
		StaticBlock sb = new StaticBlock();
		sb.display();	
	}

	public StaticBlock() {
	}	
	public void display() {
		System.out.println("## StaticBlock 클래스의 display() 호출");		
	}
}



