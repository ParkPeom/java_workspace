package xyz.itwill.dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Properties ���� : ���α׷� ���࿡ �ʿ��� ���� �����ϱ� ���� �ؽ�Ʈ ���� - Ȯ���� : XXX.properties
// => ���α׷��� �����ϰ� �ʰ� Properties ������ ������ �����Ͽ� ���α׷� ���� ����� ���� ����
// => ���α׷��� �������� ȿ���� ����
// => Properties ���Ͽ����� ���� ������ ���ڿ��θ� ����
// => Properties ���Ͽ����� ������, ����, �Ϻ� Ư�����ڸ� ������ ���ڴ� �����ڵ�� ǥ��

//user.properties ���Ͽ� ���� �����Ǵ� ���� ����ϴ� ���α׷�
public class PropertiesApp {
	public static void main(String[] args) throws IOException {
		//Properties ������ �б� ���� (���� �Է½�Ʈ��) ����
		
		//FileInputStream Ŭ������ �̿��Ͽ� ���� �Է½�Ʈ�� ���� - ���� ��� ���� ���� �߻�
		//FileInputStream in=new FileInputStream("src/xyz/itwill/jdbc/user.properties");
		
		// �׷��� Ŭ�����δ��� �̿��ϸ�
		
		// �޸𸮿� ����� Ŭ������ Class �ν��Ͻ�(Clazz)�� �����޴� ���
		// 1.Class.forName(String className) : ���ڿ��� ǥ���� Ŭ������ �޸𸮿� �����ϰ�
		// Ŭ������ ��ġ�� ���� ������ ������ �����ִ�.
		
		// ����� Ŭ������ Class �ν��Ͻ�(Clazz)�� ��ȯ�ϴ� �޼ҵ� ȣ��
		//2.Object.getClass() : ���� ������� Ŭ������ Class �ν��Ͻ��� ��ȯ
		//3.Ŭ������.class: �޸𸮿� ����� Ŭ������ ���� Class �ν��Ͻ��� ǥ���Ͽ� ���
		
		//ClassLoader ���α׷��� �̿��� �Է½�Ʈ�� ���� - ���� ��� ���� ���� �̹߻�
		//Ŭ������.class : �޸𸮿� ����� Ŭ����(Class �ν��Ͻ� - Clazz)�� ���� ǥ���ϴ� ���
		//Class.getClassLoader() : Ŭ������ �о� �޸𸮿� �����ϴ� ����� �����ϴ� 
		//ClassLoader �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
		//ClassLoader.getResourceAsStream(String resource) : ���ҽ� ������ ���޹޾� ������
		//�б� ���� �Է½�Ʈ���� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		// ���� Ŭ�����̸��� �о����  ��ü�� Ŭ��� �� 
		InputStream in = PropertiesApp.class.getClassLoader().getResourceAsStream("xyz/itwill/dbcp/user.properties"); // �ڿ��� ��θ� �о���ϼ��ִ� ���ҽ��� ���� ��Ʈ���� �����޶�  
							// ���ҽ������� ���޹޾� �ν��Ͻ��� ��ȯ Ŭ������ �о� �޸𸮿� ���� 
		
		//Properties Ŭ������ �ν��Ͻ� ����
		// => Properties Ŭ������ Map �������̽��� ��ӹ��� �ݷ��� Ŭ����
		// => Properties �ν��Ͻ��� �ĺ���(Key)�� ��(Value)�� �ϳ��� ��Ʈ��(Entry)�� ó���Ͽ� ����
		Properties properties=new Properties();
		
		//Properties.load(InputStream in) : Properties ���Ͽ� ����� ��� ��Ʈ��(Key�� Value �ϳ��� ��)��
		//���� Properties �ν��Ͻ��� ��Ʈ���� �߰��ϴ� �޼ҵ�
		properties.load(in);
		
		//Properties �ν��Ͻ��� ����� ��Ʈ�� �� �ĺ���(Key)�� ����Ͽ� ��(Value)�� ��ȯ�޾� ����
		//Properties.get(String key) : Properties �ν��Ͻ��� ����� ��Ʈ�� �� �ĺ���(Key)�� 
		//��(Value)�� ��ȯ�ϴ� �޼ҵ�
		// => ��ȯ���� Object Ÿ������ ��ȯ�ǹǷ� �ݵ�� ����� ��ü ����ȯ�Ͽ� ����
		
		// Ű���� ���� 
		String id=(String)properties.get("id");
		String password=(String)properties.get("password");
		String name=(String)properties.get("name");
		
		
		// value 
		System.out.println("���̵� = "+id);
		System.out.println("��й�ȣ = "+password);
		System.out.println("�̸� = "+name);
	}
}

















