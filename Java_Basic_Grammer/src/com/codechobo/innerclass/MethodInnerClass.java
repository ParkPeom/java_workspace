package com.codechobo.innerclass;
//2. �޼ҵ忡 �����ϴ� ����Ŭ����
public class MethodInnerClass {
	String userid = "hong";
	String userpwd = "1234";
	
	MethodInnerClass(){
		
	}
	void innerClassTest() {
		//����Ŭ����
		class MethodInner{
			String username="�̼���";
			MethodInner(){
				
			}
			void getMemberOutput() {
				System.out.println("username="+ username);
				//�ܺ�Ŭ������ ��������� �����Ҽ� �ִ�.
				System.out.println("userid="+ userid);
				//�ܺ�Ŭ������ �޼ҵ带 ȣ���� �� �ִ�.
				memberOutput();
			}
		}
		////////////
		//�޼ҵ峻�� ����Ŭ������ �޼ҵ峻���� �� ��ü�� ������ �� �ִ�.
		
		MethodInner mi = new MethodInner();
		mi.getMemberOutput();
	}
	void memberOutput() {
		System.out.println("���̵�="+userid);
	}
	public static void main(String[] args) {
		new MethodInnerClass().innerClassTest();
	}

}
