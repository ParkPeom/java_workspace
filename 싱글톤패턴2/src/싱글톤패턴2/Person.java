package �̱�������2;

public class Person {
	// �ν��Ͻ��� ���� ���� -> �̱��� ���� 
	private final static Person p = new Person();

	private Person() {}

	public static Person getInstance() {
		return p;
	}
}


