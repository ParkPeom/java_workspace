package com.codechobo.collection;

import java.util.Stack;

public class StackTest {

	public StackTest() {
		
	}
	public void start() {
		// Stack : �Է¼����� �����Ѵ�.
		//		   �����Էµ� ��ü�� ���� ���߿� ��µȴ�. (FILO)
		//		   ��ü�� ������� ���ʹ��⿡�� �̷������.
		
		Stack<String> stack = new Stack<String>();

		stack.push("�迬��");
		stack.push("����ȯ"); // 4
		stack.push("�迬��");
		stack.push("�߽ż�");
		stack.push("���¹�"); // 1 ���� ��� 
		
		int idx = stack.search("���¹�"); 
		System.out.println(idx); // 1
		
		while(!stack.empty()) { // ������������� �۾� , ��������� true���� !
			System.out.println(stack.pop());
		}
	}
	public static void main(String[] args) {
		new StackTest().start();
	}
}
