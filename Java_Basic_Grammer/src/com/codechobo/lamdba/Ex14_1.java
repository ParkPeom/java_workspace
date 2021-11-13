package com.codechobo.lamdba;

@FunctionalInterface
interface MyFunction2 {
	void run(); // public abstract void run();
}

public class Ex14_1 {
	static void execute(MyFunction2 f) { // �Ű������� Ÿ���� MyFunction�� �޼���
						// �Ű������� ���ٽ��� ���� ���� 
		f.run();
	}
	
	static MyFunction2 getMyFunction() { // ��ȯŸ���� �������̽� �� MyFunction�� �޼���
		MyFunction2 f = () -> System.out.println("f3.run()"); // void run();
		return f;
	}
	public Ex14_1() {
	}
	public static void main(String[] args) {
		//���ٽ����� MyFunction�� run()�� ����
		MyFunction2 f1 = () -> System.out.println("f1.run()");
		
		MyFunction2 f2 = new MyFunction2() { // �͸�Ŭ������ run()�� ����
			public void run() { // public�� �ݵ�� �ٿ��� �Ѵ�
				System.out.println("f2.run()");
			}
		};
		MyFunction2 f3 = getMyFunction();
		
		// ���ٽ� ȣ�� 
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( ()-> System.out.println("run()"));
	}
}
