package 싱글톤패턴;

// 정적클래스를 사용할수 없는 경우 또한 존재 인터페이스를 구현하는 경우
// 인터페이스가 정적 메서드를 가질수 없기 때문에
// 이런 경우 정적 클래스를 사용할수 없다. 

// 
public interface Printer3 {            // 다양한 변화에 대응하기 위해 인터페이스의 형태로 관리하면 좋다.
	
	public void print(String input);
}
class RealPrinter implements Printer3 { // 싱글톤 
	
	private static Printer3 printer = null;
	public synchronized static Printer3 getInstance() {
		if(printer == null) {
			printer = new RealPrinter();
		}
		return printer;
	}
	@Override
	public void print(String input) {
		System.out.println(input);
	}
}
class UsePrinter {
	public void doSomething(Printer3 printer) { // 3
		System.out.print("fakeGet"); // 4
	}
}
class FakePrinter implements Printer3 {
	private String str;
	
	@Override
	public void print(String input) {
		this.str = str;
	}	
	public String get() {
		return str;
	}
}
class UsePrinterTest {
	void testdoSomething() {
		FakePrinter fake = new FakePrinter(); // 1
		UsePrinter use = new UsePrinter();
		use.doSomething(fake); // 2
		
		// assertThat("fakeGet").isEqualTo(fake.get());
	}
}
