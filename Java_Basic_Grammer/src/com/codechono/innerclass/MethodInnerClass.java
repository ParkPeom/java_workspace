package com.codechono.innerclass;

// �޼��� ���� ���� Ŭ���� 
public class MethodInnerClass {
	
	String userid = "hong";
	String userpwd = "1234";

	//������ ������ִ°� ���� - ���� ��Ӱ���
	public MethodInnerClass() {}
	
	void innerClassTest() {
		
		// �޼��� ����Ŭ����
		class MethodInner {
			String username = "�ڹ�";
			
			public MethodInner() {}
			void getMemberOutput() {
				System.out.println("username : " + username);
				// �ܺ�Ŭ������ ��������� �����Ҽ� �ִ�.
				System.out.println("userid : " + userid );
				// �ܺ�Ŭ������ �޼��带 ȣ���� �� �ִ�.
				System.out.println("userpwd : " + userpwd);
				memberOutput();
			}
			
		}
		////////////////// ���⼭�� ��ü�� ������ִ�.
		////////////////// ������ ���ο����� ��ü�� �����Ҽ�����
		// �޼����� ����Ŭ������ �޼��� ������ �� ��ü�� ������ �� �ִ�.
		MethodInner mi = new MethodInner();
		mi.getMemberOutput();
		
	}
	void memberOutput() {
		System.out.println("���̵� = " + userid);
	}
	
	
	public static void main(String[] args) {
		new MethodInnerClass().innerClassTest();
		// �ܺ�Ŭ������ ��ü�� �����ؼ� �޼��带 ȣ���ϸ� 
		// �޼����� ����Ŭ���� ��ü�� �޼��带 ȣ���Ҽ��ִ�.
		
		
		
	}
}
