package 싱글톤패턴;

// 멀티쓰레드에서의 싱글톤 -> 쓰레드 동기화 synchronized 사용

// 다양한 변화에 대응하기 위해 인터페이스의 형태로 관리하면 좋다.

public class Printer2 {
	
	private static Printer2 printer2 = new Printer2();
	
	private static int count = 0; // 공유 되는 데이터 
	
	private Printer2() {}
	
	public static Printer2 getInstance() {
		return printer2;
	}
	
	// print 메서드를 공유로쓰지않고 동기화 해버림 
	public synchronized static void print(String input) {
		count++;
		System.out.println(input + " count : " +  count);
	}
}
