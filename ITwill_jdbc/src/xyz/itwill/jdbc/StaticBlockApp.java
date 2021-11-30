package xyz.itwill.jdbc;

public class StaticBlockApp {

	public static void main(String[] args) {
		/*
		// ClassLoader ���α׷��� ���� Ŭ����(Class ����)�� �о� �޸𸮿� ���� - �ڵ�(1��)
		// �������÷��� - ���޸𸮿� ���ߴ����°� ������
		// new �����ڰ� �޸𸮿� ����� Ŭ����(Clazz)-����ƽ�޸� �� �����ڸ� ȣ���Ͽ� �ν��Ͻ��� �����Ѵ�.
		// => ������ �ν��Ͻ��� ���������� ���� 
		StaticBlock sb = new StaticBlock();
		
		// ���������� ����� �ν��Ͻ��� �޼��� ȣ�� - ��� ���� 
		sb.display();
		*/
		
		/*
		try {
			//Class : Ŭ���� ����(Clazz)�� �����ϱ� ���� Ŭ���� 
			// �� ��ġ�� �о�� Ŭ�����(�޸𸮿� �ε������ִ� ����)
			// Class.forName(String ClassName) : ���ڿ��� ǥ���� ��Ű���� ������ Ŭ������ ���޹޾�
			// ClassLoader ���α׷��� �̿��Ͽ� Ŭ������ �о� �޸𸮿� �����ϴ� �޼���
			// => �޸𸮿� ����� Ŭ���� ����(Class �ν��Ͻ� - Clazz) ��ȯ
			// => ClassNotFoundException �߻� - �ݵ�� ����ó��
			// => Class.Instance() : �޸𸮿� ����� Ŭ����(Clazz)�� �̿��Ͽ� �ν��Ͻ��� �����ϴ� �޼���
			// => Object Ÿ���� �ν��Ͻ� ��ȯ - ����� ��ü ����ȯ 
			// JVM�� ���ִ°� Class.forName() ���� ���ش�. 
			// InstantiationException | ClassNotFoundException �߻� - ���� ó��
			// Object Ÿ���� �ν��Ͻ� ��ȯ - ����� ��ü ����ȯ
			
			// JDK10 �̻󿡼��� Class.getDeclaredConstructor() �޼���� �����ڸ� ��ȯ�޾�
			// newInstance() �޼��带 ȣ���Ͽ� �ν��Ͻ� ���� ( jvm�� �����޶�� �ϴ°� �ƴ϶� ���� ���� ����
			// newInstance() �޼��带 �ν��Ͻ��� ���� �����ϴ� 
			// ���÷��� : �ν��Ͻ��� ���� �����ϴ� ����ϴ� ���
			// => ���� �����ڿ� ������� Ŭ���� ��� ���� ���� 
			StaticBlock sb = (StaticBlock)Class.forName("xyz.itwill.jdbc.StaticBlock").getDeclaredConstructor().newInstance(); // Ŭ������ �о��༭ Ŭ����� �޸𸮿� �����޶�� �޼���
			sb.display();
		} catch ( InstantiationException | ClassNotFoundException e) {
			System.out.println("[����]Ŭ������ ã�� �� �����ϴ�.");
		} catch(Exception e) {
			System.out.println("[����]���� ���α׷��� ������ �߻� �Ͽ����ϴ�.");
		}	
		*/
		try {
			Class.forName("xyz.itwill.jdbc.StaticBlock"); // ��Ű����.Ŭ������ 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
