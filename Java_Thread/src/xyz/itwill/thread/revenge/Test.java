package xyz.itwill.thread.revenge;

public class Test {

	private static  Test test;
	
	private Test() {
		
		test = null;
	}		
	
	private static Test getInstance() {
		test = new Test();
		return test;
	}
	
	public static void main(String[] args) {
		
		Test t = Test.getInstance();
		
		System.out.println(t);
		
	}
}
