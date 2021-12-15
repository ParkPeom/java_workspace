package �̱�������;

// ����Ŭ������ ����Ҽ� ���� ��� ���� ���� �������̽��� �����ϴ� ���
// �������̽��� ���� �޼��带 ������ ���� ������
// �̷� ��� ���� Ŭ������ ����Ҽ� ����. 

// 
public interface Printer3 {            // �پ��� ��ȭ�� �����ϱ� ���� �������̽��� ���·� �����ϸ� ����.
	
	public void print(String input);
}
class RealPrinter implements Printer3 { // �̱��� 
	
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
