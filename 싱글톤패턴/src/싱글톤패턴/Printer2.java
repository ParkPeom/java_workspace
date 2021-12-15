package �̱�������;

// ��Ƽ�����忡���� �̱��� -> ������ ����ȭ synchronized ���

// �پ��� ��ȭ�� �����ϱ� ���� �������̽��� ���·� �����ϸ� ����.

public class Printer2 {
	
	private static Printer2 printer2 = new Printer2();
	
	private static int count = 0; // ���� �Ǵ� ������ 
	
	private Printer2() {}
	
	public static Printer2 getInstance() {
		return printer2;
	}
	
	// print �޼��带 �����ξ����ʰ� ����ȭ �ع��� 
	public synchronized static void print(String input) {
		count++;
		System.out.println(input + " count : " +  count);
	}
}
