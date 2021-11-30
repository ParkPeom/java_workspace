package xyz.itwill.jdbc;

public class StaticBlock {

	// ��������(Static Block) : ClassLoader ���α׷��� ���� Ŭ������ �޸𸮿� ����� �� 
	// �ڵ����� ����� ����� �ۼ��ϴ� ���� - ���� ������ ����� ���α׷����� �ѹ��� ���� 
	static {
		System.out.println("### StaticBlock Ŭ������ ���������� �ۼ��� ��� ���� ###");
		StaticBlock sb = new StaticBlock();
		sb.display();	
	}

	public StaticBlock() {
	}	
	public void display() {
		System.out.println("## StaticBlock Ŭ������ display() ȣ��");		
	}
}



