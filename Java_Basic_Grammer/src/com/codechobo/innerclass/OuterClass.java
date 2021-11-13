package com.codechobo.innerclass;
//����Ŭ������ Ŭ�������� �����ϴ� Ŭ�����̴�.
//1. Ŭ������ ��������� �����ϴ� ����Ŭ����
//2. �޼ҵ忡 �����ϴ� ����Ŭ����
//3. Ŭ�������� �������� �ʴ� �͸�(anonymous)�� ����Ŭ����
public class OuterClass {
	//��������� ����
	//�������
	//  static{}
	int num = 100;
	String name = "ȫ�浿";
	
	//������
	OuterClass(){
		//�ܺ�Ŭ�������� ���� Ŭ������ ��� ������ �����Ҽ� ����.
		//System.out.println("�ּ�="+ addr);
		System.out.println("OuterClass()->�����");
		
		//�ܺ�Ŭ�������� ���� Ŭ������ �޼ҵ�� ȣ���Ҽ� ����.
		//int r = sumResult(10, 20);
	}
	
	//�޼ҵ�
	void method() {
		//����Ŭ���� ���� ���� Ŭ������ ��ü�����Ͽ� �޼ҵ� ȣ���ϱ�
		InnerClass ii = new InnerClass();
		ii.memberOutput();
		
	}
	void message() {
		System.out.println("�ܺ� Ŭ������ message()�޼ҵ� �����.");
	}
	//����Ŭ����
	//������ ���� �����ϴ�.
	public class InnerClass{
		//�������
		String userid = "hong";
		String addr = "����� ������";
		//�����ڸ޼ҵ�
		InnerClass(){
			System.out.println("InnerClass()->�����");
		}
		InnerClass(String addr){
			this.addr = addr;
			System.out.println("InnerClass(String addr)->�����");
		}
		//�޼ҵ�
		void memberOutput() {
			System.out.println("���̵�="+userid);
			System.out.println("�ּ�="+addr);
			//����Ŭ�������� �ܺ� Ŭ������ ��������� �����Ҽ� �ִ�.
			System.out.println("�̸�="+name);	
			//�ܺ�Ŭ������ �޼ҵ�� ����Ŭ�������� ȣ�Ⱑ���ϴ�.
			message();
		}
		int sumResult(int n1, int n2) {
			return n1+n2;
		}
	}	
	
	public static void main(String[] args) {		
		//����Ŭ���� ��ü ������� 1
		//�ٸ� Ŭ�������� ����Ŭ���� ��ü �����Ͽ� �޼ҵ带 ȣ���� �� �ִ�.
		// �ܺ�Ŭ������ ���� ��ü ����
		OuterClass oc = new OuterClass();
		
		// �ܺ�Ŭ���� ��ü�� ���� ���� Ŭ���� ��ü�� �����Ҽ� �ִ�.
		OuterClass.InnerClass ic = oc.new InnerClass();
		
		ic.memberOutput();
		
		//����Ŭ���� ��ü������� 2
		OuterClass.InnerClass ic2 = new OuterClass().new InnerClass();
		ic2.memberOutput();
		
		oc.method();
	}
}
