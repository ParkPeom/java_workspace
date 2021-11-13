package com.codechobo.itwill.collection;
import java.util.Stack;

public class StackTest {

	public StackTest() {
		
	}
	public void start() {
		// Stack : �Է¼����� �����Ѵ�.
		//         �����Էµ� ��ü�� ���� ���߿� ��µȴ�. (FILO)
		//         ��ü�� ������� ���ʹ��⿡�� �̷������.
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("�迬��");
		stack.push("����ȯ");
		stack.push("�迬��");
		stack.push("�߽ż�");
		stack.push("���¹�");
		
		int idx = stack.search("����ȯ");
		System.out.println(idx);
		
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
	}
	public static void main(String[] args) {		
		new StackTest().start();
	}
}
