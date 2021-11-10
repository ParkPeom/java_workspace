package com.codechono.innerclass;
//����Ŭ������ Ŭ�������� �����ϴ� Ŭ�����̴�.
// 1.Ŭ������ ��������� �����ϴ� ����Ŭ����
// 2.�޼��忡 �����ϴ� ����Ŭ����
// 3.Ŭ�������� �������� �ʴ� �͸�(anonymous)�� ����Ŭ���� 

// �ܺ�Ŭ���� = ���� �θ��� ���� 
public class OuterClass {
	//��������� ����
	//�������
	// static{}
	// �ܺο� �ִ� �������
	
	int num = 100;
	String name = "ȫ�浿";

	
	//������ 
	OuterClass() {
		System.out.println("OuterClass()->�����");
//		System.out.println("�ּ� : " + addr); ���� ��� ����
//		�ܺ�Ŭ�������� ���� Ŭ������ ��� ������ �����Ҽ� ����.		
		
		// �ܺ�Ŭ�������� ���� Ŭ������ �޼���� ȣ���� �� ����.
		// int r = ic.sumResult(10,20);
		
		
	}
	//�޼���
	void method() {
		// ����Ŭ������ ���� ���� Ŭ������ ��ü�����Ͽ� �޼��� ȣ���ϱ�
		InnerClass ii = new InnerClass();
		ii.memberOutput();
	}
	
	void message() {
		System.out.println("�ܺ� Ŭ������ message() �޼��� �����.");
	}
	
	//����Ŭ���� = �ڽ� 
	public class InnerClass {
		//���ο� �ִ� �������
		String userid = "hong";
		String addr = "����� ������";
		
		// ������ �޼���
		InnerClass() {
			System.out.println("InnerClass()->�����");
		}
		InnerClass(String addr){
			this.addr = addr;
			System.out.println("InnerClass(String addr)->�����");
		}
		// �޼���
		void memberOutput() {
			System.out.println("���̵� : " + userid);
			System.out.println("�ּ� : " + addr);
			// ����Ŭ�������� �ܺ�Ŭ���� ��� �������� 
			System.out.println("�̸� : " + name);
			// �ܺ�Ŭ������ �޼���� ���� Ŭ�������� ȣ�� �����ϴ�. 
			message();
		}
		
		int sumResult(int n1,int n2) {
			return n1+n2;
		}
	}
	
	public static void main(String[] args) {
		// �ٸ� Ŭ�������� ���� Ŭ���� ��ü �����Ͽ� �޼��带 ȣ���Ҽ��ִ�.
		// 1. �ܺ� Ŭ������ ���� ��ü ����
		OuterClass oc = new OuterClass();
		OuterClass.InnerClass ic = oc.new InnerClass();
		// 2. �ܺ� Ŭ���� ��ü�� ���� ���� Ŭ���� ��ü�� ������ �� �ִ�.
	
		// 3. �ܺθ� ����� ���θ� ������ ���ϸ� �������� ����
		ic.memberOutput();
		System.out.println("========================");
		// ���� Ŭ���� ��ü ���� ��� 2  
		// �ѹ��� ����� ���
		OuterClass.InnerClass ic2 = new OuterClass().new InnerClass();
		ic2.memberOutput();
		
		System.out.println("========================");
		oc.method();
		
	}
}
